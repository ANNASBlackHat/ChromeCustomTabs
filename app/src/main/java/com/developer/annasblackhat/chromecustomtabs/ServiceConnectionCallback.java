package com.developer.annasblackhat.chromecustomtabs;

import android.support.customtabs.CustomTabsClient;

/**
 * Created by ANNASBlackHat on 5/25/2016.
 */

public interface ServiceConnectionCallback {
    /**
     * Called when the service is connected.
     * @param client a CustomTabsClient
     */
    void onServiceConnected(CustomTabsClient client);

    /**
     * Called when the service is disconnected.
     */
    void onServiceDisconnected();
}
