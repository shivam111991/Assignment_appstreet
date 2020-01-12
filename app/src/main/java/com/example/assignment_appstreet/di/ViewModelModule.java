package com.example.assignment_appstreet.di;




import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.example.assignment_appstreet.viewmodel.GitHubViewModel;
import com.example.assignment_appstreet.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
@Module
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(GitHubViewModel.class)
    abstract ViewModel bindTopGithubModel(GitHubViewModel topGithubModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory projectViewModelFactory);

}
