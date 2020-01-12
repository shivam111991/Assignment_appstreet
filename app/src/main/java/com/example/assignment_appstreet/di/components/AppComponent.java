package com.example.assignment_appstreet.di.components;


import com.example.assignment_appstreet.MainActivity;
import com.example.assignment_appstreet.di.modules.ContextModule;
import com.example.assignment_appstreet.di.modules.NetworkCallModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkCallModule.class, ContextModule.class/*,ActivityModule.class*/})
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
