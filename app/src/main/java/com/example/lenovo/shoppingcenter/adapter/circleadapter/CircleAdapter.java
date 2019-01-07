package com.example.lenovo.shoppingcenter.adapter.circleadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.bean.CircleBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * date:2019.1.3
 * author:赵颖冰(lenovo)
 * function:
 */
public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.ViewHolder> {
    Context mContext;
    List<CircleBean.ResultBean> list;

    public CircleAdapter(Context context) {
        mContext = context;
        list=new ArrayList<>();
    }

    public void setData(List<CircleBean.ResultBean> result) {
        list.clear();
        list.addAll(result);
        notifyDataSetChanged();
    }
    public void addData(List<CircleBean.ResultBean> result) {
        list.addAll(result);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(mContext,R.layout.circlefragment_recy_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        String xiangqing = list.get(i).getContent();
        String mingzi = list.get(i).getNickName();
        String image = list.get(i).getImage();
        String headPic = list.get(i).getHeadPic();
        long createTime = list.get(i).getCreateTime();

        viewHolder.circlefragment_simpledraweeView_touxiang.setImageURI(headPic);
        viewHolder.circlefragment_simpledraweeView_pinglun.setImageURI(image);
        viewHolder.circlefragment_textview_mingzi.setText(mingzi);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(createTime);
        viewHolder.circlefragment_textview_shijian.setText(dateString);
        viewHolder.circlefragment_textview_xiangqing.setText(xiangqing);

        viewHolder.circlefragment_simple_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.circlefragment_simple_like.setVisibility(View.GONE);
                viewHolder.circlefragment_simple_likes.setVisibility(View.VISIBLE);
            }
        });

        viewHolder.circlefragment_simple_likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.circlefragment_simple_like.setVisibility(View.VISIBLE);
                viewHolder.circlefragment_simple_likes.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView circlefragment_simpledraweeView_touxiang,circlefragment_simple_like,circlefragment_simple_likes,circlefragment_simpledraweeView_pinglun;
        TextView circlefragment_textview_mingzi,circlefragment_textview_shijian,circlefragment_textview_xiangqing;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circlefragment_simpledraweeView_touxiang=itemView.findViewById(R.id.circlefragment_simpledraweeView_touxiang);
            circlefragment_simpledraweeView_pinglun=itemView.findViewById(R.id.circlefragment_simpledraweeView_pinglun);
            circlefragment_textview_mingzi=itemView.findViewById(R.id.circlefragment_textview_mingzi);
            circlefragment_textview_shijian=itemView.findViewById(R.id.circlefragment_textview_shijian);
            circlefragment_textview_xiangqing=itemView.findViewById(R.id.circlefragment_textview_xiangqing);
            circlefragment_simple_like = itemView.findViewById(R.id.circlefragment_simple_like);
            circlefragment_simple_likes=itemView.findViewById(R.id.circlefragment_simple_likes);
        }
    }
    public interface OnClick{
        void OnClickLister(boolean b);
    }
    private OnClick mOnClick;

    public void setOnClick(OnClick onClick) {
        mOnClick = onClick;
    }
}
