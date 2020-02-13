package com.bw.forwardfinalsample.util;

import com.bw.forwardfinalsample.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//假如订单的接口和登录注册的域名不一样，怎么办？？？
public class NetUtil {

    private static final String BASE_URL = "http://mobile.bwstudent.com/";
    private final Api api;

    //1、geti
    public static NetUtil getInstance() {
        return SingleHolder.NET_UTIL;
    }

    //2、私有构造器
    private NetUtil() {
        //ok的拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //okhttpClient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.SECONDS)
                .readTimeout(8, TimeUnit.SECONDS)
                .writeTimeout(8, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    //3、私有的静态内部类
    private static final class SingleHolder {
        private static final NetUtil NET_UTIL = new NetUtil();
    }

    //提供給外界使用
    public Api getApi() {
        return api;
    }
}
