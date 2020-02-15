package com.bw.forwardfinalsample;

import com.bw.forwardfinalsample.model.bean.LoginBean;
import com.bw.forwardfinalsample.model.bean.OrderformBean;
import com.bw.forwardfinalsample.model.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 坑点：
 * Observable必须是io包下的
 */
public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterBean> register(@Field("phone") String phone, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> login(@Field("phone") String phone, @Field("pwd") String pwd);

    //假如订单接口的公共部分和登录注册不一样怎么办？ 订单直接用完成的url
    @GET("http://mobile.bwstudent.com/small/order/verify/v1/findOrderListByStatus")
    Observable<OrderformBean> getOrderformData(@Header("userId") int userId,
                                               @Header("sessionId") String sessionId,
                                               @Query("status") int status,
                                               @Query("page") int page,
                                               @Query("count") int count);



}
