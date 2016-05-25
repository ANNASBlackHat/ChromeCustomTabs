package com.developer.annasblackhat.chromecustomtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by ANNASBlackHat on 5/25/2016.
 */

public class KeepAliveService extends Service {
    private static final Binder sBinder = new Binder();

    @Override
    public IBinder onBind(Intent intent) {
        return sBinder;
    }
}