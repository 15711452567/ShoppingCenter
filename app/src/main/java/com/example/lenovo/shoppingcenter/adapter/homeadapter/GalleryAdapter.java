package com.example.lenovo.shoppingcenter.adapter.homeadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.bean.BannerBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2019.1.4
 * author:赵颖冰(lenovo)
 * function:
 */
public class GalleryAdapter extends BaseAdapter {
    private Context mContext;
    //设置要展示的图片资源
    List<BannerBean.ResultBean> list;
    public void setData(List<BannerBean.ResultBean> result) {
        list=result;
        notifyDataSetChanged();
    }
    public GalleryAdapter(Context context) {
        this.mContext = context;
        list=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //在此最好判断一下view是否为空
        SimpleDraweeView image = new SimpleDraweeView(mContext);

        image.setImageURI(list.get(i).getImageUrl());
        image.setAdjustViewBounds(true);
        //设置宽高
        image.setLayoutParams(new Gallery.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return image;
    }



}
