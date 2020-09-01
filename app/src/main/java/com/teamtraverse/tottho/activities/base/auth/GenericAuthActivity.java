package com.teamtraverse.tottho.activities.base.auth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.teamtraverse.tottho.R;

public class GenericAuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_auth);
    }
}