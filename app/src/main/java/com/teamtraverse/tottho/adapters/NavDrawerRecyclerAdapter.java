package com.teamtraverse.tottho.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.models.drawer.NavDrawer;
import java.util.ArrayList;

public class NavDrawerRecyclerAdapter extends RecyclerView.Adapter<NavDrawerRecyclerAdapter.ViewHolder> {
    private ArrayList<NavDrawer> drawerList;
    private onItemClickListener onItemClickListener;

    public NavDrawerRecyclerAdapter(ArrayList<NavDrawer> drawerList) {
        this.drawerList = drawerList;
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onItemClick(NavDrawer navDrawer);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_nav_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NavDrawer navDrawer = drawerList.get(position);
        holder.Title.setText(navDrawer.getTitle());
        holder.Icon.setImageResource(navDrawer.getIcon());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(navDrawer);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drawerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView Title;
        private ImageView Icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.item_card_view);
            Title = itemView.findViewById(R.id.Title);
            Icon = itemView.findViewById(R.id.Icon);
        }
    }
}
