package com.example.assignment_appstreet;

import android.app.Application;

import com.example.assignment_appstreet.di.components.AppComponent;
import com.example.assignment_appstreet.di.components.DaggerAppComponent;


public class BaseApplication extends Application {


    AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent=  DaggerAppComponent.create();



    }

    public AppComponent getAppComponent(){
            return appComponent;
    }
}
