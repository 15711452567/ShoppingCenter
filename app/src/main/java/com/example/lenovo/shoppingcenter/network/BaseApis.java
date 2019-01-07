package com.example.lenovo.shoppingcenter.network;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * date:2018.12.29
 * author:赵颖冰(lenovo)
 * function:
 */
public interface BaseApis{

    @GET
    Observable<ResponseBody> get(@Url String url,@QueryMap Map<String,String> map);

    @POST
    Observable<ResponseBody> post(@Url String url, @QueryMap Map<String,String> map);


    @GET
    Observable<ResponseBody> getHead(@Url String url, @QueryMap Map<String,String> map, @HeaderMap Map<String ,Object> map1);
}
