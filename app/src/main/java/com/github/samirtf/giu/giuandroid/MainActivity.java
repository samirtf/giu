package com.github.samirtf.giu.giuandroid;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.samirtf.giu.giuandroid.model.Device;
import com.github.samirtf.giu.giuandroid.model.GiuRestClient;
import com.github.samirtf.giu.giuandroid.model.GiuRestClientApiInterface;
import com.github.samirtf.giu.giuandroid.model.Proto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class MainActivity extends AppCompatActivity {

    public static String TOKEN = "d36OsySozm0:APA91bHrRkTQtu5fJOYJUS2hCq4L3842F8A24LJ1KX8IHcojCzeXT85961q5AIyTNo66dOrgEWc71qrxedHpowtj2C7wOkqjqf1xrmfHAkmDumu0OHPiPCnoAF1wMld5hp5TEZGNbi8G";
    public static String LANG = "fr";
    public static int BADGE = 0;
    public static String CATEGORY = "show";
    public static String CONTENT_AVAILABLE = "true";
    //    public static String BASE_URL = "http://10.90.90.243:5080";
    public static String BASE_URL = "http://ubuntu@ec2-52-67-59-160.sa-east-1.compute.amazonaws.com:50080";

    private Device device = new Device(Proto.GCM, TOKEN, LANG, BADGE, CATEGORY, CONTENT_AVAILABLE, BASE_URL);
    GiuRestClient giuRestClient;
    GiuRestClientApiInterface service;

    private TextView statusTextViewiew;
    private Button registerButton;
    private Button pingButton;
    private Button subscribeButton;
    private EditText channelEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextViewiew = (TextView) findViewById(R.id.label_status);

        registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giuRestClient = new GiuRestClient(device);
                service = giuRestClient.getClient();
                register(service);
            }
        });

        pingButton = (Button) findViewById(R.id.ping_button);
        pingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != giuRestClient && null != service) {
                    ping(service);
                }


            }
        });

        subscribeButton = (Button) findViewById(R.id.subscribe_button);
        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != giuRestClient && null != service) {
                    String channel = channelEditText.getText().toString();
                    subscribe(service, channel);
                }


            }
        });

        channelEditText = (EditText) findViewById(R.id.channel_edit_text);

    }

    public void register(GiuRestClientApiInterface service) {
        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        Call<ResponseBody> call = service.registerDevice(device.getProto().toString(), device.getToken(),
                device.getLang(), device.getBadge(), device.getCategory(), device.getContentAvailable());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response) {
                dialog.dismiss();
                Log.d("MainActivity", "Status Code = " + response.code());
                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    ResponseBody result = response.body();
                    try {
                        byte[] bytes = result.bytes();
                        String jsonData = new String(bytes);
                        Log.d("MainActivity", "JSONObject response = " + jsonData);
                        //Log.d("MainActivity", "response = " + new Gson().toJson(response.body().string()));


                        JSONObject jSonResponse = new JSONObject(jsonData);
                        device.setLang(jSonResponse.getString("lang"));
                        Proto protoResponsed = null;
                        switch (jSonResponse.getString("proto")) {
                            case "apn":
                                protoResponsed = Proto.APN;
                            case "wpn":
                                protoResponsed = Proto.WPM;
                            case "gcm":
                                protoResponsed = Proto.GCM;
                        }
                        device.setProto(protoResponsed);
                        device.setBadge(jSonResponse.getInt("badge"));
                        device.setUpdated(jSonResponse.getLong("updated"));
                        device.setCategory(jSonResponse.getString("category"));
                        device.setContentAvailable(jSonResponse.getString("contentAvailable"));
                        device.setToken(jSonResponse.getString("token"));
                        device.setId(jSonResponse.getString("id"));
                        device.setCreated(jSonResponse.getLong("created"));

                        Log.d("MainActivity", "Device updated.");
                        statusTextViewiew.setText("STATUS: " + "REGISTERED!");
                    } catch (JSONException e) {
                        statusTextViewiew.setText("STATUS: " + "FAILED!");
                        e.printStackTrace();
                    } catch (IOException e) {
                        statusTextViewiew.setText("STATUS: " + "FAILED!");
                        e.printStackTrace();
                    }

                    //adapter = new UserAdapter(MainActivity.this, Users);
                } else {
                    // response received but request not successful (like 400,401,403 etc)
                    //Handle errors
                    Log.d("MainActivity", "error:" + response.code());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
                Log.d("MainActivity", "Failure:" + t.toString());
                statusTextViewiew.setText("STATUS: " + "FAILED!");
            }
        });
    }

    public void ping(GiuRestClientApiInterface service) {
        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        Call<ResponseBody> call = service.ping(device.getLang(), device.getBadge(), device.getId());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response) {
                dialog.dismiss();
                Log.d("MainActivity", "Status Code = " + response.code());
                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    ResponseBody result = response.body();
                    try {
                        byte[] bytes = result.bytes();
                        String jsonData = new String(bytes);
                        Log.d("MainActivity", "JSONObject response = " + jsonData);
                        //Log.d("MainActivity", "response = " + new Gson().toJson(response.body().string()));


//                        JSONObject jSonResponse = new JSONObject(jsonData);
//                        device.setLang(jSonResponse.getString("lang"));
//                        Proto protoResponsed = null;
//                        switch (jSonResponse.getString("proto")) {
//                            case "apn":
//                                protoResponsed = Proto.APN;
//                            case "wpn":
//                                protoResponsed = Proto.WPM;
//                            case "gcm":
//                                protoResponsed = Proto.GCM;
//                        }
//                        device.setProto(protoResponsed);
//                        device.setBadge(jSonResponse.getInt("badge"));
//                        device.setUpdated(jSonResponse.getLong("updated"));
//                        device.setCategory(jSonResponse.getString("category"));
//                        device.setContentAvailable(jSonResponse.getString("contentAvailable"));
//                        device.setToken(jSonResponse.getString("token"));
//                        device.setId(jSonResponse.getString("id"));
//                        device.setCreated(jSonResponse.getLong("created"));

                        Log.d("MainActivity", "Device pinged.");
                        statusTextViewiew.setText("STATUS: " + "PINGED!");
                    }/* catch (JSONException e) {
                        statusTextViewiew.setText("STATUS: " + "FAILED!");
                        e.printStackTrace();
                    }*/ catch (IOException e) {
                        statusTextViewiew.setText("STATUS: " + "FAILED!");
                        e.printStackTrace();
                    }

                    //adapter = new UserAdapter(MainActivity.this, Users);
                } else {
                    // response received but request not successful (like 400,401,403 etc)
                    //Handle errors
                    Log.d("MainActivity", "error:" + response.code());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
                Log.d("MainActivity", "Failure:" + t.toString());
                statusTextViewiew.setText("STATUS: " + "FAILED!");
            }
        });
    }

    public void subscribe(GiuRestClientApiInterface service, String channel) {
        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        Call<ResponseBody> call = service.subscribe(device.getId(), channel);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response) {
                dialog.dismiss();
                Log.d("MainActivity", "Status Code = " + response.code());
                if (response.isSuccess()) {
                    Log.d("MainActivity", "Device pinged.");
                    statusTextViewiew.setText("STATUS: " + "PINGED!");
                    // request successful (status code 200, 201)
                    if (null != response && null != response.body()) {
                        ResponseBody result = response.body();
                        try {
                            byte[] bytes = result.bytes();
                            String jsonData = new String(bytes);
                            Log.d("MainActivity", "JSONObject response = " + jsonData);
                            //Log.d("MainActivity", "response = " + new Gson().toJson(response.body().string()));


//                        JSONObject jSonResponse = new JSONObject(jsonData);
//                        device.setLang(jSonResponse.getString("lang"));
//                        Proto protoResponsed = null;
//                        switch (jSonResponse.getString("proto")) {
//                            case "apn":
//                                protoResponsed = Proto.APN;
//                            case "wpn":
//                                protoResponsed = Proto.WPM;
//                            case "gcm":
//                                protoResponsed = Proto.GCM;
//                        }
//                        device.setProto(protoResponsed);
//                        device.setBadge(jSonResponse.getInt("badge"));
//                        device.setUpdated(jSonResponse.getLong("updated"));
//                        device.setCategory(jSonResponse.getString("category"));
//                        device.setContentAvailable(jSonResponse.getString("contentAvailable"));
//                        device.setToken(jSonResponse.getString("token"));
//                        device.setId(jSonResponse.getString("id"));
//                        device.setCreated(jSonResponse.getLong("created"));


                        }/* catch (JSONException e) {
                        statusTextViewiew.setText("STATUS: " + "FAILED!");
                        e.printStackTrace();
                    }*/ catch (IOException e) {
                            statusTextViewiew.setText("STATUS: " + "FAILED!");
                            e.printStackTrace();
                        }
                    }

                    //adapter = new UserAdapter(MainActivity.this, Users);
                } else {
                    // response received but request not successful (like 400,401,403 etc)
                    //Handle errors
                    Log.d("MainActivity", "error:" + response.code());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
                Log.d("MainActivity", "Failure:" + t.toString());
                statusTextViewiew.setText("STATUS: " + "FAILED!");
            }
        });
    }

}
