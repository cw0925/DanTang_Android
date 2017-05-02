package cw.dantang.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import cw.dantang.Base.BaseActivity;
import cw.dantang.CusNavigationBar.NavigationBar;
import cw.dantang.R;

/**
 * Created by cw on 2017/5/2.
 */

public class GuideActivity extends BaseActivity {
    private WebView guideWeb;
    private NavigationBar topbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        topbar = (NavigationBar) findViewById(R.id.navi_guide);
        topbar.setLeftAndTitle("攻略详情");
        topbar.setClickCallback(new NavigationBar.ClickCallback() {
            @Override
            public void onBackClick() {
                finish();
            }

            @Override
            public void onRightClick() {

            }
        });

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        guideWeb = (WebView) findViewById(R.id.web_guide);
        guideWeb.loadUrl(url);
    }
}
