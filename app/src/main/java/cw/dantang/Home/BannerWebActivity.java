package cw.dantang.Home;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import cw.dantang.Base.BaseActivity;
import cw.dantang.CusAdapter.BannerWebAdapter;
import cw.dantang.CusNavigationBar.NavigationBar;
import cw.dantang.Model.BannerWebModel;
import cw.dantang.R;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by cw on 2017/4/28.
 */

public class BannerWebActivity extends BaseActivity {
    public List<BannerWebModel> bannerWebList = new ArrayList<>();
    private NavigationBar topbar;//导航栏
    private ListView webList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_banner);

        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        int i = intent.getIntExtra("ID",0);
        String url = "http://api.dantangapp.com/v1/collections/"+i+"/posts";
        Log.i("url", "initData: "+url);
        OkGo.get(url).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                JSONObject json = (JSONObject) JSON.parse(s);
                JSONObject data = json.getJSONObject("data");
                JSONArray posts = data.getJSONArray("posts");
                for (int j = 0; j < posts.size(); j++) {
                    BannerWebModel model = new BannerWebModel();
                    JSONObject item = posts.getJSONObject(j);
                    model.setContent_url(item.getString("content_url"));
                    model.setCover_image_url(item.getString("cover_image_url"));
                    model.setTitle(item.getString("title"));
                    model.setUrl(item.getString("url"));
                    bannerWebList.add(model);
                }
                webList.setAdapter(new BannerWebAdapter(getApplicationContext(),bannerWebList));

                webList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        BannerWebModel model = bannerWebList.get(i);
                        Intent intent = new Intent();
                        intent.setClass(BannerWebActivity.this,GuideActivity.class);
                        intent.putExtra("url",model.getUrl());
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

    private void initView() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        //导航栏设置
        topbar = (NavigationBar) findViewById(R.id.navi_banner);
        topbar.setLeftAndTitle(title);

        topbar.setClickCallback(new NavigationBar.ClickCallback() {
            @Override
            public void onBackClick() {
                finish();
            }

            @Override
            public void onRightClick() {

            }
        });

        webList = (ListView) findViewById(R.id.list_banner_web);
    }
}
