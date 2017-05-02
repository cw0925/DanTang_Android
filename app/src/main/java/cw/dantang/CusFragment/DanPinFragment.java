package cw.dantang.CusFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import cw.dantang.CusAdapter.RecycleAdapter;
import cw.dantang.CusNavigationBar.NavigationBar;
import cw.dantang.Model.DanPinModel;
import cw.dantang.R;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by cw on 2017/4/27.
 */

public class DanPinFragment extends Fragment {

    private List<DanPinModel> listData = new ArrayList<>();
    private GridLayoutManager mLayoutManager;
    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;

    private NavigationBar topbar;//导航栏
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_danpin,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        OkGo.get("http://api.dantangapp.com/v2/items?gender=1&generation=1&limit=20&offset=0").execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                JSONObject json = (JSONObject) JSON.parse(s);
                JSONObject data = json.getJSONObject("data");
                JSONArray items = data.getJSONArray("items");
                for (int i = 0; i < items.size(); i++) {
                    JSONObject item = items.getJSONObject(i);
                    JSONObject element = item.getJSONObject("data");
                    DanPinModel model = new DanPinModel();
                    model.setCover_image_url(element.getString("cover_image_url"));
                    model.setName(element.getString("name"));
                    model.setPrice(element.getString("price"));
                    listData.add(model);
                }
                if (recycleAdapter == null){
                    recyclerView.setAdapter(recycleAdapter=new RecycleAdapter(getContext(),listData));
                    recycleAdapter.setOnItemClickListener(new RecycleAdapter.OnRecyclerViewItemClickListener(){
                        @Override
                        public void onItemClick(View view) {
                            Log.i("recycle", "onItemClick: hahahaa");
                        }

                        @Override
                        public void onItemLongClick(View view) {

                        }
                    });

                }else {
                    recycleAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
            }
        });
    }

    private void initView() {
        //导航栏设置
        topbar = (NavigationBar) getActivity().findViewById(R.id.navi_danpin);
        topbar.setTitle("单品");

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycle);
        mLayoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);//设置为一个3列的纵向网格布局
        recyclerView.setLayoutManager(mLayoutManager);
    }
}
