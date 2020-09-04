package com.teamtraverse.tottho.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.models.link.Link;
import java.util.ArrayList;

public class RecyclerAdapterRecentlyViewedLink extends RecyclerView.Adapter<RecyclerAdapterRecentlyViewedLink.ViewHolder> {
    private ArrayList<Link> listOfLinks;

    public RecyclerAdapterRecentlyViewedLink(ArrayList<Link> listOfLinks) {
        this.listOfLinks = listOfLinks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_post,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Link link = listOfLinks.get(position);
        holder.Name.setText(link.getName());
        holder.Email.setText(link.getEmail());
        holder.MobileNumber.setText(link.getMobileNumber());
        holder.WebUrl.setText(link.getWebUrl());
        holder.Address.setText(link.getAddress());
    }

    @Override
    public int getItemCount() {
        return listOfLinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Email,MobileNumber,WebUrl,Address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Email = itemView.findViewById(R.id.Email);
            MobileNumber = itemView.findViewById(R.id.MobileNo);
            WebUrl = itemView.findViewById(R.id.WebsiteLink);
            Address = itemView.findViewById(R.id.Address);
        }
    }
}
