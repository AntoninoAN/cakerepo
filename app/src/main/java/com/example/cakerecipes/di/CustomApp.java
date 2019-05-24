package com.example.cakerecipes.di;

import android.app.Application;

import com.example.cakerecipes.model.NetworkConnection;
import com.example.cakerecipes.presenter.Presenter;

public class CustomApp extends Application {
    private ApplicationComponent component;

    public ApplicationComponent getComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent
                .builder()
//                .presenter(new Presenter())
                .build();
    }
}
