package com.example.lenovo.shoppingcenter.adapter.homeadapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.bean.SousuoBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018.12.10
 * author:赵颖冰(lenovo)
 * function:
 */
public class HomeSouSuoAdapter extends XRecyclerView.Adapter<HomeSouSuoAdapter.ViewHolder> {

    Context mContext;
    List<SousuoBean.ResultBean> list;

    public HomeSouSuoAdapter(Context context) {
        mContext = context;
        list=new ArrayList<>();
    }
    public void setData(List<SousuoBean.ResultBean> result) {
        list.addAll(result);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(mContext, R.layout.activity_sousuo_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String masterPic = list.get(i).getMasterPic();
        String commodityName = list.get(i).getCommodityName();
        int price = list.get(i).getPrice();
        int saleNum = list.get(i).getSaleNum();

        viewHolder.shouyefragment_imagerview_rexiaoshangpin.setImageURI(masterPic);
        viewHolder.shouyefragment_textview_rexiaoshangpinshang.setText(commodityName);
        viewHolder.shouyefragment_textview_rexiaoshangpinxiayou.setText("已售"+saleNum+"件商品");
        viewHolder.shouyefragment_textview_rexiaoshangpinxiazuo.setText(price +"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends XRecyclerView.ViewHolder {
        SimpleDraweeView shouyefragment_imagerview_rexiaoshangpin;
        TextView shouyefragment_textview_rexiaoshangpinshang,shouyefragment_textview_rexiaoshangpinxiazuo,shouyefragment_textview_rexiaoshangpinxiayou;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shouyefragment_imagerview_rexiaoshangpin=itemView.findViewById(R.id.shouyefragment_imagerview_rexiaoshangpin);
            shouyefragment_textview_rexiaoshangpinshang=itemView.findViewById(R.id.shouyefragment_textview_rexiaoshangpinshang);
            shouyefragment_textview_rexiaoshangpinxiazuo=itemView.findViewById(R.id.shouyefragment_textview_rexiaoshangpinxiazuo);
            shouyefragment_textview_rexiaoshangpinxiayou=itemView.findViewById(R.id.shouyefragment_textview_rexiaoshangpinxiayou);
        }
    }
}
