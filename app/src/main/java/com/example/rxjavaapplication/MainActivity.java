package com.example.rxjavaapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView main_recyclerView;
    PostViewModel postViewModel;
    recyclerView adapter;
    List<Post> Posts ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);


        postViewModel.getPost();

        main_recyclerView = findViewById(R.id.main_recclerView);

        Posts = new ArrayList<>();




        postViewModel.mutableLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Posts = posts;
                adapter = new recyclerView(Posts);
                main_recyclerView.setAdapter(adapter);
                main_recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                main_recyclerView.setHasFixedSize(true);

            }
        });





    }
}