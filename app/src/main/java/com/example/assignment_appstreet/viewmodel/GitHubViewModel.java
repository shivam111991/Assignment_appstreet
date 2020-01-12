package com.example.assignment_appstreet.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.assignment_appstreet.model.TopGithubModel;
import com.example.assignment_appstreet.repository.GitHubRepository;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class GitHubViewModel extends ViewModel {

    GitHubRepository gitHubRepository;
    CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<List<TopGithubModel>> modelMutableLiveData = new MutableLiveData<>();

    @Inject
    public GitHubViewModel(GitHubRepository gitHubRepository){
        this.gitHubRepository=gitHubRepository;
    }

    public MutableLiveData<List<TopGithubModel>> getModelMutableLiveData() {
        return modelMutableLiveData;
    }

    public void loadData(){
        disposable.add(gitHubRepository.getGitHubDetail()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<TopGithubModel>>() {
                    @Override
                    public void onSuccess(List<TopGithubModel> topGithubModel) {
                        getModelMutableLiveData().setValue(topGithubModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getCause());

                    }
                })
        );

    }
}
