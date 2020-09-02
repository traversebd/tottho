package com.teamtraverse.tottho.activities.base.auth;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.teamtraverse.tottho.R;

public class GenericAuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_auth);

        //region init UI and perform UI interactions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region init x,ml components
    private void initUI() {

    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents() {
        findViewById(R.id.signUpWithUs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenericAuthActivity.this,RegistrationActivity.class));
            }
        });

        findViewById(R.id.onTapGoogle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenericAuthActivity.this, LoginActivity.class));
            }
        });
    }
    //endregion
}