package com.teamtraverse.tottho.activities.base.auth;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.suke.widget.SwitchButton;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.TourPageActivity;
import com.teamtraverse.tottho.tools.PrefManager;
import static com.teamtraverse.tottho.tools.Constants.mIsLoggedIn;
import static com.teamtraverse.tottho.tools.Constants.mIsRemembered;

public class LoginActivity extends AppCompatActivity {
    private PrefManager prefManager;
    private SwitchButton switchButton;
    private TextView rememberMeText;

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
        prefManager = new PrefManager(this);
        switchButton = findViewById(R.id.switch_button);
        rememberMeText = findViewById(R.id.rememberMeText);
    }
    //endregion

    private void bindUIWithComponents() {
        //region login button click listener
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefManager.set(mIsLoggedIn, true);
                startActivity(new Intent(LoginActivity.this, TourPageActivity.class));
            }
        });
        //endregion

        //region remember me switch
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked){
                    prefManager.set(mIsRemembered, true);
                    rememberMeText.setTextColor(getColor(R.color.md_green_600));
                }
                else{
                    prefManager.set(mIsRemembered, false);
                    rememberMeText.setTextColor(getColor(R.color.md_grey_800));
                }
            }
        });
        //endregion
    }
    //endregion
}