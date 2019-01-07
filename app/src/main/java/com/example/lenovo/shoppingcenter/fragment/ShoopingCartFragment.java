package com.example.lenovo.shoppingcenter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.shoppingcenter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoopingCartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_shooping_cart, container, false);
        return view;
    }

}
