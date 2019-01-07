package com.example.lenovo.shoppingcenter.model;

import com.example.lenovo.shoppingcenter.callback.ICallBack;
import com.example.lenovo.shoppingcenter.network.RetrofitUtils;
import com.example.lenovo.shoppingcenter.presenter.IPersenterImpl;
import com.google.gson.Gson;

import java.util.Map;

/**
 * date:2018.12.29
 * author:赵颖冰(lenovo)
 * function:
 */
public class IModelImpl implements IModel {


    @Override
    public void setResponse(String url, Map<String, String> map, final Class clazz, final ICallBack iCallBack) {
        RetrofitUtils.getInstance().post(url, map, new RetrofitUtils.HttpListener() {
            @Override
            public void setSuccess(String data) {
                Object o = new Gson().fromJson(data, clazz);
                iCallBack.onData(o);
            }

            @Override
            public void SetField(String e) {

            }
        });
    }

    @Override
    public void setGetResponse(String url, Map<String, String> map, final Class clazz, final ICallBack iCallBack) {
        RetrofitUtils.getInstance().get(url, map, new RetrofitUtils.HttpListener() {
            @Override
            public void setSuccess(String data) {
                Object o = new Gson().fromJson(data, clazz);
                iCallBack.onData(o);
            }

            @Override
            public void SetField(String e) {

            }
        });
    }

    @Override
    public void setGetHeadResponse(String url, Map<String, String> map, Map<String, Object> mapHead, final Class clazz, final ICallBack iCallBack) {
        RetrofitUtils.getInstance().getHead(url, map, mapHead, new RetrofitUtils.HttpListener() {
            @Override
            public void setSuccess(String data) {
                Object o = new Gson().fromJson(data, clazz);
                iCallBack.onData(o);
            }

            @Override
            public void SetField(String e) {

            }
        });
    }


}
