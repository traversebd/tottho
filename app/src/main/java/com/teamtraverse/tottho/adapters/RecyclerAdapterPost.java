package com.teamtraverse.tottho.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.models.post.Post;

import java.util.ArrayList;

public class RecyclerAdapterPost extends RecyclerView.Adapter<RecyclerAdapterPost.ViewHolder> {
    private ArrayList<Post> listOfPosts;

    public RecyclerAdapterPost(ArrayList<Post> listOfPosts) {
        this.listOfPosts = listOfPosts;
    }

    private onItemClickListener onItemClickListener;
    public interface onItemClickListener{
        void onItemClick(Post post);
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_post,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Post post = listOfPosts.get(position);
        holder.Name.setText(post.getName());
        holder.Email.setText(post.getEmail());
        holder.MobileNumber.setText(post.getMobileNumber());
        holder.WebUrl.setText(post.getWebUrl());
        holder.Address.setText(post.getAddress());

        holder.item_card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(post);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Email,MobileNumber,WebUrl,Address;
        CardView item_card_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Email = itemView.findViewById(R.id.Email);
            MobileNumber = itemView.findViewById(R.id.MobileNo);
            WebUrl = itemView.findViewById(R.id.WebsiteLink);
            Address = itemView.findViewById(R.id.Address);
            item_card_view = itemView.findViewById(R.id.item_card_view);
        }
    }
}
