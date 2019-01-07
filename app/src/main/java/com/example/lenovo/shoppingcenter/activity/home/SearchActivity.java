package com.example.lenovo.shoppingcenter.activity.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.shoppingcenter.Apis;
import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.adapter.homeadapter.HomeSouSuoAdapter;
import com.example.lenovo.shoppingcenter.bean.SousuoBean;
import com.example.lenovo.shoppingcenter.presenter.IPersenterImpl;
import com.example.lenovo.shoppingcenter.view.IView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private ImageView sousuoactivity_imageview_fenlei;
    private EditText shurusousuo;
    private ImageView sousuoactivity_imageview_sousuo;
    private ImageView sousuoActivity_imageview_sousuokong;

    private IPersenterImpl mIPersenter;
    private RecyclerView sousuoActivity_xrecy_sousuo;

    private HomeSouSuoAdapter mHomeSouSuoAdapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            handler.sendEmptyMessageDelayed(0,5000);
        }
    };
    private String mTrim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mIPersenter = new IPersenterImpl(this);
        initView();
        //初始化数据
        initData("1");


    }

    private void initData(String trim) {

        Map<String, String> map = new HashMap<>();
        map.put("keyword", trim);
        map.put("page", "1");
        map.put("count", "5");
        mIPersenter.setGetRequest(Apis.SOUSUO_URL, map, SousuoBean.class);

        //recyclerview 设置
        mHomeSouSuoAdapter = new HomeSouSuoAdapter(this);
        sousuoActivity_xrecy_sousuo.setAdapter(mHomeSouSuoAdapter);
        sousuoActivity_xrecy_sousuo.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

    }



    //初始化布局
    private void initView() {
        sousuoactivity_imageview_fenlei = (ImageView) findViewById(R.id.sousuoactivity_imageview_fenlei);
        shurusousuo = (EditText) findViewById(R.id.shurusousuo);
        sousuoactivity_imageview_sousuo = (ImageView) findViewById(R.id.sousuoactivity_imageview_sousuo);
        sousuoActivity_imageview_sousuokong = (ImageView) findViewById(R.id.sousuoActivity_imageview_sousuokong);
        sousuoActivity_xrecy_sousuo = (RecyclerView) findViewById(R.id.sousuoActivity_xrecy_sousuo);

        sousuoActivity_xrecy_sousuo.setOnClickListener(this);
        sousuoactivity_imageview_sousuo.setOnClickListener(this);
    }
    //获取数据
    @Override
    public void setData(Object Data) {
        SousuoBean sousuoBean= (SousuoBean) Data;
        List<SousuoBean.ResultBean> result = sousuoBean.getResult();
        if (result.isEmpty()){
            sousuoActivity_imageview_sousuokong.setVisibility(View.VISIBLE);
            sousuoActivity_xrecy_sousuo.setVisibility(View.GONE);

        }else {
            sousuoActivity_xrecy_sousuo.setVisibility(View.VISIBLE);
            sousuoActivity_imageview_sousuokong.setVisibility(View.GONE);
            mHomeSouSuoAdapter.setData(result);
        }


    }
    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sousuoactivity_imageview_sousuo:
                mTrim = shurusousuo.getText().toString().trim();

                if (TextUtils.isEmpty(mTrim)) {

                    Toast.makeText(this, "请输入您要查找的宝贝", Toast.LENGTH_SHORT).show();
                    return;
                } else  {
                    initData(mTrim);
                }

                break;
        }
    }
}
