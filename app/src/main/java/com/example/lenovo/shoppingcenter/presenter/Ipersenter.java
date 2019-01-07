package com.example.lenovo.shoppingcenter.presenter;

import java.util.Map;

/**
 * date:2018.12.29
 * author:赵颖冰(lenovo)
 * function:
 */
public interface Ipersenter {
    void setPostRequest(String url, Map<String,String> map,Class clazz);

    void setGetRequest(String url, Map<String,String> map,Class clazz);

    void setGetHeadRequest(String url, Map<String,String> map,Map<String,Object> mapHead,Class clazz);
}
