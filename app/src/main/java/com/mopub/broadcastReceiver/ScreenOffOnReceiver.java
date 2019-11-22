package com.mopub.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenOffOnReceiver extends BroadcastReceiver {

    private final String SCREEN_OFF_INTENT = "android.intent.action.SCREEN_OFF";
    private final String SCREEN_ON_INTENT = "android.intent.action.SCREEN_ON";
    public static final String SCREEN_OFF = "screen off";
    public static final String SCREEN_ON = "screen on";


    @Override
    public void onReceive(Context context, Intent intent) {
        if (SCREEN_OFF_INTENT.equalsIgnoreCase(intent.getAction())) {
            context.sendBroadcast(new Intent(SCREEN_OFF));
        } else if (SCREEN_ON_INTENT.equalsIgnoreCase(intent.getAction())) {
            context.sendBroadcast(new Intent(SCREEN_ON));
        } else {
            context.sendBroadcast(new Intent("FROM ScreenOffOnReceiver"));
        }
    }
}