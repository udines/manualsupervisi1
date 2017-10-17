package com.civileng.manualsupervisi;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by fata on 10/18/2017.
 */

public class ManualSupervisi extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
