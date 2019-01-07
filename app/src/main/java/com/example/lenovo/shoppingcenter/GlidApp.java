package com.example.lenovo.shoppingcenter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * date:2018.12.28
 * author:赵颖冰(lenovo)
 * function:
 */
public class GlidApp extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
