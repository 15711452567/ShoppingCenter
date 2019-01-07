package com.example.lenovo.shoppingcenter.adapter.homeadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.bean.MoreBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2019.1.5
 * author:赵颖冰(lenovo)
 * function:
 */
public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder> {
    Context mContext;
    List<MoreBean.ResultBean> list;

    public MoreAdapter(Context context) {
        mContext = context;
        list=new ArrayList<>();
    }
    public void setData(List<MoreBean.ResultBean> result) {
        list.addAll(result);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(mContext,R.layout.moreactivity_recy_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String commodityName = list.get(i).getCommodityName();
        int price = list.get(i).getPrice();
        int saleNum = list.get(i).getSaleNum();
        String masterPic = list.get(i).getMasterPic();

        viewHolder.moreactivity_recy_simple.setImageURI(masterPic);
        viewHolder.moreactivity_recy_title.setText(commodityName);
        viewHolder.moreactivity_recy_price.setText("￥: "+price+"元");
        viewHolder.moreactivity_recy_num.setText("已售出"+saleNum+"件");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView moreactivity_recy_simple;
        TextView moreactivity_recy_title,moreactivity_recy_price,moreactivity_recy_num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            moreactivity_recy_simple=itemView.findViewById(R.id.moreactivity_recy_simple);
            moreactivity_recy_title= itemView.findViewById(R.id.moreactivity_recy_title);
            moreactivity_recy_price=itemView.findViewById(R.id.moreactivity_recy_price);
            moreactivity_recy_num=itemView.findViewById(R.id.moreactivity_recy_num);
        }
    }
}
