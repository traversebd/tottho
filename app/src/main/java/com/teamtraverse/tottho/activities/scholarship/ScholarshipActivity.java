package com.teamtraverse.tottho.activities.scholarship;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.teamtraverse.tottho.R;

public class ScholarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarship);

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

    }
    //endregion
}