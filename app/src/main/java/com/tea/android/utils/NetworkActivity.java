package com.tea.android.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tea.android.utils.netWorkSample.RetrofitSample;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by brc on 2016/10/27.
 */

public class NetworkActivity extends Activity {
    @BindView(R.id.btn_retrofit_get)
    Button retrofitGet;
    @BindView(R.id.btn_retrofit_post)
    Button retrofitPost;
    @BindView(R.id.btn_okhttp_get)
    Button okhttpGet;
    @BindView(R.id.btn_okhttp_post)
    Button okhttpPost;
    @BindView(R.id.btn_volley_get)
    Button volleyGet;
    @BindView(R.id.btn_volley_post)
    Button volleyPost;
    @BindView(R.id.btn_httpurlconnection_get)
    Button httpurlconnectionGet;
    @BindView(R.id.btn_httpurlconnection_post)
    Button httpurlconnectionPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_lib);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent() {
        retrofitGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitSample sample = new RetrofitSample(NetworkActivity.this);
                sample.doRequest();
            }
        });
    }

}
