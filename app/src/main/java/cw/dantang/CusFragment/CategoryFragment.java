package cw.dantang.CusFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import cw.dantang.CusNavigationBar.NavigationBar;
import cw.dantang.ImageLoad.GlideImageLoader;
import cw.dantang.Model.CategoryBannerModel;
import cw.dantang.Model.CategoryModel;
import cw.dantang.R;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by cw on 2017/4/27.
 */

public class CategoryFragment extends Fragment implements OnBannerListener {
    private NavigationBar topbar;//导航栏
    private List<String> bannerData = new ArrayList<>();
    private List<CategoryBannerModel> listData = new ArrayList<>();
    private Banner banner;
    private RecyclerView styleRecycle;
    private RecyclerView classRecycle;
    private List<CategoryModel> styleData = new ArrayList<>();
    private List<CategoryModel> classData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_category,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initNavigationBarView();
        initScrollData();
        initView();
        initData();
    }

    private void initData() {
        OkGo.get("http://api.dantangapp.com/v1/channel_groups/all").execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                JSONObject json = (JSONObject) JSON.parse(s);
                JSONObject data = json.getJSONObject("data");
                JSONArray channel_groups = data.getJSONArray("channel_groups");
                //风格
                JSONObject dataStyle = channel_groups.getJSONObject(0);
                JSONArray channels = dataStyle.getJSONArray("channels");
                for (int i = 0; i < channels.size(); i++) {
                    CategoryModel model = new CategoryModel();
                    JSONObject item = channels.getJSONObject(i);
                    model.setIcon_url(item.getString("icon_url"));
                    model.setName(item.getString("name"));
                    styleData.add(model);
                }
                //品类
                JSONObject dataClass = channel_groups.getJSONObject(1);
                JSONArray dataChannels = dataClass.getJSONArray("channels");
                for (int i = 0; i < dataChannels.size(); i++) {
                    CategoryModel model = new CategoryModel();
                    JSONObject item = channels.getJSONObject(i);
                    model.setIcon_url(item.getString("icon_url"));
                    model.setName(item.getString("name"));
                    classData.add(model);
                }
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
            }
        });
    }

    private void initView() {
        styleRecycle = (RecyclerView) getActivity().findViewById(R.id.style_recycle);
        classRecycle = (RecyclerView) getActivity().findViewById(R.id.class_recycle);
    }

    private void initScrollData() {
        OkGo.get("http://api.dantangapp.com/v1/collections?limit=6&offset=0").execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                JSONObject json = (JSONObject) JSON.parse(s);
                JSONObject data = json.getJSONObject("data");
                JSONArray collections = data.getJSONArray("collections");
                for (int i = 0; i <collections.size() ; i++) {
                    JSONObject item = collections.getJSONObject(i);
                    CategoryBannerModel model = new CategoryBannerModel();
                    model.setBanner_image_url(item.getString("banner_image_url"));
                    model.setId(item.getInteger("id"));
                    bannerData.add(model.getBanner_image_url());
                    listData.add(model);
                }
                initBannerView();
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
            }
        });
    }

    private void initNavigationBarView() {
        //导航栏设置
        topbar = (NavigationBar) getActivity().findViewById(R.id.navi_category);
        topbar.setRigthAndTitle("分类",R.drawable.search);
    }
    private void initBannerView(){
        banner = (Banner) getActivity().findViewById(R.id.category_banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(bannerData);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnBannerListener(this);
    }

    @Override
    public void OnBannerClick(int position) {

    }
}
