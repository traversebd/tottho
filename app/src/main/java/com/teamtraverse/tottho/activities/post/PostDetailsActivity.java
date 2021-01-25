package com.teamtraverse.tottho.activities.post;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.MainActivity;
import com.teamtraverse.tottho.databinding.ActivityPostDetailsBinding;
import com.teamtraverse.tottho.models.post.Post;

public class PostDetailsActivity extends AppCompatActivity {
    private ActivityPostDetailsBinding activityPostDetailsBinding;
    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPostDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_post_details);

        //region get intent data
        getIntentData();
        //endregion

        //region initUI and then perform all UI actions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region get intent data
    private void getIntentData(){
        if (getIntent().getExtras().getParcelable("post") != null){
            post = getIntent().getExtras().getParcelable("post");
        }
    }
    //endregion

    //region initUI
    private void initUI(){
    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents(){
        //region back button click listener
        activityPostDetailsBinding.BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //endregion

        //region set UI details
        if (post != null){
            activityPostDetailsBinding.setPost(post);
        }
        //endregion
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(PostDetailsActivity.this,MainActivity.class));
    }
    //endregion
}