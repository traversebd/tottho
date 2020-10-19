package com.teamtraverse.tottho.activities.scholarship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.MainActivity;
import com.teamtraverse.tottho.adapters.RecyclerAdapterScholarship;
import com.teamtraverse.tottho.models.scholarship.Scholarship;
import com.teamtraverse.tottho.tools.filter.ScholarshipSearchPanel;

import java.util.ArrayList;

public class ScholarshipListActivity extends AppCompatActivity {
    private RecyclerView scholarshipRecycler;
    private TextView totalItems;
    private ImageView filterIcon, refreshIcon;
    private ScholarshipSearchPanel scholarshipSearchPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarship_list);

        //region initUI and then perform all UI actions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region initUI
    private void initUI(){
        scholarshipRecycler = findViewById(R.id.mRecyclerView);
        totalItems = findViewById(R.id.TotalItems);
        filterIcon = findViewById(R.id.FilterIcon);
        refreshIcon = findViewById(R.id.RefreshIcon);
        scholarshipSearchPanel = new ScholarshipSearchPanel(this);
    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents(){
        //region set total data count
        totalItems.setText(String.valueOf(getAllScholarshipPosts().size()));
        //endregion

        //region back button click listener
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScholarshipListActivity.this, MainActivity.class));
            }
        });
        //endregion

        //region set recent link recycler adapter
        setGovernmentRecyclerAdapter();
        //endregion

        //region search panel listener
        scholarshipSearchPanel.setPanelListener(new ScholarshipSearchPanel.searchPanelListener() {
            @Override
            public void onSearchClick(String searchText) {

            }

            @Override
            public void onRefreshClick() {

            }
        });
        scholarshipSearchPanel.initSearchPanel(filterIcon, refreshIcon);
        //endregion
    }
    //endregion

    //region set all education link recycler adapter
    private void setGovernmentRecyclerAdapter(){
        RecyclerAdapterScholarship recyclerAdapter = new RecyclerAdapterScholarship(getAllScholarshipPosts());
        //region recycler item click
        recyclerAdapter.setOnItemClick(new RecyclerAdapterScholarship.onItemClick() {
            @Override
            public void itemClick(Scholarship scholarship) {
                startActivity(new Intent(ScholarshipListActivity.this,ScholarshipDetailsActivity.class).putExtra("scholarship",scholarship));
            }
        });
        //endregion
        scholarshipRecycler.setLayoutManager(new LinearLayoutManager(this));
        scholarshipRecycler.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }
    //endregion

    //region get recycler items for recently posted links
    private ArrayList<Scholarship> getAllScholarshipPosts(){
        ArrayList<Scholarship> scholarshipArrayList = new ArrayList<>();
        scholarshipArrayList.add(new Scholarship(1,"University of Toronto Scholarship",
                "Based on University",getString(R.string.post_description),getString(R.string.eligibility_demo),
                "21-Nov-2020",getString(R.string.apply_procedure),"Benito Juarez Marg, South Campus",
                "vc@du.ac.in","http://du.ac.in/du/index.php?page=contact-us","22-Sep-2020","Asia",2));
        scholarshipArrayList.add(new Scholarship(2,"Top scholarships for Engineering student",
                "Based on Field",getString(R.string.post_description),getString(R.string.eligibility_demo),
                "21-Nov-2020",getString(R.string.apply_procedure),"Benito Juarez Marg, South Campus",
                "vc@du.ac.in","http://du.ac.in/du/index.php?page=contact-us","22-Sep-2020","Europe",5));
        scholarshipArrayList.add(new Scholarship(3,"Lester B.Pearson Scholarship",
                "Based on Designation",getString(R.string.post_description),getString(R.string.eligibility_demo),
                "21-Nov-2020",getString(R.string.apply_procedure),"Benito Juarez Marg, South Campus",
                "vc@du.ac.in","http://du.ac.in/du/index.php?page=contact-us","22-Sep-2020","Middle East",6));
        return scholarshipArrayList;
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(ScholarshipListActivity.this,MainActivity.class));
    }
    //endregion

}