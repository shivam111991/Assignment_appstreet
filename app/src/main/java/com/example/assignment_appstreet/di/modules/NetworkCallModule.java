package com.example.assignment_appstreet.di.modules;
import com.example.assignment_appstreet.di.ViewModelModule;
import com.example.assignment_appstreet.retrofit.GithubService;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public abstract class NetworkCallModule {

    @Provides
    @Singleton
    static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl("https://github-trending-api.now.sh")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static GithubService getTopGitHubModelInstance(Retrofit retrofit){
        return  retrofit.create(GithubService.class);
    }

}
