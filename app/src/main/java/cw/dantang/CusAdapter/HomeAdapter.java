package cw.dantang.CusAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cw.dantang.Model.HomeModel;
import cw.dantang.R;

/**
 * Created by cw on 2017/5/2.
 */

public class HomeAdapter extends BaseAdapter {
    private List<HomeModel> homeList;
    private LayoutInflater mInflater;
    public HomeAdapter(Context context, List<HomeModel> list){
        homeList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return homeList.size();
    }

    @Override
    public Object getItem(int i) {
        return homeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.cell_home, null);
            viewHolder.img = (ImageView) view.findViewById(R.id.cell_img);
            viewHolder.title = (TextView) view.findViewById(R.id.cell_title);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        HomeModel model = homeList.get(i);
        viewHolder.title.setText(model.getTitle());
        Glide.with(viewHolder.img.getContext()).load(model.getCover_image_url()).centerCrop().placeholder(R.drawable.placeholder).crossFade()
                .into(viewHolder.img);
        return view;
    }
    class ViewHolder{
        public TextView title;
        public ImageView img;
    }
}
