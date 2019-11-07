package com.mopub.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.inmobi.fossil.R;
import com.inmobi.sdk.InMobiSdk;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.InMobiAdapterConfiguration;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;

import java.util.HashMap;

import static com.mopub.common.logging.MoPubLog.LogLevel.DEBUG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MoPubView.BannerAdListener, MoPubInterstitial.InterstitialAdListener {

    private MoPubView mMopubBannerView;
    private MoPubInterstitial mMopubInterstitialView;
    public static final String TAG = MainActivity.class.getName();
    private static final String JSAC_BANNER_UNIT_ID = "0e59d9264f394e3983875e8919c93634";
    private String moPubBannerUnitIdFromSampleCode = "b5d5342405c545e5bff88b75ae8d58e5";
    private String moPubBannerUnitId = "1eb8e147d56c489b9ca1e6c4aceb4941";
    private final String interstitialAdId = "597752c10f8e49a2bb59ab4dc6b25247";
    private final String banner_id_harshit = "0a728f5665f54cd8b85b1940160311ff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMoPubSDK();
        loadBannerAd();
        InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);
        Button btnRefreshAd = findViewById(R.id.btnRefreshAd);
        btnRefreshAd.setOnClickListener(this);
        findViewById(R.id.btnLoadInterstitial).setOnClickListener(this);
        findViewById(R.id.btnShowInterstitial).setOnClickListener(this);
    }

    private void loadBannerAd() {
        mMopubBannerView = findViewById(R.id.bannerview);
        mMopubBannerView.setAdUnitId(moPubBannerUnitId);
        mMopubBannerView.setBannerAdListener(this);
        mMopubBannerView.setAutorefreshEnabled(false);
    }


    private void setMoPubSDK() {
        SdkConfiguration sdkConfiguration = new SdkConfiguration.Builder(moPubBannerUnitId)
                .withLogLevel(DEBUG)
                .withMediatedNetworkConfiguration(InMobiAdapterConfiguration.class.getName(), new HashMap<String, String>())
                .withAdditionalNetwork(InMobiAdapterConfiguration.class.getName())
                .build();

        MoPub.initializeSdk(this, sdkConfiguration, initSdkListener());}


    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {

            @Override
            public void onInitializationFinished() {
                Log.d(TAG, "SDK initialized.");
            }
        };
    }


    public void refreshAd() {
        mMopubBannerView.loadAd();
    }

    public void getInterstitialAd() {
        mMopubInterstitialView = new MoPubInterstitial(this, interstitialAdId);
        mMopubInterstitialView.setInterstitialAdListener(this);
        mMopubInterstitialView.load();
    }

    public void showInterstitial(View view) {
        Log.d(TAG,"showing the interstitial ad");
        if (mMopubInterstitialView != null && mMopubInterstitialView.isReady()) {
            mMopubInterstitialView.show();
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnRefreshAd:
                refreshAd();
                break;
            case R.id.btnLoadInterstitial:
                getInterstitialAd();
                break;
            case R.id.btnShowInterstitial:
                showInterstitial(findViewById(R.id.linearlayout));
                break;
            default:
                showNotImplementedToast();
                break;

        }
    }

    private void showNotImplementedToast() {
        Toast.makeText(this, "This has not been implemented", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerLoaded(MoPubView banner) {
        Log.d(TAG, "Banner ad successfully loaded.");
    }

    @Override
    public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode) {
        Log.d(TAG, errorCode.toString() + " -> " + errorCode.name());

    }

    @Override
    public void onBannerClicked(MoPubView banner) {

    }

    @Override
    public void onBannerExpanded(MoPubView banner) {

    }

    @Override
    public void onBannerCollapsed(MoPubView banner) {

    }

    @Override
    public void onInterstitialLoaded(MoPubInterstitial interstitial) {
        Log.v(TAG, "Interstitial ad loaded successfully.");
        TextView interstitialTextView = findViewById(R.id.textView);
        interstitialTextView.setText("Interstitial ad loaded successfully");
    }

    @Override
    public void onInterstitialFailed(MoPubInterstitial interstitial, MoPubErrorCode errorCode) {
        Log.v(TAG, "Interstitial ad failed with ErrorCode " + errorCode.toString());
    }

    @Override
    public void onInterstitialShown(MoPubInterstitial interstitial) {
        Log.v(TAG, "Interstitial ad Shown");
    }

    @Override
    public void onInterstitialClicked(MoPubInterstitial interstitial) {
        Log.v(TAG, "Interstitial ad Clicked.");
    }

    @Override
    public void onInterstitialDismissed(MoPubInterstitial interstitial) {
        Log.v(TAG, "Interstitial ad Dismissed.");
    }
}
