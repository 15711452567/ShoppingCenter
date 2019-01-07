package com.example.lenovo.shoppingcenter.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.shoppingcenter.Apis;
import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.adapter.circleadapter.CircleAdapter;
import com.example.lenovo.shoppingcenter.bean.CircleBean;
import com.example.lenovo.shoppingcenter.bean.HeaderBean;
import com.example.lenovo.shoppingcenter.presenter.IPersenterImpl;
import com.example.lenovo.shoppingcenter.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends Fragment implements IView {

    private XRecyclerView circlefragment_recy;
    private String mSessionId;
    private int mUserId;
    private IPersenterImpl mIPersenter;
    private CircleAdapter mCircleAdapter;
    private int page=1;
    private boolean mB1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle, container, false);
        mIPersenter = new IPersenterImpl(this);
        initView(view);
        initData(page);
        circlefragment_recy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                initData(page);
                circlefragment_recy.refreshComplete();
            }

            @Override
            public  void onLoadMore() {

                initData(page);
                circlefragment_recy.loadMoreComplete();
            }
        });

        mCircleAdapter = new CircleAdapter(getContext());
        circlefragment_recy.setAdapter(mCircleAdapter);
        circlefragment_recy.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));


        return view;
    }

    private void initData(int page) {
        Map<String ,String> map=new HashMap<>();
        map.put("page", String.valueOf(page));
        map.put("count","5");

        Map<String,Object> mapHead =new HashMap<>();
        mapHead.put("userId",mUserId);
        mapHead.put("sessionId",mSessionId);
        mIPersenter.setGetHeadRequest(Apis.CIRCLE_URL,map,mapHead,CircleBean.class);
    }

    private void initView(View view) {
        circlefragment_recy = (XRecyclerView) view.findViewById(R.id.circlefragment_recy);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void asd(HeaderBean headerBean){
        mSessionId = headerBean.sessionId;
        mUserId = headerBean.userId;
    }

    @Override
    public void setData(Object Data) {
        CircleBean circleBean= (CircleBean) Data;

            if (page==1){
                mCircleAdapter.setData(circleBean.getResult());
            }else{
                mCircleAdapter.addData(circleBean.getResult());
            }
            page++;

    }
}
