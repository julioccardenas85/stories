package com.example.storiesapp;

import android.app.Application;
import com.kumulos.android.Kumulos;
import com.kumulos.android.KumulosConfig;

public class BeeTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        KumulosConfig config = new KumulosConfig.Builder("bsfzcn9xsbwdqy190p3m611mxyqy49f5", "6bqgkgsc").build();
        Kumulos.initialize(this, config);
    }
}