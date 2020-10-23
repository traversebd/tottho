package com.teamtraverse.tottho.activities.education;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.MainActivity;
import com.teamtraverse.tottho.adapters.RecyclerAdapterPost;
import com.teamtraverse.tottho.models.post.Post;
import java.util.ArrayList;

public class EducationActivity extends AppCompatActivity {
    private RecyclerView educationRecycler;
    private TextView totalItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        //region initUI and then perform all UI actions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region initUI
    private void initUI(){
        educationRecycler = findViewById(R.id.mRecyclerView);
        totalItems = findViewById(R.id.TotalItems);
    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents(){
        //region set total data count
        totalItems.setText(String.valueOf(getAllEducationPosts().size()));
        //endregion

        //region back button click listener
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EducationActivity.this, MainActivity.class));
            }
        });
        //endregion

        //region set recent link recycler adapter
        setEducationRecyclerAdapter();
        //endregion
    }
    //endregion

    //region set all education link recycler adapter
    private void setEducationRecyclerAdapter(){
        RecyclerAdapterPost recyclerAdapter = new RecyclerAdapterPost(getAllEducationPosts());
        educationRecycler.setLayoutManager(new LinearLayoutManager(this));
        educationRecycler.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }
    //endregion

    //region get recycler items for recently posted links
    private ArrayList<Post> getAllEducationPosts(){
        ArrayList<Post> postArrayList = new ArrayList<>();
        postArrayList.add(new Post(1,"Daffodil International University","daffodilvarsity@diu.edu.bd","+880-1739-574727","http://studentportal.diu.edu.bd/", "Sobahanbagh,Dhanmondi-27,Dhaka",1,"10-Jan-2020"));
        postArrayList.add(new Post(2,"BUET","buet@edu.bd","+880-1739-574727","http://buet.diu.edu.bd/", "Shahbagh,Palashi,Dhaka",2,"30-Jun-2019"));
        postArrayList.add(new Post(3,"DMC","dhakamedicalcollege@edu.bd","+880-4512-574727","http://studentportal.diu.edu.bd/", "Sobahanbagh,Dhanmondi-27,Dhaka",2,"20-Aug-2018"));
        return postArrayList;
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(EducationActivity.this,MainActivity.class));
    }
    //endregion
}