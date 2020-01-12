package com.example.assignment_appstreet.retrofit;

import com.example.assignment_appstreet.model.TopGithubModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface GithubService {

    @GET("/developers?language=java&since=weekly")
    Single<List<TopGithubModel>> getGitHubDetail();
}
