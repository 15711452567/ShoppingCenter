package com.example.lenovo.shoppingcenter.adapter.listadapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * date:2018.12.29
 * author:赵颖冰(lenovo)
 * function:
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<String> titlelists;
    List<Fragment> fragmentlists;

    public ViewPagerAdapter(FragmentManager fm, List<String> titleList, List<Fragment> fragmentList) {
        super(fm);
        titlelists=titleList;
        fragmentlists=fragmentList;

    }

    @Override
    public Fragment getItem(int i) {
        return fragmentlists.get(i);
    }

    @Override
    public int getCount() {
        return fragmentlists.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelists.get(position);
    }
}
