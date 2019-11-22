package com.mopub.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenOffOnReceiver extends BroadcastReceiver {

    private final String TAG = ScreenOffOnReceiver.class.getSimpleName();
    private final String SCREEN_OFF_INTENT = "android.intent.action.SCREEN_OFF";
    private final String SCREEN_ON_INTENT = "android.intent.action.SCREEN_OFF";
    public static final String SCREEN_OFF = "screen off";
    public static final String SCREEN_ON = "screen on";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Got a new intent" + intent.getAction());

        if (SCREEN_OFF_INTENT.equalsIgnoreCase(intent.getAction())) {
            context.sendBroadcast(new Intent(SCREEN_OFF));
        } else if (SCREEN_ON_INTENT.equalsIgnoreCase(intent.getAction())) {
            context.sendBroadcast(new Intent(SCREEN_ON));
        } else {
            context.sendBroadcast(new Intent("FROM ScreenOffOnReceiver"));
        }
    }
}