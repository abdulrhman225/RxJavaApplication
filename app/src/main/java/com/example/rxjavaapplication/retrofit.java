package com.example.rxjavaapplication;

import android.provider.CalendarContract;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {
    public static final String BaseURL = "https://jsonplaceholder.typicode.com/";
    public retrofitInterface interfaces;
    public static  retrofit Instance ;

    private  retrofit (){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        interfaces = retrofit.create(retrofitInterface.class);
    }
    public static retrofit getInstance(){
        if (Instance == null){
            Instance = new retrofit();
            return Instance;
        }
        return Instance;
    }

    public Observable<List<Post>> getPost(){
        return interfaces.getPost();
    }


}
