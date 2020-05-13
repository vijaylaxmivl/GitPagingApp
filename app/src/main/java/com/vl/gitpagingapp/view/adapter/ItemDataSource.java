package com.vl.gitpagingapp.view.adapter;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.vl.gitpagingapp.model.GitResponse;
import com.vl.gitpagingapp.ws.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, GitResponse> {

    public static final int PAGE_SIZE = 10;
    private static final int FIRST_PAGE = 1;



    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, GitResponse> callback) {

        RetrofitClient.getInsance()
                .getApi()
                .getAnswers(FIRST_PAGE, PAGE_SIZE)
                .enqueue(new Callback<List<GitResponse>>() {
                    @Override
                    public void onResponse(Call<List<GitResponse>> call, Response<List<GitResponse>> response) {

                        if(response.body() != null){
                            Log.d("onResponse", "onResponse: ConfigurationListener::"+call.request().url());
                            callback.onResult(response.body(), null, FIRST_PAGE + 1);

                        }

                    }

                    @Override
                    public void onFailure(Call<List<GitResponse>> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, GitResponse> callback) {

        RetrofitClient.getInsance()
                .getApi()
                .getAnswers(params.key, PAGE_SIZE)
                .enqueue(new Callback<List<GitResponse>>() {
                    @Override
                    public void onResponse(Call<List<GitResponse>> call, Response<List<GitResponse>> response) {



                        if(response.body() != null){
                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            Log.d("onResponse", "onResponse: ConfigurationListener::"+call.request().url());
                            callback.onResult(response.body(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GitResponse>> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, GitResponse> callback) {

        RetrofitClient.getInsance()
                .getApi()
                .getAnswers(params.key, PAGE_SIZE)
                .enqueue(new Callback<List<GitResponse>>() {
                    @Override
                    public void onResponse(Call<List<GitResponse>> call, Response<List<GitResponse>> response) {

                        if(response.body() != null){
                            //Integer key = response.body(). ? params.key + 1 : null;
                            Log.d("onResponse", "onResponse: ConfigurationListener::"+call.request().url());
                            callback.onResult(response.body(), params.key+1);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<GitResponse>> call, Throwable t) {

                    }
                });


    }
}
