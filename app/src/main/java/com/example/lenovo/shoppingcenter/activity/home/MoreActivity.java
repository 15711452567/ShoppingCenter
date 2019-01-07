package com.example.lenovo.shoppingcenter.activity.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.shoppingcenter.Apis;
import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.adapter.homeadapter.MoreAdapter;
import com.example.lenovo.shoppingcenter.bean.IdBean;
import com.example.lenovo.shoppingcenter.bean.MoreBean;
import com.example.lenovo.shoppingcenter.presenter.IPersenterImpl;
import com.example.lenovo.shoppingcenter.view.IView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class MoreActivity extends AppCompatActivity implements IView {

    private ImageView sousuoactivity_imageview_fenlei;
    private EditText shurusousuo;
    private ImageView sousuoactivity_imageview_sousuo;
    private RecyclerView moreactivity_recy;
    private RadioButton homeactivity_radiobutton_hone;
    private RadioButton homeactivity_radiobutton_circle;
    private RadioButton homeactivity_radiobutton_shoopingcart;
    private RadioButton homeactivity_radiobutton_list;
    private RadioButton homeactivity_radiobutton_my;
    private RadioGroup homeactivity_radiogroup;
    private IPersenterImpl mIPersenter;
    private MoreAdapter mMoreAdapter;
    private int mRxspId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        EventBus.getDefault().register(this);
        initView();
        mIPersenter = new IPersenterImpl(this);
        initData();

    }

    private void initData() {
        System.out.println("id: "+mRxspId);
        Map<String ,String> map=new HashMap<>();
        map.put("labelId", String.valueOf(mRxspId));
        map.put("page","1");
        map.put("count","5");
        mIPersenter.setGetRequest(Apis.ATTRIBUTION_URL,map,MoreBean.class);

        mMoreAdapter = new MoreAdapter(this);
        moreactivity_recy.setAdapter(mMoreAdapter);
        moreactivity_recy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }

    private void initView() {
        sousuoactivity_imageview_fenlei = (ImageView) findViewById(R.id.sousuoactivity_imageview_fenlei);
        shurusousuo = (EditText) findViewById(R.id.shurusousuo);
        sousuoactivity_imageview_sousuo = (ImageView) findViewById(R.id.sousuoactivity_imageview_sousuo);
        moreactivity_recy = (RecyclerView) findViewById(R.id.moreactivity_recy);
        homeactivity_radiobutton_hone = (RadioButton) findViewById(R.id.homeactivity_radiobutton_hone);
        homeactivity_radiobutton_circle = (RadioButton) findViewById(R.id.homeactivity_radiobutton_circle);
        homeactivity_radiobutton_shoopingcart = (RadioButton) findViewById(R.id.homeactivity_radiobutton_shoopingcart);
        homeactivity_radiobutton_list = (RadioButton) findViewById(R.id.homeactivity_radiobutton_list);
        homeactivity_radiobutton_my = (RadioButton) findViewById(R.id.homeactivity_radiobutton_my);
        homeactivity_radiogroup = (RadioGroup) findViewById(R.id.homeactivity_radiogroup);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void aasd(IdBean idBean){
        mRxspId = idBean.rxspId;
    }

    @Override
    public void setData(Object Data) {
        MoreBean moreBean= (MoreBean) Data;
        if (moreBean!=null){
            mMoreAdapter.setData(moreBean.getResult());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
