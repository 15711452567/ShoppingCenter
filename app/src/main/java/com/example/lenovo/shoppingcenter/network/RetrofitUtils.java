package com.example.lenovo.shoppingcenter.network;

import com.example.lenovo.shoppingcenter.Apis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * date:2018.12.29
 * author:赵颖冰(lenovo)
 * function:
 */
public class RetrofitUtils<T> {

    private static RetrofitUtils mRetrofitUtils;

    public static synchronized RetrofitUtils getInstance(){

        if (mRetrofitUtils==null){
            mRetrofitUtils=new RetrofitUtils();
        }
        return mRetrofitUtils;
    }

    BaseApis mBaseApis;

    public RetrofitUtils() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.SECONDS);
        builder.readTimeout(5, TimeUnit.SECONDS);
        builder.writeTimeout(5, TimeUnit.SECONDS);
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        builder.retryOnConnectionFailure(true);
        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Apis.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        mBaseApis = retrofit.create(BaseApis.class);
    }

    public RetrofitUtils get(String url,Map<String,String> map,HttpListener listener){

        mBaseApis.get(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));

        return mRetrofitUtils;
    }

    public void post(String url, Map<String,String> map,HttpListener listener){

        if(map==null){
            map = new HashMap<>();
        }

        mBaseApis.post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));


    }

    public void getHead(String url, Map<String,String> map,Map<String,Object> mapHead,HttpListener listener){

        if(map==null){
            map = new HashMap<>();
        }
        if(mapHead==null){
            mapHead = new HashMap<>();
        }
        mBaseApis.getHead(url,map,mapHead)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));


    }

    private Observer getObserver(final HttpListener listener) {
         Observer observer = new Observer<ResponseBody>() {

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String data = responseBody.string();

                    if (listener != null) {
                        listener.setSuccess(data);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (listener != null) {
                    listener.SetField(e.getMessage());
                }
            }


        };
         return observer;
    }

    private HttpListener listener;

    public interface HttpListener{
        void setSuccess(String data);
        void SetField(String e);
    }
    public void listener(HttpListener Clicklistenr){
        this.listener = Clicklistenr;
    }


}
