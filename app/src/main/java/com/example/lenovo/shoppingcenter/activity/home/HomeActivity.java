package com.example.lenovo.shoppingcenter.activity.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.fragment.CircleFragment;
import com.example.lenovo.shoppingcenter.fragment.HomeFragment;
import com.example.lenovo.shoppingcenter.fragment.ListFragment;
import com.example.lenovo.shoppingcenter.fragment.MyFragment;
import com.example.lenovo.shoppingcenter.fragment.ShoopingCartFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager homeactivity_viewpager;

    private List<Fragment> mList;

    private RadioButton homeactivity_radiobutton_hone;
    private RadioButton homeactivity_radiobutton_circle;
    private RadioButton homeactivity_radiobutton_shoopingcart;
    private RadioButton homeactivity_radiobutton_list;
    private RadioButton homeactivity_radiobutton_my;
    private RadioGroup homeactivity_radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add(new HomeFragment());
        mList.add(new CircleFragment());
        mList.add(new ShoopingCartFragment());
        mList.add(new ListFragment());
        mList.add(new MyFragment());

        homeactivity_viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mList.get(i);
            }

            @Override
            public int getCount() {
                return mList.size();
            }
        });

        homeactivity_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        homeactivity_radiogroup.check(R.id.homeactivity_radiobutton_hone);
                        break;
                    case 1:
                        homeactivity_radiogroup.check(R.id.homeactivity_radiobutton_circle);
                        break;
                    case 2:
                        homeactivity_radiogroup.check(R.id.homeactivity_radiobutton_shoopingcart);
                        break;
                    case 3:
                        homeactivity_radiogroup.check(R.id.homeactivity_radiobutton_list);
                        break;
                    case 4:
                        homeactivity_radiogroup.check(R.id.homeactivity_radiobutton_my);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        homeactivity_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.homeactivity_radiobutton_hone:
                        homeactivity_viewpager.setCurrentItem(0);
                        homeactivity_radiobutton_hone.setBackgroundResource(R.mipmap.common_tab_btn_home_s);
                        homeactivity_radiobutton_circle.setBackgroundResource(R.mipmap.common_tab_btn_circle_n);
                        homeactivity_radiobutton_shoopingcart.setBackgroundResource(R.mipmap.commom_tab_btn_shoppingcart_n);
                        homeactivity_radiobutton_list.setBackgroundResource(R.mipmap.common_tab_btn_list_n);
                        homeactivity_radiobutton_my.setBackgroundResource(R.mipmap.common_tab_btn_my_n);
                        break;
                    case R.id.homeactivity_radiobutton_circle:
                        homeactivity_viewpager.setCurrentItem(1);
                        homeactivity_radiobutton_hone.setBackgroundResource(R.mipmap.common_tab_btn_home_n);
                        homeactivity_radiobutton_circle.setBackgroundResource(R.mipmap.common_tab_btn_circle_s);
                        homeactivity_radiobutton_shoopingcart.setBackgroundResource(R.mipmap.commom_tab_btn_shoppingcart_n);
                        homeactivity_radiobutton_list.setBackgroundResource(R.mipmap.common_tab_btn_list_n);
                        homeactivity_radiobutton_my.setBackgroundResource(R.mipmap.common_tab_btn_my_n);
                        break;
                    case R.id.homeactivity_radiobutton_shoopingcart:
                        homeactivity_viewpager.setCurrentItem(2);
                        homeactivity_radiobutton_hone.setBackgroundResource(R.mipmap.common_tab_btn_home_n);
                        homeactivity_radiobutton_circle.setBackgroundResource(R.mipmap.common_tab_btn_circle_n);
                        homeactivity_radiobutton_shoopingcart.setBackgroundResource(R.mipmap.commom_tab_btn_shoppingcart_n);
                        homeactivity_radiobutton_list.setBackgroundResource(R.mipmap.common_tab_btn_list_n);
                        homeactivity_radiobutton_my.setBackgroundResource(R.mipmap.common_tab_btn_my_n);
                        break;
                    case R.id.homeactivity_radiobutton_list:
                        homeactivity_viewpager.setCurrentItem(3);
                        homeactivity_radiobutton_hone.setBackgroundResource(R.mipmap.common_tab_btn_home_n);
                        homeactivity_radiobutton_circle.setBackgroundResource(R.mipmap.common_tab_btn_circle_n);
                        homeactivity_radiobutton_shoopingcart.setBackgroundResource(R.mipmap.commom_tab_btn_shoppingcart_n);
                        homeactivity_radiobutton_list.setBackgroundResource(R.mipmap.common_tab_btn_list_s);
                        homeactivity_radiobutton_my.setBackgroundResource(R.mipmap.common_tab_btn_my_n);
                        break;
                    case R.id.homeactivity_radiobutton_my:
                        homeactivity_viewpager.setCurrentItem(4);
                        homeactivity_radiobutton_hone.setBackgroundResource(R.mipmap.common_tab_btn_home_n);
                        homeactivity_radiobutton_circle.setBackgroundResource(R.mipmap.common_tab_btn_circle_n);
                        homeactivity_radiobutton_shoopingcart.setBackgroundResource(R.mipmap.commom_tab_btn_shoppingcart_n);
                        homeactivity_radiobutton_list.setBackgroundResource(R.mipmap.common_tab_btn_list_n);
                        homeactivity_radiobutton_my.setBackgroundResource(R.mipmap.common_tab_btn_my_s);
                        break;
                }

            }
        });

    }


    private void initView() {
        homeactivity_viewpager = (ViewPager) findViewById(R.id.homeactivity_viewpager);


        homeactivity_radiobutton_hone = (RadioButton) findViewById(R.id.homeactivity_radiobutton_hone);
        homeactivity_radiobutton_hone.setOnClickListener(this);
        homeactivity_radiobutton_circle = (RadioButton) findViewById(R.id.homeactivity_radiobutton_circle);
        homeactivity_radiobutton_circle.setOnClickListener(this);
        homeactivity_radiobutton_shoopingcart = (RadioButton) findViewById(R.id.homeactivity_radiobutton_shoopingcart);
        homeactivity_radiobutton_shoopingcart.setOnClickListener(this);
        homeactivity_radiobutton_list = (RadioButton) findViewById(R.id.homeactivity_radiobutton_list);
        homeactivity_radiobutton_list.setOnClickListener(this);
        homeactivity_radiobutton_my = (RadioButton) findViewById(R.id.homeactivity_radiobutton_my);
        homeactivity_radiobutton_my.setOnClickListener(this);
        homeactivity_radiogroup = (RadioGroup) findViewById(R.id.homeactivity_radiogroup);
        homeactivity_radiogroup.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }
}
