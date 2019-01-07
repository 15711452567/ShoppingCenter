package com.example.lenovo.shoppingcenter.adapter.homeadapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.bean.HomeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018.12.7
 * author:赵颖冰(lenovo)
 * function:
 */
public class HomeMoLiShiShangAdapter extends RecyclerView.Adapter<HomeMoLiShiShangAdapter.ViewHodler> {
    Context mContext;
    List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> list;

    public HomeMoLiShiShangAdapter(Context context) {
        mContext = context;
        list = new ArrayList<>();
    }
    public void setData(List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> shouYeZhanShiBean) {
        list = shouYeZhanShiBean;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.fragment_shouye_molishishang, null);
        ViewHodler viewHolder = new ViewHodler(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {

        String commodityName = list.get(i).getCommodityName();
        int price = list.get(i).getPrice();
        String masterPic = list.get(i).getMasterPic();
        viewHodler.shouyefragment_imagerview_rexiaoshangpin.setImageURI(masterPic);
        viewHodler.shouyefragment_textview_rexiaoshangpinshang.setText(commodityName);
        viewHodler.shouyefragment_textview_rexiaoshangpinxia.setText("￥" + price + "元");

        final int commodityId = list.get(i).getCommodityId();
        viewHodler.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mGetData.getData(commodityId);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHodler extends RecyclerView.ViewHolder {
        SimpleDraweeView shouyefragment_imagerview_rexiaoshangpin;
        TextView shouyefragment_textview_rexiaoshangpinshang, shouyefragment_textview_rexiaoshangpinxia;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            shouyefragment_imagerview_rexiaoshangpin = itemView.findViewById(R.id.shouyefragment_imagerview_rexiaoshangpin);
            shouyefragment_textview_rexiaoshangpinshang = itemView.findViewById(R.id.shouyefragment_textview_rexiaoshangpinshang);
            shouyefragment_textview_rexiaoshangpinxia = itemView.findViewById(R.id.shouyefragment_textview_rexiaoshangpinxia);
        }
    }

    public interface GetData {
        void getData(int Id);
    }

    private GetData mGetData;

    public void setGetData(GetData getData) {
        mGetData = getData;
    }
}