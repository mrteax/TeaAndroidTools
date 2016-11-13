package com.tea.android.utils.netWorkSample;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by brc on 2016/10/27.
 */

public class OkHttpSample {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private String get(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String post(String url, String json) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
