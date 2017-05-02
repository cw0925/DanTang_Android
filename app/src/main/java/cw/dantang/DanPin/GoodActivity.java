package cw.dantang.DanPin;

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

public class GoodActivity extends BaseActivity {
    private NavigationBar topbar;
    private WebView goodWeb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);

        initView();
    }

    private void initView() {

        topbar = (NavigationBar) findViewById(R.id.navi_good);

        topbar.setLeftAndTitle("商品详情");
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
        String url = intent.getStringExtra("goodUrl");
        goodWeb = (WebView) findViewById(R.id.good_web);
        goodWeb.loadUrl(url);
    }
}
