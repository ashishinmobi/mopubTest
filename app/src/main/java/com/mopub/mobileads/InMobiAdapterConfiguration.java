package com.mopub.mobileads;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.inmobi.sdk.InMobiSdk;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.mobileads.MoPubErrorCode;

import java.util.Map;

/**
 * For more info please visit:
 * https://developers.mopub.com/publishers/android/build-adapters/
 */

public class InMobiAdapterConfiguration extends BaseAdapterConfiguration {

    /**
     * Override the getAdapterVersion() method and implement code that returns the version number
     * of the adapter or custom event. All of MoPub’s adapters and custom events use a 4-digit
     * versioning scheme, of which the leftmost 3 digits correspond to the network SDK version,
     * and the last digit denotes the minor version number referring to an adapter release.
     */
    @NonNull
    @Override
    public String getAdapterVersion() {
        return "1.0.0";
    }

    /**
     * Override the getBiddingToken() method and implement code that returns the bidding token String from your ad network.
     * If the ad network does not support Advanced Bidding, return null.
     */

    @Nullable
    @Override
    public String getBiddingToken(@NonNull Context context) {
        return null;
    }

    /**
     * Override the getMoPubNetworkName() method and implement code that returns a lowercase String
     * that represents your ad network name. Use underscores if the String needs to contain spaces.
     */

    @NonNull
    @Override
    public String getMoPubNetworkName() {
        return "inmobi";
    }

    /**
     * Override the getNetworkSdkVersion() method and implement code that returns the version
     * number of your ad network SDK.
     */

    @NonNull
    @Override
    public String getNetworkSdkVersion() {
        return InMobiSdk.getVersion();
    }

    /**
     * Override the initializeNetwork
     * (@NonNull Context context, @Nullable Map<String, String> configuration, @NonNull OnNetworkInitializationFinishedListener listener)
     * method and implement code that initializes your network SDK. This logic executes alongside
     * the initialization of the MoPub SDK. Ensure that your custom event always
     * calls onNetworkInitializationFinished() afterwards.
     *
     * If initialization succeeds, pass MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS as the parameter to the callback.
     * If initialization fails, pass MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR.
     */

    @Override
    public void initializeNetwork(@NonNull Context context, @Nullable Map<String, String> configuration, @NonNull OnNetworkInitializationFinishedListener onNetworkInitializationFinishedListener) {
        onNetworkInitializationFinishedListener.onNetworkInitializationFinished(InMobiAdapterConfiguration.class, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
    }
}
