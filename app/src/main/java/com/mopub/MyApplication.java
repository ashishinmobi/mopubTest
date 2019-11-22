package com.mopub;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.mopub.service.ScreenOnOffService;

public class MyApplication extends Application {
    private final String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Starting ScreenOnOffService from Application class..");
        Intent i = new Intent(this, ScreenOnOffService.class);
        startService(i);
    }
}
