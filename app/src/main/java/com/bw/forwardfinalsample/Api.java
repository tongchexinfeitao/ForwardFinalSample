package com.bw.forwardfinalsample;

import com.bw.forwardfinalsample.model.bean.LoginBean;
import com.bw.forwardfinalsample.model.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterBean> register(@Field("phone") String phone, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> login(@Field("phone") String phone, @Field("pwd") String pwd);
}
