package cw.dantang.CusAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import cw.dantang.CusViewHolder.RecycleHolder;
import cw.dantang.Model.DanPinModel;
import cw.dantang.R;

/**
 * Created by cw on 2017/5/2.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private Context mContext;
    private List<DanPinModel> data;

    //自定义监听事件
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view,int postion);
        void onItemLongClick(View view,int postion);
    }
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        mOnItemClickListener = listener;
    }
    //适配器初始化
    public RecycleAdapter(Context context,List<DanPinModel> datas) {
        mContext = context;
        this.data = datas;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext
        ).inflate(R.layout.recycle_item, parent,
                false);//这个布局就是一个imageview用来显示图片
        //view.setOnClickListener(this);
        RecycleHolder viewHolder = new RecycleHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        RecycleHolder viewHolder = (RecycleHolder)holder;

        DanPinModel model = data.get(position);

        Glide.with(mContext).load(model.getCover_image_url()).centerCrop().placeholder(R.drawable.placeholder).crossFade()
                .into(viewHolder.img);
        viewHolder.name.setText(model.getName());
        viewHolder.price.setText("￥"+model.getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    

//    @Override
//    public void onClick(View view,int postion) {
//        if (mOnItemClickListener != null) {
//            mOnItemClickListener.onItemClick(view, postion);
//        }
//    }
//    @Override
//    public boolean onLongClick(View v,int postion) {
//        if (mOnItemClickListener!= null) {
//            mOnItemClickListener.onItemLongClick(v,postion);
//        }
//        return false;
//    }
}
