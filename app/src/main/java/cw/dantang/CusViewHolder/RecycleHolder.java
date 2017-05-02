package cw.dantang.CusViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cw.dantang.R;

/**
 * Created by cw on 2017/5/2.
 */

public class RecycleHolder extends RecyclerView.ViewHolder {

    public ImageView img;
    public TextView name;
    public TextView price;

    public  RecycleHolder(View view){
      super(view);
        img = (ImageView) view.findViewById(R.id.goodImg);
        name = (TextView) view.findViewById(R.id.name);
        price = (TextView) view.findViewById(R.id.price);
    }
}
