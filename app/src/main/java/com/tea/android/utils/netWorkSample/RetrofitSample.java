package com.tea.android.utils.netWorkSample;

import android.content.Context;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by brc on 2016/10/28.
 */

public class RetrofitSample {
    Context mContext;
    public RetrofitSample(Context context) {
        mContext = context;
    }

    public void doRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        String userName = "mrteax";
        Call<GitApi> call = service.getUser(userName);
        call.enqueue(new Callback<GitApi>() {
            @Override
            public void onResponse(Call<GitApi> call, Response<GitApi> response) {
                // do response
                GitApi api = response.body();
                Log.i("RetrofitSample", "success: " + response.isSuccessful() + ", url = " + api.getUrl());
            }

            @Override
            public void onFailure(Call<GitApi> call, Throwable t) {
                // do failure
                Log.i("RetrofitSample", "throw: " + t.toString());
            }
        });
    }
}
