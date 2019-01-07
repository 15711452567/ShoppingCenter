package com.example.lenovo.shoppingcenter.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.shoppingcenter.R;
import com.example.lenovo.shoppingcenter.adapter.listadapter.ViewPagerAdapter;
import com.example.lenovo.shoppingcenter.fragment.listfragment.AllOrdersFragment;
import com.example.lenovo.shoppingcenter.fragment.listfragment.ObligationFragment;
import com.example.lenovo.shoppingcenter.fragment.listfragment.OffTheStocksFragment;
import com.example.lenovo.shoppingcenter.fragment.listfragment.RemainToBeEvaluatedFragment;
import com.example.lenovo.shoppingcenter.fragment.listfragment.WaitForReceivingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private TabLayout listfragment_tablayout;
    private ViewPager listfragment_vp;
    private List<String> mTitleList;
    private List<Fragment> mFragmentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        initView(view);
        initData();
        return view;
    }

    private void initData() {

        mTitleList = new ArrayList<>();
        mTitleList.add("全部订单");
        mTitleList.add("待付款");
        mTitleList.add("待收货");
        mTitleList.add("待评价");
        mTitleList.add("已完成");

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new AllOrdersFragment());
        mFragmentList.add(new ObligationFragment());
        mFragmentList.add(new WaitForReceivingFragment());
        mFragmentList.add(new RemainToBeEvaluatedFragment());
        mFragmentList.add(new OffTheStocksFragment());

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getChildFragmentManager(),mTitleList,mFragmentList);
        listfragment_vp.setAdapter(viewPagerAdapter);
        listfragment_vp.setCurrentItem(0);



        listfragment_tablayout.addTab(listfragment_tablayout.newTab().setText(mTitleList.get(0)));
        listfragment_tablayout.addTab(listfragment_tablayout.newTab().setText(mTitleList.get(1)));
        listfragment_tablayout.addTab(listfragment_tablayout.newTab().setText(mTitleList.get(2)));
        listfragment_tablayout.addTab(listfragment_tablayout.newTab().setText(mTitleList.get(3)));
        listfragment_tablayout.addTab(listfragment_tablayout.newTab().setText(mTitleList.get(4)));

        listfragment_tablayout.setupWithViewPager(listfragment_vp);

        TabLayout.Tab one = listfragment_tablayout.getTabAt(0);
        TabLayout.Tab two = listfragment_tablayout.getTabAt(1);
        TabLayout.Tab three = listfragment_tablayout.getTabAt(2);
        TabLayout.Tab four = listfragment_tablayout.getTabAt(3);
        TabLayout.Tab five = listfragment_tablayout.getTabAt(4);

        one.setIcon(R.mipmap.listfragment_quanbudingdan);
        two.setIcon(R.mipmap.listfragment_daifukuan);
        three.setIcon(R.mipmap.listfragment_daishouhuo);
        four.setIcon(R.mipmap.listfragment_daipingjia);
        five.setIcon(R.mipmap.listfragment_yiwancheng);





    }

    private void initView(View view) {
        listfragment_tablayout = (TabLayout) view.findViewById(R.id.listfragment_tablayout);
        listfragment_vp = (ViewPager) view.findViewById(R.id.listfragment_vp);
    }
}
