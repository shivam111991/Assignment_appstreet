package com.example.assignment_appstreet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.assignment_appstreet.adaper.GitHubDetailAdapter;
import com.example.assignment_appstreet.model.TopGithubModel;
import com.example.assignment_appstreet.viewmodel.GitHubViewModel;
import com.example.assignment_appstreet.viewmodel.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Inject
    ViewModelFactory viewModelFactory;
    GitHubViewModel gitHubViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ( (BaseApplication) getApplication()).getAppComponent().inject(this);
        gitHubViewModel= ViewModelProviders.of(this, viewModelFactory).get(GitHubViewModel.class);
        gitHubViewModel.loadData();
        gitHubViewModel.getModelMutableLiveData().observe(this, new Observer<List<TopGithubModel>>() {
            @Override
            public void onChanged(List<TopGithubModel> topGithubModel) {
                recyclerView.setAdapter(new GitHubDetailAdapter(topGithubModel,MainActivity.this));
                System.out.println("========data"+topGithubModel.toString());
            }
        });
    }
}
