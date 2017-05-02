package cw.dantang.CusFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import cw.dantang.CusAdapter.HomeAdapter;
import cw.dantang.CusNavigationBar.NavigationBar;
import cw.dantang.Home.BannerWebActivity;
import cw.dantang.Home.GuideActivity;
import cw.dantang.ImageLoad.GlideImageLoader;
import cw.dantang.Model.BannerModel;
import cw.dantang.Model.HomeModel;
import cw.dantang.R;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by cw on 2017/4/27.
 */

public class HomeFragment extends Fragment implements OnBannerListener {

    private Context mContext;
    public static List<String> images=new ArrayList<>();
    public static List<BannerModel> scrollData = new ArrayList<>();
    public static List<HomeModel> homeData = new ArrayList<>();

    private NavigationBar topbar;//导航栏
    private ListView homeList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.mContext = getActivity();
//轮播图
        initView();
        initScrollData();
//首页
        initHomeView();
        initHomeData();
    }

    private void initHomeView() {
        homeList = (ListView) getActivity().findViewById(R.id.list_home);
    }
    private void initHomeData(){
        OkGo.get("http://api.dantangapp.com/v1/channels/4/items?gender=1&generation=1&limit=20&offset=0").execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                JSONObject json = (JSONObject) JSON.parse(s);
                JSONObject data = json.getJSONObject("data");
                JSONArray items = data.getJSONArray("items");
                for (int i = 0; i < items.size(); i++) {
                    HomeModel model = new HomeModel();
                    JSONObject item = items.getJSONObject(i);
                    model.setContent_url(item.getString("content_url"));
                    model.setCover_image_url(item.getString("cover_image_url"));
                    model.setTitle(item.getString("title"));
                    model.setUrl(item.getString("url"));
                    homeData.add(model);
                }

                homeList.setAdapter(new HomeAdapter(getContext(),homeData));

                homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        // Log.i("tag", "onItemClick: "+i+l);
                        HomeModel model = homeData.get(i);
                        Intent intent = new Intent();
                        intent.setClass(getActivity(), GuideActivity.class);
                        intent.putExtra("url",model.getContent_url());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
            }
        });
    }
    //轮播图数据
    private void initScrollData() {
        OkGo.get("http://api.dantangapp.com/v1/banners")     // 请求方式和请求url// 缓存模式，详细请看缓存介绍
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        // s 即为所需要的结果
                        JSONObject json = (JSONObject) JSON.parse(s);
                        JSONObject data = json.getJSONObject("data");
                        JSONArray banner = data.getJSONArray("banners");
                        for (int i = 0; i < banner.size(); i++) {
                            BannerModel model = new BannerModel();
                            JSONObject item = banner.getJSONObject(i);
                            images.add(item.getString("image_url"));

                            JSONObject target = item.getJSONObject("target");
                            model.setTitle(target.getString("title"));
                            model.setId(target.getInteger("id"));
                            scrollData.add(model);
                            //Log.i("返回", "解析后onSuccess: "+target.getString("title")+"******");
                        }
                        initBannerView();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });
    }
    //轮播图
    private  void initBannerView(){
        Banner banner = (Banner)getActivity().findViewById(R.id.banner);
        //指示器
        //banner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnBannerListener(this);
    }
    private void initView() {
        //导航栏设置
        topbar = (NavigationBar) getActivity().findViewById(R.id.navi_home);
        topbar.setTitle("首页");
    }

    @Override
    public void OnBannerClick(int position) {
        //Toast.makeText(mContext,"你点击了："+position,Toast.LENGTH_SHORT).show();
        BannerModel model = scrollData.get(position);

        Intent intent = new Intent();
        intent.setClass(getActivity(), BannerWebActivity.class);
        intent.putExtra("title",model.getTitle());
        intent.putExtra("ID",model.getId());
        startActivity(intent);
    }
}
