package com.teamtraverse.tottho.activities.base.auth;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.TourPageActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, TourPageActivity.class));
            }
        });
    }
    //endregion
}