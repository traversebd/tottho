package com.teamtraverse.tottho.activities.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.MainActivity;
import com.teamtraverse.tottho.adapters.RecyclerAdapterRecentPost;
import com.teamtraverse.tottho.models.post.Post;
import com.teamtraverse.tottho.tools.PrefManager;

import java.util.ArrayList;

import static com.teamtraverse.tottho.tools.Constants.mUserEmail;
import static com.teamtraverse.tottho.tools.Constants.mUsername;

public class ProfileActivity extends AppCompatActivity {
    private RecyclerView recentPostRecycler;
    private PrefManager prefManager;
    private TextView name, email;

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
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        prefManager = new PrefManager(this);
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
                onBackPressed();
            }
        });
        //endregion

        //region set user basic profile details
        setProfileDetails();
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

    //region set user basic profile details
    private void setProfileDetails(){
        if (prefManager.getString(mUsername) != null){
            if (!TextUtils.isEmpty(prefManager.getString(mUsername))){
                name.setText(prefManager.getString(mUsername));
            }
            else{
                name.setText("No Name Found");
            }
        }
        else{
            name.setText("No Name Found");
        }
        if (prefManager.getString(mUserEmail) != null){
            if (!TextUtils.isEmpty(prefManager.getString(mUserEmail))){
                email.setText(prefManager.getString(mUserEmail));
            }
            else{
                email.setText("No email found");
            }
        }
        else{
            email.setText("No email found");
        }
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(ProfileActivity.this,MainActivity.class));
    }
    //endregion
}