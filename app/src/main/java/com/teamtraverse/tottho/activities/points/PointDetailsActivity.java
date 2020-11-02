package com.teamtraverse.tottho.activities.points;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.MainActivity;

import static com.teamtraverse.tottho.tools.UtilsManager.exitApp;

public class PointDetailsActivity extends AppCompatActivity {
    private SeekBar pointBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_details);

        //region init ui and then perform all UI interactions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region init ui and then perform all UI interactions
    private void initUI() {
        pointBar = findViewById(R.id.pointBar);
    }
    //endregion

    //region then perform all UI interactions
    private void bindUIWithComponents() {
        //region set seekBar not draggable
        pointBar.setEnabled(false);
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

    //region activity components
    @Override
    public void onBackPressed() {
        exitApp(PointDetailsActivity.this);
    }
    //endregion
}