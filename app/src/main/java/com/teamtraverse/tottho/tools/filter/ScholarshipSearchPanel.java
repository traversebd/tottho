package com.teamtraverse.tottho.tools.filter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.tools.UX;

public class ScholarshipSearchPanel {
    private Context context;
    private UX ux;
    private Spinner scholarshipTypeSpinner, regionSpinner;
    private Button searchButton;

    public ScholarshipSearchPanel(Context context) {
        this.context = context;
        ux = new UX(context);
    }

    public interface searchPanelListener {
        void onSearchClick(String searchText);
        void onRefreshClick();
    }

    public searchPanelListener panelListener = null;

    public void setPanelListener(searchPanelListener listener) {
        this.panelListener = listener;
    }

    public void initSearchPanel(ImageView filterIcon, ImageView refreshIcon) {
        filterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                inflateFilter();
            }
        });
    }

    private void inflateFilter(){
        //region open and close bottom sheet and other operations
        View mView = View.inflate(context, R.layout.dialog_scholarship_search, null);
        final Dialog mBottomSheetDialog = new Dialog(context, R.style.MaterialDialogSheet);

        //region init and load UI components
        scholarshipTypeSpinner = mView.findViewById(R.id.ScholarshipType);
        regionSpinner = mView.findViewById(R.id.Region);
        searchButton = mView.findViewById(R.id.searchButton);
        ux.setSpinnerAdapter(new String[]{"Select Scholarship Type","Based on University","Based on Field","Based on Designation"},scholarshipTypeSpinner);
        ux.setSpinnerAdapter(new String[]{"Select Country or Region","Asia","Europe","Middle East"},regionSpinner);
        //endregion

        mBottomSheetDialog.setContentView(mView);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomSheetDialog.show();

        //region close bottom sheet
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                dialog.dismiss();
            }
        });
        //endregion

        mBottomSheetDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        //endregion

        //region search button click listener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBottomSheetDialog.isShowing()){
                    mBottomSheetDialog.dismiss();
                }
            }
        });
        //endregion
    }

    private void clear() {

    }
}
