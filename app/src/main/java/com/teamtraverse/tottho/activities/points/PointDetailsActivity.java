package com.teamtraverse.tottho.activities.points;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.MainActivity;

public class PointDetailsActivity extends AppCompatActivity {
    private SeekBar pointBar;
    private int earnedPointsInt = 0, goalPointsInt = 0;
    private TextView earnedPoints, goalPoints, pointStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_details);

        //region get intent data
        getIntentData();
        //endregion

        //region init ui and then perform all UI interactions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region get intent data
    private void getIntentData(){
        if (getIntent().getIntExtra("earnedPoints",0) != 0){
            earnedPointsInt = getIntent().getIntExtra("earnedPoints",0);
        }

        if (getIntent().getIntExtra("goalPoints",0) != 0){
            goalPointsInt = getIntent().getIntExtra("goalPoints",0);
        }
    }
    //endregion

    //region init ui and then perform all UI interactions
    private void initUI() {
        earnedPoints = findViewById(R.id.earnedPoints);
        goalPoints = findViewById(R.id.goalPoints);
        pointStatus = findViewById(R.id.pointStatus);
        pointBar = findViewById(R.id.pointBar);
    }
    //endregion

    //region then perform all UI interactions
    private void bindUIWithComponents() {
        //region set seekBar not draggable
        pointBar.setEnabled(false);
        //endregion

        //region set point details
        earnedPoints.setText(""+earnedPointsInt);
        goalPoints.setText(""+goalPointsInt);
        setPointStatus();
        //endregion

        //region back arrow click listener
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PointDetailsActivity.this, MainActivity.class));
            }
        });
        //endregion
    }
    //endregion

    //region set point status, Example as silver, bronze etc
    private void setPointStatus(){
        if (earnedPointsInt <= 500 && earnedPointsInt > 0){
            pointStatus.setText(R.string.bronze);
        }
        else if (earnedPointsInt <= 1000 && earnedPointsInt > 500){
            pointStatus.setText(R.string.silver_status);
        }
        else if (earnedPointsInt <= 1500 && earnedPointsInt > 1000){
            pointStatus.setText(R.string.gold);
        }
        else if (earnedPointsInt <= 2000 && earnedPointsInt > 1500){
            pointStatus.setText(R.string.platinum);
        }
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(PointDetailsActivity.this, MainActivity.class));
    }
    //endregion
}