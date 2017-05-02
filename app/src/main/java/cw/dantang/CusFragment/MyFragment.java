package cw.dantang.CusFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cw.dantang.CusNavigationBar.NavigationBar;
import cw.dantang.R;

/**
 * Created by cw on 2017/4/27.
 */

public class MyFragment extends Fragment {
    private NavigationBar topbar;//导航栏
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_me,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }
    private void initView() {
        //导航栏设置
        topbar = (NavigationBar) getActivity().findViewById(R.id.navi_me);
        topbar.setTitle("我");
    }
}

