package com.github.samirtf.giu.giuandroid.model;

import com.google.gson.JsonElement;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONObject;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by samirtf on 5/4/16.
 */
public interface GiuRestClientApiInterface {

    @FormUrlEncoded
    @POST("http://ubuntu@ec2-52-67-59-160.sa-east-1.compute.amazonaws.com:50080/subscribers")
    Call<ResponseBody> registerDevice(@Field("proto") String proto, @Field("token") String token,
                                      @Field("lang") String lang, @Field("badge") int badge,
                                      @Field("category") String category,
                                      @Field("contentAvailable") String contentAvailable);

    @FormUrlEncoded
    @POST("http://ubuntu@ec2-52-67-59-160.sa-east-1.compute.amazonaws.com:50080/subscribers/{id}")
    Call<ResponseBody> ping(@Field("lang") String lang, @Field("badge") int badge, @Path("id") String id);

    @POST("http://ubuntu@ec2-52-67-59-160.sa-east-1.compute.amazonaws.com:50080/subscriber/{id}/subscriptions/{channel}")
    Call<ResponseBody> subscribe(@Path("id") String id, @Path("channel") String channel);

//    @PUT("/user/{id}/update")
//    Call<JSONObject> updateUser(@Path("id") String id , @Body Item user);

//    @GET("http://10.100.100.5:3000/account")
//    Call<NodejsResult> getUsers(@Query("username") String username, @Query("password") String password);

    //ubuntu@ec2-52-67-59-160.sa-east-1.compute.amazonaws.com:50080
    //@FormUrlEncoded
    //@POST("http://10.90.90.243:5080/subscribers")

    //curl -d lang=fr -d badge=0 http://ubuntu@ec2-52-67-59-160.sa-east-1.compute.amazonaws.com:50080/subscribers/NHQXGqavlnc
    //curl -X POST http://ubuntu@ec2-52-67-59-160.sa-east-1.compute.amazonaws.com:50080/subscriber/NHQXGqavlnc/subscriptions/sports
    //curl -d msg=Test%20message http://ubuntu@ec2-52-67-59-160.sa-east-1.compute.amazonaws.com:50080/event/sports
}
