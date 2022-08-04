package com.example.rxjavaapplication;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface retrofitInterface {

    @GET("posts")
    public Observable<List<Post>> getPost();
}
