package com.example.lenovo.shoppingcenter.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.shoppingcenter.Apis;
import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.activity.home.DetailActivity;
import com.example.lenovo.shoppingcenter.activity.home.MoreActivity;
import com.example.lenovo.shoppingcenter.activity.home.SearchActivity;
import com.example.lenovo.shoppingcenter.adapter.homeadapter.GalleryAdapter;
import com.example.lenovo.shoppingcenter.adapter.homeadapter.HomeMoLiShiShangAdapter;
import com.example.lenovo.shoppingcenter.adapter.homeadapter.HomePinZhiShengHuoAdapter;
import com.example.lenovo.shoppingcenter.adapter.homeadapter.HomeReXiaoShengPinAdapter;
import com.example.lenovo.shoppingcenter.bean.BannerBean;
import com.example.lenovo.shoppingcenter.bean.CommodityIdBean;
import com.example.lenovo.shoppingcenter.bean.HomeBean;
import com.example.lenovo.shoppingcenter.bean.IdBean;
import com.example.lenovo.shoppingcenter.presenter.IPersenterImpl;
import com.example.lenovo.shoppingcenter.view.IView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IView, View.OnClickListener {

    private ImageView homefragment_imageview_fenlei;
    private ImageView homefragment_imageview_sousuo;
    private XBanner homefragment_banner;
    private ImageView homefragment_imageview_resoushangpin;
    private RecyclerView homefragment_recyclerview_rexiaoshangpin;
    private ImageView homefragment_imageview_molishishang;
    private RecyclerView homefragment_recyclerview_molishishang;
    private ImageView homefragment_imageview_pinzhishenghuo;
    private RecyclerView homefragment_recyclerview_pinzhishenghuo;
    private IPersenterImpl mIPersenter;
    private List<BannerBean.ResultBean> mResult;
    private HomeReXiaoShengPinAdapter mShouYeReXiaoShengPinAdapter;
    private HomeMoLiShiShangAdapter mHomeMoLiShiShangAdapter;
    private HomePinZhiShengHuoAdapter mHomePinZhiShengHuoAdapter;
    private GalleryAdapter mGalleryAdapter;
    private XBanner.XBannerAdapter mXBannerAdapter;
    private ImageView homefragment_image_rxxpmore;
    private ImageView homefragment_image_mlssmore;
    private ImageView homefragment_image_pzshmore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //初始化控件
        initView(view);
        //初始化presenter
        initPreSenter();
        //初始化recyclerview
        initRecy();

        return view;
    }


    //初始化recyclerview
    private void initRecy() {

        mShouYeReXiaoShengPinAdapter = new HomeReXiaoShengPinAdapter(getContext());
        homefragment_recyclerview_rexiaoshangpin.setAdapter(mShouYeReXiaoShengPinAdapter);
        homefragment_recyclerview_rexiaoshangpin.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        mShouYeReXiaoShengPinAdapter.setGetData(new HomeReXiaoShengPinAdapter.GetData() {
            @Override
            public void getData(int Id) {

                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("commentId",Id+"");
                startActivity(intent);
            }
        });

        mHomeMoLiShiShangAdapter = new HomeMoLiShiShangAdapter(getContext());
        homefragment_recyclerview_molishishang.setAdapter(mHomeMoLiShiShangAdapter);
        homefragment_recyclerview_molishishang.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));

        mHomeMoLiShiShangAdapter.setGetData(new HomeMoLiShiShangAdapter.GetData() {
            @Override
            public void getData(int Id) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("commentId",Id+"");
                startActivity(intent);
            }
        });

        mHomePinZhiShengHuoAdapter = new HomePinZhiShengHuoAdapter(getContext());
        homefragment_recyclerview_pinzhishenghuo.setAdapter(mHomePinZhiShengHuoAdapter);
        homefragment_recyclerview_pinzhishenghuo.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mHomePinZhiShengHuoAdapter.setGetData(new HomePinZhiShengHuoAdapter.GetData() {
            @Override
            public void getData(int Id) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("commentId",Id+"");
                startActivity(intent);
            }
        });

    }

    //初始化presenter
    private void initPreSenter() {
        mIPersenter = new IPersenterImpl(this);
        Map<String, String> map = new HashMap<>();
        mIPersenter.setGetRequest(Apis.BANNER_URL, map, BannerBean.class);
        Map<String, String> map1 = new HashMap<>();
        mIPersenter.setGetRequest(Apis.HOMERECY_URL, map1, HomeBean.class);
    }

    //初始化画廊轮播图
    private void initBannerData() {

        final List<String> Imagelist = new ArrayList();
        List<String> Titlelist = new ArrayList();
        for (int i = 0; i < mResult.size(); i++) {
            Imagelist.add(mResult.get(i).getImageUrl());
            Titlelist.add(mResult.get(i).getTitle());
        }

        homefragment_banner.setData(mResult, null);
        //设置图片圆角角度
        mXBannerAdapter = new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                //设置图片圆角角度
                RoundedCorners roundedCorners = new RoundedCorners(10);

                RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 150);
                Glide.with(getActivity()).load(mResult.get(position).getImageUrl()).apply(options).into((ImageView) view);
            }
        };

        homefragment_banner.loadImage(mXBannerAdapter);
        homefragment_banner.setPageTransformer(Transformer.Default);
        homefragment_banner.setPageChangeDuration(1000);

    }


    //初始化视图，控件
    private void initView(View view) {
        homefragment_imageview_fenlei = (ImageView) view.findViewById(R.id.homefragment_imageview_fenlei);
        homefragment_imageview_sousuo = (ImageView) view.findViewById(R.id.homefragment_imageview_sousuo);
        homefragment_banner=view.findViewById(R.id.homefragment_banner);
        homefragment_imageview_resoushangpin = (ImageView) view.findViewById(R.id.homefragment_imageview_resoushangpin);
        homefragment_recyclerview_rexiaoshangpin = (RecyclerView) view.findViewById(R.id.homefragment_recyclerview_rexiaoshangpin);
        homefragment_imageview_molishishang = (ImageView) view.findViewById(R.id.homefragment_imageview_molishishang);
        homefragment_recyclerview_molishishang = (RecyclerView) view.findViewById(R.id.homefragment_recyclerview_molishishang);
        homefragment_imageview_pinzhishenghuo = (ImageView) view.findViewById(R.id.homefragment_imageview_pinzhishenghuo);
        homefragment_recyclerview_pinzhishenghuo = (RecyclerView) view.findViewById(R.id.homefragment_recyclerview_pinzhishenghuo);
        homefragment_imageview_sousuo.setOnClickListener(this);
        homefragment_image_rxxpmore = (ImageView) view.findViewById(R.id.homefragment_image_rxxpmore);
        homefragment_image_rxxpmore.setOnClickListener(this);
        homefragment_image_mlssmore = (ImageView) view.findViewById(R.id.homefragment_image_mlssmore);
        homefragment_image_mlssmore.setOnClickListener(this);
        homefragment_image_pzshmore = (ImageView) view.findViewById(R.id.homefragment_image_pzshmore);
        homefragment_image_pzshmore.setOnClickListener(this);
    }

    @Override
    public void setData(Object Data) {

        //轮播图
        if (Data instanceof BannerBean) {
            BannerBean bannerBean = (BannerBean) Data;
            mResult = bannerBean.getResult();
            //初始化banner轮播图
            initBannerData();


        } else if (Data instanceof HomeBean) {
            //recyclerview列表
            HomeBean homeBean = (HomeBean) Data;


            //获取id
            final int rxspId = homeBean.getResult().getRxxp().get(0).getId();
            final int mlssId = homeBean.getResult().getMlss().get(0).getId();
            final int pzshId = homeBean.getResult().getPzsh().get(0).getId();
            //点击跳转
            homefragment_image_rxxpmore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IdBean idBean=new IdBean(rxspId);
                    EventBus.getDefault().postSticky(idBean);
                    Intent intent1 = new Intent(getContext(), MoreActivity.class);
                    startActivity(intent1);
                }
            });
            //点击跳转
            homefragment_image_mlssmore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IdBean idBean=new IdBean(mlssId);
                    EventBus.getDefault().postSticky(idBean);
                    Intent intent2 = new Intent(getContext(), MoreActivity.class);
                    startActivity(intent2);
                }
            });
            //点击跳转
            homefragment_image_pzshmore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IdBean idBean=new IdBean(pzshId);
                    EventBus.getDefault().postSticky(idBean);
                    Intent intent3 = new Intent(getContext(), MoreActivity.class);
                    startActivity(intent3);
                }
            });


            mShouYeReXiaoShengPinAdapter.setData(homeBean.getResult().getRxxp().get(0).getCommodityList());
            mHomeMoLiShiShangAdapter.setData(homeBean.getResult().getMlss().get(0).getCommodityList());
            mHomePinZhiShengHuoAdapter.setData(homeBean.getResult().getPzsh().get(0).getCommodityList());
        }


    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homefragment_imageview_sousuo:
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                break;

        }
    }
}
