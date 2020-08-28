package com.teamtraverse.tottho.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.teamtraverse.tottho.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region init ui and then perform all UI interactions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region init ui and then perform all UI interactions
    private void initUI() {
    }

    private void bindUIWithComponents() {
    }
    //endregion

}