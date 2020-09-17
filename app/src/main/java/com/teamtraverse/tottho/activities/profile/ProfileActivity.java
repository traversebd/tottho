package com.teamtraverse.tottho.activities.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.MainActivity;
import com.teamtraverse.tottho.activities.government.GovernmentActivity;
import com.teamtraverse.tottho.adapters.RecyclerAdapterRecentPost;
import com.teamtraverse.tottho.models.link.Post;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private RecyclerView recentPostRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //region initUI and then perform all UI actions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region initUI
    private void initUI(){
        recentPostRecycler = findViewById(R.id.mRecyclerView);
    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents(){
        //region set recent link recycler adapter
        setRecentPostRecyclerAdapter();
        //endregion

        //region back button click listener
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });
        //endregion
    }
    //endregion

    //region set recent link recycler adapter
    private void setRecentPostRecyclerAdapter(){
        RecyclerAdapterRecentPost recyclerAdapter = new RecyclerAdapterRecentPost(getRecentlyViewedLink());
        recentPostRecycler.setLayoutManager(new LinearLayoutManager(this));
        recentPostRecycler.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }
    //endregion

    //region get recycler items for recently posted links
    private ArrayList<Post> getRecentlyViewedLink(){
        ArrayList<Post> postArrayList = new ArrayList<>();
        postArrayList.add(new Post(1,"Daffodil International University","daffodilvarsity@diu.edu.bd","+880-1739-574727","http://studentportal.diu.edu.bd/", "Sobahanbagh,Dhanmondi-27,Dhaka",1,"10-Jan-2020"));
        postArrayList.add(new Post(1,"BUET","buet@edu.bd","+880-1739-574727","http://buet.diu.edu.bd/", "Shahbagh,Palashi,Dhaka",2,"30-Jun-2019"));
        postArrayList.add(new Post(1,"DMC","dhakamedicalcollege@edu.bd","+880-4512-574727","http://studentportal.diu.edu.bd/", "Sobahanbagh,Dhanmondi-27,Dhaka",2,"20-Aug-2018"));
        return postArrayList;
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(ProfileActivity.this,MainActivity.class));
    }
    //endregion
}