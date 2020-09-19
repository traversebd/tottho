package com.teamtraverse.tottho.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.models.link.Post;
import com.teamtraverse.tottho.tools.PermissionManager;
import java.util.ArrayList;

public class RecyclerAdapterRecentlyViewedLink extends RecyclerView.Adapter<RecyclerAdapterRecentlyViewedLink.ViewHolder> {
    private ArrayList<Post> listOfPosts;
    private Context context;

    public RecyclerAdapterRecentlyViewedLink(ArrayList<Post> listOfPosts, Context context) {
        this.listOfPosts = listOfPosts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_post,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Post post = listOfPosts.get(position);
        holder.Name.setText(post.getName());
        holder.Email.setText(post.getEmail());
        holder.MobileNumber.setText(post.getMobileNumber());
        holder.WebUrl.setText(post.getWebUrl());
        holder.Address.setText(post.getAddress());

        //region set call action
        holder.callIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    String uri = "tel:"+post.getMobileNumber();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(uri));
                    context.startActivity(callIntent);
                } else {
                    Toast.makeText(context, "Please allow call permission", Toast.LENGTH_SHORT).show();
                    new PermissionManager().askCallPermission((Activity) context);
                }
            }
        });
        //endregion
    }

    @Override
    public int getItemCount() {
        return listOfPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Email,MobileNumber,WebUrl,Address;
        ImageView callIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Email = itemView.findViewById(R.id.Email);
            MobileNumber = itemView.findViewById(R.id.MobileNo);
            WebUrl = itemView.findViewById(R.id.WebsiteLink);
            Address = itemView.findViewById(R.id.Address);
            callIcon = itemView.findViewById(R.id.callIcon);
        }
    }
}
