package com.tea.android.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by brc on 16/11/14.
 */

public class ReferrerReceiver extends BroadcastReceiver {
    public static final String TAG = "ReferrerReceiver";
    public static final String ACTION_INSTALL_REFERRER = "com.android.vending.INSTALL_REFERRER";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }

        String action = intent.getAction();
        Log.i(TAG, action);

        if (ACTION_INSTALL_REFERRER.equals(action)) {
            String rawReferrer = intent.getStringExtra("referrer");
            Log.i(TAG, "onReceive raw referrer: " + rawReferrer);
            String referrer = null;
            if (null != rawReferrer) {
                referrer = Uri.decode(rawReferrer);
                Log.i(TAG, "onReceive decoded referrer: " + referrer);

            }
        }
    }
}

