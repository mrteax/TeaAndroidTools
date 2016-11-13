package com.tea.android.utils.netWorkSample;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * Created by brc on 2016/10/27.
 */

public class VolleySample {
    Context mContext;
    public VolleySample(Context context) {
        mContext = context;
    }

    private void volleyGet(String url){
        RequestQueue queue= Volley.newRequestQueue(mContext);
        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // do response
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // process error
            }
        });
        queue.add(request);
    }


    private void volleyPost(String url, final Map<String, String> params) {
        RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            //重写getParams方法设置参数
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        queue.add(request);
    }
}
