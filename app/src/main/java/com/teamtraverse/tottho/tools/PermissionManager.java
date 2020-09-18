package com.teamtraverse.tottho.tools;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import static com.teamtraverse.tottho.tools.Constants.REQUEST_CALL_CODE;

public class PermissionManager {
    private Activity activity;

    public PermissionManager(Activity activity) {
        this.activity = activity;
    }

    public PermissionManager() {
    }

    public void askCallPermission(Activity activity){
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL_CODE);
        }
    }
}
