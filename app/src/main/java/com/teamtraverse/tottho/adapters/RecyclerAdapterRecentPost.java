package com.teamtraverse.tottho.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.models.link.Post;

import java.util.ArrayList;

public class RecyclerAdapterRecentPost extends RecyclerView.Adapter<RecyclerAdapterRecentPost.ViewHolder> {
    private ArrayList<Post> listOfPosts;

    public RecyclerAdapterRecentPost(ArrayList<Post> listOfPosts) {
        this.listOfPosts = listOfPosts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_recent_post,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = listOfPosts.get(position);
        holder.Name.setText(post.getName());
        holder.Email.setText(post.getEmail());
        holder.MobileNumber.setText(post.getMobileNumber());
        holder.PostDate.setText(post.getPostDate());
    }

    @Override
    public int getItemCount() {
        return listOfPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Email,MobileNumber,PostDate,Address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Email = itemView.findViewById(R.id.Email);
            MobileNumber = itemView.findViewById(R.id.MobileNo);
            PostDate = itemView.findViewById(R.id.PostDate);
        }
    }
}
