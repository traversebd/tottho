package com.teamtraverse.tottho.activities.base.auth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.teamtraverse.tottho.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //region init ui and then perform all UI interactions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region init ui and then perform all UI interactions
    private void initUI() {
    }
    //endregion

    private void bindUIWithComponents() {
    }
    //endregion
}