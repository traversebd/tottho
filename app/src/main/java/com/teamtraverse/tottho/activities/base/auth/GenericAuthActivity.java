package com.teamtraverse.tottho.activities.base.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.MainActivity;
import com.teamtraverse.tottho.tools.PrefManager;
import com.teamtraverse.tottho.tools.UtilsManager;

import static com.teamtraverse.tottho.tools.Constants.mIsLoggedIn;
import static com.teamtraverse.tottho.tools.Constants.mShouldRemember;
import static com.teamtraverse.tottho.tools.Constants.mUserEmail;
import static com.teamtraverse.tottho.tools.Constants.mUserId;
import static com.teamtraverse.tottho.tools.Constants.mUsername;
import static com.teamtraverse.tottho.tools.UtilsManager.exitApp;

public class GenericAuthActivity extends AppCompatActivity {
    private static final String TAG = "GenericAuthActivity";
    private GoogleApiClient googleApiClient;
    private PrefManager prefManager;

    private static final int RC_SIGN_IN = 1;

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
        prefManager = new PrefManager(this);
    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents() {
        //region google client for sign in
        GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Log.i(TAG, "onConnectionFailed: "+connectionResult.getErrorMessage());
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
        //endregion

        //region UI interactions and listeners
        findViewById(R.id.signUpWithUs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenericAuthActivity.this,RegistrationActivity.class));
            }
        });

        findViewById(R.id.onTapGoogle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenericAuthActivity.this, LoginActivity.class));
            }
        });
        //endregion
    }
    //endregion

    //region activity components

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    @Override
    public void onBackPressed() {
        exitApp(GenericAuthActivity.this);
    }

    //endregion

    //region perform certain action after successful login
    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            setPref(result);
            Toast.makeText(this, "Sign in successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(GenericAuthActivity.this, MainActivity.class));
        }else{
            Toast.makeText(getApplicationContext(),"Sign in cancel",Toast.LENGTH_LONG).show();
        }
    }

    private void setPref(GoogleSignInResult result) {
        prefManager.set(mUsername, result.getSignInAccount().getDisplayName());
        prefManager.set(mUserId, result.getSignInAccount().getId());
        prefManager.set(mUserEmail, result.getSignInAccount().getEmail());
        prefManager.set(mIsLoggedIn, true);
        prefManager.set(mShouldRemember, true);
    }
    //endregion
}