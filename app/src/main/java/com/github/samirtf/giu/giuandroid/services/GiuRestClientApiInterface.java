package com.github.samirtf.giu.giuandroid.services;

import com.github.samirtf.giu.giuandroid.retrofit_models.RegistrationToken;
import com.squareup.okhttp.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by samirtf on 5/4/16.
 */
public interface GiuRestClientApiInterface {

    String URL_BASE = "http://localhost";


    @FormUrlEncoded
    @POST("subscribers")
    Call<RegistrationToken> register(
            @Header("Accept") String acceptHeader,
            @Field("proto") String proto,
            @Field("token") String token,
            @Field("lang") String lang,
            @Field("badge") int badge,
            @Field("category") String category,
            @Field("contentAvailable") boolean contentAvailable
    );

    @FormUrlEncoded
    @POST("subscribers/{subscriberId}")
    Call<ResponseBody> ping(
            @Path("subscriberId") String subscriberId,
            @Field("lang") String lang,
            @Field("badge") int badge
    );

    @POST("subscriber/{subscriberId}/subscriptions/{event}")
    Call<ResponseBody> subscribeToAnEvent(
            @Path("subscriberId") String subscriberId,
            @Path("event") String event
    );

    @POST("subscriber/{subscriberId}/subscriptions")
    Call<ResponseBody> subscribeToEvents(
            @Header("Content-Type") String contentTypeHeader,
            @Path("subscriberId") String subscriberId,
            @Body String events
    );

    @DELETE("subscriber/{subscriberId}/subscriptions")
    Call<ResponseBody> unsubscribeFromEvents(
            @Header("Content-Type") String contentTypeHeader,
            @Path("subscriberId") String subscriberId,
            @Body String events
    );

    @POST("event/{event}")
    Call<ResponseBody> sendMessage(
            @Field("msg") String msg,
            @Path("event") String event
    );

    @GET("subscriber/{subscriberId}/subscriptions")
    Call<ResponseBody> listEvents(
            @Header("Content-Type") String contentType,
            @Path("subscriberId") String subscriberId
    );


}
