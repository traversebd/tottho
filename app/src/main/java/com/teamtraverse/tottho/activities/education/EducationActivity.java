package com.teamtraverse.tottho.activities.education;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.MainActivity;

public class EducationActivity extends AppCompatActivity {

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

    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents(){
        //region back button click listener
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EducationActivity.this, MainActivity.class));
            }
        });
        //endregion
    }
    //endregion
}