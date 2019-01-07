package com.example.lenovo.shoppingcenter.presenter;

import android.provider.ContactsContract;

import com.example.lenovo.shoppingcenter.bean.LoginBean;
import com.example.lenovo.shoppingcenter.callback.ICallBack;
import com.example.lenovo.shoppingcenter.model.IModel;
import com.example.lenovo.shoppingcenter.model.IModelImpl;
import com.example.lenovo.shoppingcenter.view.IView;

import java.util.Map;

/**
 * date:2018.12.29
 * author:赵颖冰(lenovo)
 * function:
 */
public class IPersenterImpl implements Ipersenter {
    IView mIView;
    IModelImpl mIModelImpl;

    public IPersenterImpl(IView IView) {
        mIView = IView;
        mIModelImpl=new IModelImpl();
    }


    @Override
    public void setPostRequest(String url, Map<String, String> map, Class clazz) {
        mIModelImpl.setResponse(url, map, clazz, new ICallBack() {
            @Override
            public void onData(Object data) {
                mIView.setData(data);
            }
        });
    }

    @Override
    public void setGetRequest(String url, Map<String, String> map, Class clazz) {
        mIModelImpl.setGetResponse(url, map, clazz, new ICallBack() {
            @Override
            public void onData(Object data) {
                mIView.setData(data);
            }
        });
    }

    @Override
    public void setGetHeadRequest(String url, Map<String, String> map, Map<String, Object> mapHead, Class clazz) {
        mIModelImpl.setGetHeadResponse(url, map, mapHead, clazz, new ICallBack() {
            @Override
            public void onData(Object data) {
                mIView.setData(data);
            }
        });
    }


}
