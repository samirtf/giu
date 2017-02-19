package com.github.samirtf.giu.giuandroid.services;


import com.github.samirtf.giu.giuandroid.model.Device;
import com.github.samirtf.giu.giuandroid.model.TexPlainConverter;
import com.github.samirtf.giu.giuandroid.retrofit_models.RegistrationToken;
import com.github.samirtf.giu.giuandroid.retrofit_models.mappers.EventMapper;
import com.github.samirtf.giu.giuandroid.retrofit_models.mappers.EventsMapper;
import com.github.samirtf.giu.giuandroid.retrofit_models.mappers.MessageMapper;
import com.github.samirtf.giu.giuandroid.retrofit_models.mappers.PingMapper;
import com.github.samirtf.giu.giuandroid.retrofit_models.mappers.RegistrationMapper;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by samirtf on 5/4/16.
 */
public class GiuRestClient {

    // Trailing slash is needed
    private static final String BASE_URL = "http://localhost";
    public static final String APP_JSON_CONTENT_TYPE_HEADER = "application/json";
    public static final String URL_FORM_CONTENT_TYPE_HEADER = "application/x-www-form-urlencoded";
    public static final String JSON_ACCEPT_HEADER = "application/json";
    public static final String TEXT_HTML_ACCEPT_HEADER = "text/html";

    private GiuRestClientApiInterface giuService;
    private static final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    private static final OkHttpClient.Builder client = new OkHttpClient.Builder();

    static {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(logging);
        client.readTimeout(20, TimeUnit.SECONDS);
        client.connectTimeout(20, TimeUnit.SECONDS);
        client.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Content-Type", APP_JSON_CONTENT_TYPE_HEADER)
                        .header("Accept", JSON_ACCEPT_HEADER)
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
    }

    public GiuRestClient() {
        createRetrofitService();
    }

    private void createRetrofitService() {
        giuService = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .client(client.build())
                .build().create(GiuRestClientApiInterface.class);
    }


    public void register(final RegistrationMapper registrationMapper, final Callback<RegistrationToken> callback) {
        Call<RegistrationToken> call = giuService.register(
                JSON_ACCEPT_HEADER,
                registrationMapper.getProto(),
                registrationMapper.getToken(),
                registrationMapper.getLang(),
                registrationMapper.getBadge(),
                registrationMapper.getCategory(),
                registrationMapper.isContentAvailable()
        );
        call.enqueue(callback);
    }

    public void ping(final PingMapper pingMapper, final Callback<ResponseBody> callback) {
        Call<ResponseBody> call = giuService.ping(
                pingMapper.getSubscriberId(),
                pingMapper.getLang(),
                pingMapper.getBadge()
        );
        call.enqueue(callback);
    }

    public void subscribeToAnEvent(final EventMapper eventMapper, final Callback<ResponseBody> callback) {
        Call<ResponseBody> call = giuService.subscribeToAnEvent(
                eventMapper.getSubscriberId(),
                eventMapper.getEvent()
        );
        call.enqueue(callback);
    }

    public void subscribeToEvents(final EventsMapper eventsMapper, final Callback<ResponseBody> callback) {
        Call<ResponseBody> call = giuService.subscribeToEvents(
                APP_JSON_CONTENT_TYPE_HEADER,
                eventsMapper.getSubscriberId(),
                eventsMapper.getEventsAsJson()
        );
        call.enqueue(callback);
    }

    public void unsubscribeFromEvents(final EventsMapper eventsMapper, final Callback<ResponseBody> callback) {
        Call<ResponseBody> call = giuService.unsubscribeFromEvents(
                APP_JSON_CONTENT_TYPE_HEADER,
                eventsMapper.getSubscriberId(),
                eventsMapper.getEventsAsJson()
        );
        call.enqueue(callback);
    }

    public void sendMessage(final MessageMapper messageMapper, final Callback<ResponseBody> callback) {
        Call<ResponseBody> call = giuService.sendMessage(
                messageMapper.getMessage(),
                messageMapper.getEvent()
        );
        call.enqueue(callback);
    }

    public void listEvents(String subscriberId, final Callback<ResponseBody> callback) {
        Call<ResponseBody> call = giuService.listEvents(
                APP_JSON_CONTENT_TYPE_HEADER,
                subscriberId
        );
        call.enqueue(callback);
    }


}
