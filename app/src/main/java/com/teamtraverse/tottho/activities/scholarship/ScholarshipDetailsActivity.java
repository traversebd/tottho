package com.teamtraverse.tottho.activities.scholarship;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.models.scholarship.Scholarship;
import java.util.Random;

public class ScholarshipDetailsActivity extends AppCompatActivity {
    private Scholarship scholarship;
    private TextView title, postDate, eligibility, applyProcedure, officialAddress, officialMail, officialWebsite;
    private LinearLayout mainContainer;
    private ImageView thumbnail;
    private int[] thumbnailResIds = new int[]{R.drawable.scholarship_1,R.drawable.scholarship_2,R.drawable.scholarship_3,R.drawable.scholarship_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarship_details);

        //region initUI and then perform all UI actions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region initUI
    private void initUI(){
        title = findViewById(R.id.Title);
        postDate = findViewById(R.id.PostDate);
        mainContainer = findViewById(R.id.mainContainer);
        eligibility = findViewById(R.id.Eligibility);
        applyProcedure = findViewById(R.id.ApplyProcedure);
        officialAddress = findViewById(R.id.OfficialContactAddress);
        officialMail = findViewById(R.id.OfficialContactEmail);
        officialWebsite = findViewById(R.id.OfficialContactWebsite);
        thumbnail = findViewById(R.id.thumbnail);
    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents(){
        //region back arrow click listener
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //endregion

        //region load intent data
        getIntentData();
        //endregion

        //region set data
        if (scholarship != null){
            title.setText(scholarship.getTitle());
            postDate.setText("Posted On : "+scholarship.getPostDate());
            eligibility.setText(scholarship.getEligibility());
            applyProcedure.setText(scholarship.getApplyProcedure());
            officialAddress.setText(scholarship.getOfficialContactAddress());
            officialMail.setText(scholarship.getOfficialContactEmail());
            officialWebsite.setText(scholarship.getOfficialContactWebsite());
            thumbnail.setImageResource(thumbnailResIds[new Random().nextInt(4)]);
        }
        else{

        }
        //endregion
    }
    //endregion

    //region load intent data
    private void getIntentData(){
        if (getIntent().getExtras().getParcelable("scholarship") != null){
            scholarship = (Scholarship) getIntent().getExtras().getParcelable("scholarship");
            Log.v("Shakil : ", "ScholarshipDetailsActivity : getIntentData: "+scholarship.getTitle());
        }
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(ScholarshipDetailsActivity.this,ScholarshipListActivity.class));
    }
    //endregion
}