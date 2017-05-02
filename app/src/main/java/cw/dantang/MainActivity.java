package cw.dantang;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cw.dantang.Base.BaseActivity;
import cw.dantang.CusFragment.CategoryFragment;
import cw.dantang.CusFragment.DanPinFragment;
import cw.dantang.CusFragment.HomeFragment;
import cw.dantang.CusFragment.MyFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private ViewPager home_viewPager;
    private FragmentPagerAdapter fadapter;
    private List<Fragment> LFragment;

    private LinearLayout line_home;
    private LinearLayout line_category;
    private LinearLayout line_find;
    private LinearLayout line_my;

    private ImageView img_home;
    private ImageView img_category;
    private ImageView img_find;
    private ImageView img_my;

    private TextView tv_home;
    private TextView tv_category;
    private TextView tv_find;
    private TextView tv_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        setSelect(0);
    }

    private void initEvent() {
        line_home.setOnClickListener(this);
        line_category.setOnClickListener(this);
        line_find.setOnClickListener(this);
        line_my.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.line_home:
                setSelect(0);
                break;
            case R.id.line_category:
                setSelect(1);
                break;
            case R.id.line_find:
                setSelect(2);
                break;
            case R.id.line_my:
                setSelect(3);
                break;
        }
    }
    private void initView() {
        line_home = (LinearLayout)findViewById(R.id.line_home);
        line_category = (LinearLayout)findViewById(R.id.line_category);
        line_find = (LinearLayout)findViewById(R.id.line_find);
        line_my = (LinearLayout)findViewById(R.id.line_my);

        img_home = (ImageView)findViewById(R.id.img_home);
        img_category = (ImageView)findViewById(R.id.img_category);
        img_find = (ImageView)findViewById(R.id.img_find);
        img_my = (ImageView)findViewById(R.id.img_my);

        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_category = (TextView) findViewById(R.id.tv_category);
        tv_find = (TextView) findViewById(R.id.tv_find);
        tv_my = (TextView) findViewById(R.id.tv_my);

        home_viewPager = (ViewPager) findViewById(R.id.home_viewpager);

        LFragment = new ArrayList<Fragment>();
        Fragment FHome = new HomeFragment();
        Fragment DanPin = new DanPinFragment();
        Fragment FCategory = new CategoryFragment();
        Fragment FMy = new MyFragment();

        LFragment.add(FHome);
        LFragment.add(DanPin);
        LFragment.add(FCategory);
        LFragment.add(FMy);

        fadapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return LFragment.get(position);
            }

            @Override
            public int getCount() {
                return LFragment.size();
            }
        };
        home_viewPager.setAdapter(fadapter);

        home_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = home_viewPager.getCurrentItem();
                setSelect(currentItem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setSelect(int i) {
        setBackgroundDark();
        switch (i){
            case 0:
                img_home.setImageResource(R.drawable.tabbar_home_selected);
                tv_home.setTextColor(Color.rgb(252,50,89));
                home_viewPager.setCurrentItem(0);
                break;
            case 1:
                img_category.setImageResource(R.drawable.tabbar_gift_selected);
                tv_category.setTextColor(Color.rgb(252,50,89));
                home_viewPager.setCurrentItem(1);
                break;
            case 2:
                img_find.setImageResource(R.drawable.tabbar_category_selected);
                tv_find.setTextColor(Color.rgb(252,50,89));
                home_viewPager.setCurrentItem(2);
                break;
            case 3:
                img_my.setImageResource(R.drawable.tabbar_me_boy_selected);
                tv_my.setTextColor(Color.rgb(252,50,89));
                home_viewPager.setCurrentItem(3);
                break;
        }
    }

    private void setBackgroundDark() {

        img_home.setImageResource(R.drawable.tabbar_home);
        img_category.setImageResource(R.drawable.tabbar_gift);
        img_find.setImageResource(R.drawable.tabbar_category);
        img_my.setImageResource(R.drawable.tabbar_me_boy);

        tv_home.setTextColor(Color.rgb(0,0,0));
        tv_category.setTextColor(Color.rgb(0,0,0));
        tv_find.setTextColor(Color.rgb(0,0,0));
        tv_my.setTextColor(Color.rgb(0,0,0));

    }
}
