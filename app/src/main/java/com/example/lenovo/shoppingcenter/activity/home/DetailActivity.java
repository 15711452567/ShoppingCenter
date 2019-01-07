package com.example.lenovo.shoppingcenter.activity.home;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.shoppingcenter.Apis;
import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.adapter.homeadapter.DetailsActivity_RecycleView_Adapter;
import com.example.lenovo.shoppingcenter.adapter.homeadapter.DetailsAdapter;
import com.example.lenovo.shoppingcenter.bean.CommodityIdBean;
import com.example.lenovo.shoppingcenter.bean.HeaderBean;
import com.example.lenovo.shoppingcenter.bean.LoginBean;
import com.example.lenovo.shoppingcenter.bean.CommentBean;
import com.example.lenovo.shoppingcenter.bean.ShopDetailsBean;
import com.example.lenovo.shoppingcenter.presenter.IPersenterImpl;
import com.example.lenovo.shoppingcenter.view.IView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailActivity extends AppCompatActivity implements IView {

    private ViewPager detailsactivity_viewpager_show;
    private TextView detailsactivity_textview_shownum;
    private TextView detailsactivity_textview_sprice;
    private TextView detailsactivity_textview_sold;
    private TextView detailsactivity_textview_title;
    private TextView detailsactivity_textview_Weight;
    private SimpleDraweeView detailsactivity_Image_details;
    private TextView detailsactivity_textview_describe;
    private SimpleDraweeView detailsactivity_Image_describe;
    private RecyclerView detailsactivity_recview_comments;
    private TextView detailsactivity_textview_comments;
    private MyScrollView detailsactivity_scroll_changecolor;
    private ImageView detailsactivity_image_return;
    private TextView detailsactivity_text_goodsT;
    private TextView detailsactivity_text_detailsT;
    private TextView detailsactivity_text_commentsT;
    private TextView detailsactivity_text_goods;
    private TextView detailsactivity_text_details;
    private TextView detailsactivity_text_comments;
    private RelativeLayout detailsactivity_relative_changer;
    private RelativeLayout detailsactivity_relat_changecolor;
    private RelativeLayout detailsactivity_relative_addshoppingcar;
    private RelativeLayout detailsactivity_relative_pay;
    private int mUserId;
    private String mSessionId;
    private int count;
    private DetailsActivity_RecycleView_Adapter mCommentsAdapter;
    private IPersenterImpl mIPersenter;

    private String mCommentId;
    private int mCommodityId;
    private ShopDetailsBean.ResultBean mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mIPersenter = new IPersenterImpl(this);
        Intent intent = getIntent();
        mCommentId = intent.getStringExtra("commentId");
        initView();

        initData();


        detailsactivity_recview_comments.setVisibility(View.VISIBLE);
        detailsactivity_textview_comments.setVisibility(View.GONE);
        detailsactivity_recview_comments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mCommentsAdapter = new DetailsActivity_RecycleView_Adapter(DetailActivity.this);
        detailsactivity_recview_comments.setAdapter(mCommentsAdapter);
    }

    private void initData() {

        Map<String,String> map=new HashMap<>();
        map.put("commodityId", mCommentId);
        Map<String,Object> headMap=new HashMap<>();
        headMap.put("userId",mUserId);
        headMap.put("sessionId",mSessionId);
        mIPersenter.setGetHeadRequest(Apis.DETAILS_URL,map,headMap,ShopDetailsBean.class);

        Map<String,String> map1=new HashMap<>();
        map1.put("commodityId", mCommentId);
        map1.put("page","1");
        map1.put("count","5");
        mIPersenter.setGetHeadRequest(Apis.COMMENT_URL,map,headMap,CommentBean.class);


    }

    private void initView() {
        EventBus.getDefault().register(this);

        detailsactivity_viewpager_show = (ViewPager) findViewById(R.id.detailsactivity_viewpager_show);
        detailsactivity_textview_shownum = (TextView) findViewById(R.id.detailsactivity_textview_shownum);
        detailsactivity_textview_sprice = (TextView) findViewById(R.id.detailsactivity_textview_sprice);
        detailsactivity_textview_sold = (TextView) findViewById(R.id.detailsactivity_textview_sold);
        detailsactivity_textview_title = (TextView) findViewById(R.id.detailsactivity_textview_title);
        detailsactivity_Image_details = (SimpleDraweeView) findViewById(R.id.detailsactivity_Image_details);
        detailsactivity_textview_describe = (TextView) findViewById(R.id.detailsactivity_textview_describe);
        detailsactivity_Image_describe = (SimpleDraweeView) findViewById(R.id.detailsactivity_Image_describe);
        detailsactivity_recview_comments = (RecyclerView) findViewById(R.id.detailsactivity_recview_comments);
        detailsactivity_textview_comments = (TextView) findViewById(R.id.detailsactivity_textview_comments);
        detailsactivity_scroll_changecolor = findViewById(R.id.detailsactivity_scroll_changecolor);
        detailsactivity_image_return = (ImageView) findViewById(R.id.detailsactivity_image_return);
        detailsactivity_text_goodsT = (TextView) findViewById(R.id.detailsactivity_text_goodsT);
        detailsactivity_text_detailsT = (TextView) findViewById(R.id.detailsactivity_text_detailsT);
        detailsactivity_text_commentsT = (TextView) findViewById(R.id.detailsactivity_text_commentsT);
        detailsactivity_text_goods = (TextView) findViewById(R.id.detailsactivity_text_goods);
        detailsactivity_text_details = (TextView) findViewById(R.id.detailsactivity_text_details);
        detailsactivity_text_comments = (TextView) findViewById(R.id.detailsactivity_text_comments);
        detailsactivity_textview_Weight = findViewById(R.id.detailsactivity_textview_Weight);
        detailsactivity_relative_changer = (RelativeLayout) findViewById(R.id.detailsactivity_relative_changer);
        detailsactivity_relat_changecolor = (RelativeLayout) findViewById(R.id.detailsactivity_relat_changecolor);
        detailsactivity_relative_addshoppingcar = (RelativeLayout) findViewById(R.id.detailsactivity_relative_addshoppingcar);
        detailsactivity_relative_pay = (RelativeLayout) findViewById(R.id.detailsactivity_relative_pay);

        //点击返回按钮销毁当前页面
        detailsactivity_image_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //加入购物车
        detailsactivity_relative_addshoppingcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final int commodityId = mResult.getCommodityId();
                final int count = 1;
                Map<String, Integer> map = new HashMap<>();
                //map.put("commodityId", commodityId);
                map.put("count", count);

                String s1 = new Gson().toJson(map);
                String data = "[" + s1 + "]";
                Map<String, String> map1 = new HashMap<>();
                map1.put("data", data);
                String TongBuGouWuCheUrl = "http://172.17.8.100/small/order/verify/v1/syncShoppingCart";

            }
        });
        //直接支付
        detailsactivity_relative_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //商品banner的下标展示
        detailsactivity_viewpager_show.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                detailsactivity_textview_shownum.setText((position + 1) + "/" + count);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //滑动变色
        detailsactivity_scroll_changecolor.setScrollViewListener(new MyScrollView.ScrollViewListener() {
            @Override
            public void onScrollChange(MyScrollView scrollView, int l, int t, int oldl, int oldt) {
                if (t <= 0) {
                    //标题显示
                    detailsactivity_relative_changer.setVisibility(View.GONE);
                    //设置标题所在的背景颜色为透明
                    detailsactivity_relat_changecolor.setBackgroundColor(Color.argb(0, 0, 0, 0));
                } else if (t > 0 && t < 200) {
                    detailsactivity_relative_changer.setVisibility(View.VISIBLE);
                    //获取ScrollView想下滑动,图片消失部分的比例
                    float scale = (float) t / 200;
                    //根据比例,让标题的颜色由浅入深
                    float alpha = 255 * scale;
                    //设置标题布局的颜色
                    detailsactivity_relat_changecolor.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));

                }
                if (0 < t && t < 700) {
                    detailsactivity_text_goods.setBackgroundColor(Color.RED);
                    detailsactivity_text_details.setBackgroundColor(Color.WHITE);
                    detailsactivity_text_comments.setBackgroundColor(Color.WHITE);
                } else if (701 < t && t < 1500) {
                    detailsactivity_text_goods.setBackgroundColor(Color.WHITE);
                    detailsactivity_text_details.setBackgroundColor(Color.RED);
                    detailsactivity_text_comments.setBackgroundColor(Color.WHITE);
                } else if (t > 1500) {
                    detailsactivity_text_goods.setBackgroundColor(Color.WHITE);
                    detailsactivity_text_details.setBackgroundColor(Color.WHITE);
                    detailsactivity_text_comments.setBackgroundColor(Color.RED);
                }
            }
        });
        detailsactivity_text_goodsT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsactivity_scroll_changecolor.setScrollY(0);
            }
        });
        detailsactivity_text_detailsT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsactivity_scroll_changecolor.setScrollY(702);
            }
        });
        detailsactivity_text_commentsT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsactivity_scroll_changecolor.setScrollY(1501);
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void asd(HeaderBean headerBean) {

        mUserId = headerBean.userId;
        mSessionId = headerBean.sessionId;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void setData(Object Data) {
        if (Data instanceof ShopDetailsBean) {
            ShopDetailsBean shopDetailsBean= (ShopDetailsBean) Data;
            mResult = shopDetailsBean.getResult();

            int price = mResult.getPrice();

            int saleNum = mResult.getSaleNum();
            int weight = mResult.getWeight();
            String commodityName = mResult.getCommodityName();
            String describe = mResult.getDescribe();
            int commodityId = mResult.getCommodityId();
            mCommodityId=commodityId;
            detailsactivity_textview_sprice.setText("￥"+price+"元" );
            detailsactivity_textview_sold.setText(saleNum+"" );
            detailsactivity_textview_Weight.setText( weight+"");
            detailsactivity_textview_title.setText( commodityName );
            detailsactivity_textview_describe.setText( describe );
            String picture = mResult.getPicture();
            String[] split = picture.split( "," );
            detailsactivity_Image_describe.setImageURI( Uri.parse(split[0]) );
            detailsactivity_Image_details.setImageURI( Uri.parse(split[1]) );

            DetailsAdapter detailsAdapter=new DetailsAdapter(split,DetailActivity.this);
            count = detailsAdapter.getCount();


            detailsactivity_viewpager_show.setAdapter( detailsAdapter );

        }else if (Data instanceof CommentBean){
            CommentBean commentBean= (CommentBean) Data;

            List<CommentBean.ResultBean> result = commentBean.getResult();
            mCommentsAdapter.setData(result);
        }
    }
}