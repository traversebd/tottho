package com.teamtraverse.tottho.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.models.scholarship.Scholarship;
import java.util.ArrayList;

public class RecyclerAdapterScholarship extends RecyclerView.Adapter<RecyclerAdapterScholarship.ViewHolder> {
    private ArrayList<Scholarship> listOfScholarships;
    private onItemClick onItemClick;

    public RecyclerAdapterScholarship(ArrayList<Scholarship> listOfScholarships) {
        this.listOfScholarships = listOfScholarships;
    }

    public interface onItemClick{
        void itemClick(Scholarship scholarship);
    }

    public void setOnItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_scholarship_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Scholarship scholarship = listOfScholarships.get(position);
        holder.Title.setText(scholarship.getTitle());
        holder.ScholarshipType.setText(scholarship.getScholarshipType());
        holder.ScholarshipDescription.setText(scholarship.getScholarshipDescription());
        holder.PostDate.setText(scholarship.getPostDate());
        holder.TimeToRead.setText(String.valueOf(scholarship.getTimeToRead())+" min read");
        holder.item_card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.itemClick(scholarship);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfScholarships.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Title,ScholarshipType,PostDate,ScholarshipDescription,TimeToRead;
        CardView item_card_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.Title);
            ScholarshipType = itemView.findViewById(R.id.ScholarshipType);
            PostDate = itemView.findViewById(R.id.PostDate);
            ScholarshipDescription = itemView.findViewById(R.id.ScholarshipDescription);
            TimeToRead = itemView.findViewById(R.id.TimeToRead);
            item_card_view = itemView.findViewById(R.id.item_card_view);
        }
    }
}
