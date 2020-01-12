package com.example.assignment_appstreet.repository;

import com.example.assignment_appstreet.model.TopGithubModel;
import com.example.assignment_appstreet.retrofit.GithubService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GitHubRepository {


    private GithubService githubService;

    @Inject
    GitHubRepository(GithubService githubService){
        this.githubService=githubService;

    }


    public Single<List<TopGithubModel>> getGitHubDetail(){
        return githubService.getGitHubDetail();
    }
}
