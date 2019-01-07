package com.example.lenovo.shoppingcenter.fragment.listfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.shoppingcenter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OffTheStocksFragment extends Fragment {


    public OffTheStocksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_off_the_stocks, container, false);
    }

}
