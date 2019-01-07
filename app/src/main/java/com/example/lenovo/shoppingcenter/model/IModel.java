package com.example.lenovo.shoppingcenter.model;

import com.example.lenovo.shoppingcenter.callback.ICallBack;

import java.util.Map;

/**
 * date:2018.12.29
 * author:赵颖冰(lenovo)
 * function:
 */
public interface IModel {
    void setResponse(String url, Map<String,String> map, Class clazz, ICallBack iCallBack);

    void setGetResponse(String url, Map<String,String> map, Class clazz, ICallBack iCallBack);

    void setGetHeadResponse(String url, Map<String,String> map,Map<String,Object> mapHead, Class clazz, ICallBack iCallBack);

}
