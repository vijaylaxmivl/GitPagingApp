package com.vl.gitpagingapp.ws;

import com.vl.gitpagingapp.model.GitResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("orgs/octokit/repos?")
    Call<List<GitResponse>> getAnswers(
            @Query("page") int page,
            @Query("per_page") int size

    );
}
