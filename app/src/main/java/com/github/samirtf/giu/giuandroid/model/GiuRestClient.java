package com.github.samirtf.giu.giuandroid.model;


import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by samirtf on 5/4/16.
 */
public class GiuRestClient {

    private GiuRestClientApiInterface giuRestClientApiInterface;
    private Device device;

    public GiuRestClient(Device device) {
        this.device = device;
    }

    public GiuRestClientApiInterface getClient() {
        if (giuRestClientApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(device.getBaseUrl())
                    .addConverter(String.class, new TexPlainConverter())
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            giuRestClientApiInterface = client.create(GiuRestClientApiInterface.class);
        }
        return giuRestClientApiInterface;
    }

}
