package com.example.rxjavaapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerView extends RecyclerView.Adapter<recyclerView.viewHolder> {

    List<Post>Posts;

    public recyclerView (List<Post> posts)
    {
        this.Posts = posts;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_adapter , parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Post post = Posts.get(position);
        holder.userId.setText(post.getUserId()+"");
        holder.Id.setText(post.getId()+"");
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return Posts.size();
    }



    public class viewHolder extends RecyclerView.ViewHolder {
        TextView userId , Id, title , body;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            Id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title2);
            body = itemView.findViewById(R.id.body);
        }
    }
}
