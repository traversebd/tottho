package com.teamtraverse.tottho.activities.base;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.auth.GenericAuthActivity;
import com.teamtraverse.tottho.tools.PrefManager;
import static com.teamtraverse.tottho.tools.Constants.mAlreadyVisited;
import static com.teamtraverse.tottho.tools.Constants.mIsLoggedIn;
import static com.teamtraverse.tottho.tools.Constants.mShouldRemember;

public class SplashActivity extends AppCompatActivity {
    private Animation topAnim, middleAnim, bottomAnim;
    private View first,second,third,fourth,fifth;
    private TextView AppName, DevelopedBy, Developer;
    private LottieAnimationView helloAnimationView;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //region init components and their interactions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region init XML components with backend
    private void initUI() {
        first = findViewById(R.id.FirstLine);
        second = findViewById(R.id.SecondLine);
        third = findViewById(R.id.ThirdLine);
        fourth = findViewById(R.id.FourthLine);
        fifth = findViewById(R.id.FifthLine);
        AppName = findViewById(R.id.AppName);
        DevelopedBy = findViewById(R.id.DevelopedBy);
        Developer = findViewById(R.id.DeveloperName);
        helloAnimationView = findViewById(R.id.helloAnimation);
        prefManager = new PrefManager(this);
    }
    //endregion

    //region perform UI interactions
    private void bindUIWithComponents() {
        setAnimation();
        loadAnimationForUI();

        //region splash screen code to call new activity after some time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (prefManager.getBoolean(mShouldRemember)){
                    if (prefManager.getBoolean(mIsLoggedIn)) {
                        if (prefManager.getBoolean(mAlreadyVisited)) {
                            intent = new Intent(SplashActivity.this, MainActivity.class);
                        } else {
                            intent = new Intent(SplashActivity.this, TourPageActivity.class);
                        }
                    }
                    else {
                        intent = new Intent(SplashActivity.this, GenericAuthActivity.class);
                    }
                }
                else{
                    intent = new Intent(SplashActivity.this, GenericAuthActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
    //endregion

    //region set animation
    private void setAnimation() {
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim_splash);
        middleAnim = AnimationUtils.loadAnimation(this,R.anim.middle_anim_splash);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim_splash);
    }
    //endregion

    //region load animation into UI components
    private void loadAnimationForUI() {
        first.setAnimation(topAnim);
        second.setAnimation(topAnim);
        third.setAnimation(topAnim);
        fourth.setAnimation(topAnim);
        fifth.setAnimation(topAnim);

        AppName.setAnimation(middleAnim);
        DevelopedBy.setAnimation(bottomAnim);
        Developer.setAnimation(bottomAnim);
        helloAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
    }
    //endregion
}