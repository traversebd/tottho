package com.teamtraverse.tottho.activities.base;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.base.auth.GenericAuthActivity;
import com.teamtraverse.tottho.activities.education.EducationActivity;
import com.teamtraverse.tottho.activities.events.EventsActivity;
import com.teamtraverse.tottho.activities.government.GovernmentActivity;
import com.teamtraverse.tottho.activities.profile.ProfileActivity;
import com.teamtraverse.tottho.activities.scholarship.ScholarshipListActivity;
import com.teamtraverse.tottho.adapters.NavDrawerRecyclerAdapter;
import com.teamtraverse.tottho.adapters.RecyclerAdapterRecentlyViewedLink;
import com.teamtraverse.tottho.models.drawer.NavDrawer;
import com.teamtraverse.tottho.models.link.Post;
import com.teamtraverse.tottho.tools.UX;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.ArrayList;

import static com.teamtraverse.tottho.tools.Constants.REQUEST_CALL_CODE;
import static com.teamtraverse.tottho.tools.UtilsManager.exitApp;

public class MainActivity extends AppCompatActivity {
    private SlidingRootNav slidingRootNav;
    private ImageView drawerButton;
    private RecyclerView navRecycler, recentlyViewedRecycler;
    private SearchView searchView;
    private UX ux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region init sliding nav drawer
        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(null)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.layout_menu_left_drawer)
                .inject();
        //endregion

        //region init ui and then perform all UI interactions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region init ui and then perform all UI interactions
    private void initUI() {
        navRecycler = findViewById(R.id.list);
        drawerButton = findViewById(R.id.DrawerButton);
        recentlyViewedRecycler = findViewById(R.id.mRecyclerView);
        searchView = findViewById(R.id.SearchText);
        ux = new UX(this);
    }
    //endregion

    private void bindUIWithComponents() {

        //region ask permission
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL_CODE);
        }
        //endregion

        //region set drawer adapter
        setDrawerAdapter();
        //endregion

        //region set recent link recycler adapter
        setRecentlyViewedRecyclerAdapter();
        //endregion

        //region drawer hum-burger icon
        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(slidingRootNav.isMenuClosed()) {
                    slidingRootNav.openMenu();
                    drawerButton.setImageResource(R.drawable.ic_left_arrow);
                }
                else {
                    slidingRootNav.closeMenu();
                    drawerButton.setImageResource(R.drawable.ic_menu_new);
                }
            }
        });
        //endregion

        //region searchView operations
        ux.changeSearchViewHintAndTextColor(searchView, R.color.md_white_1000);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        //endregion
    }
    //endregion

    //region set drawer adapter
    private void setDrawerAdapter() {
        NavDrawerRecyclerAdapter drawerRecyclerAdapter = new NavDrawerRecyclerAdapter(getDrawerItem());
        navRecycler.setLayoutManager(new LinearLayoutManager(this));
        navRecycler.setAdapter(drawerRecyclerAdapter);
        drawerRecyclerAdapter.notifyDataSetChanged();

        //region drawer item click listener
        drawerRecyclerAdapter.setOnItemClickListener(new NavDrawerRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(NavDrawer navDrawer) {
                if (navDrawer.getIcon() == R.drawable.ic_user){
                    showActivity(ProfileActivity.class);
                }
                else if (navDrawer.getIcon() == R.drawable.ic_education){
                    showActivity(EducationActivity.class);
                }
                else if (navDrawer.getIcon() == R.drawable.ic_events){
                    showActivity(EventsActivity.class);
                }
                else if (navDrawer.getIcon() == R.drawable.ic_scholarship){
                    showActivity(ScholarshipListActivity.class);
                }
                else if (navDrawer.getIcon() == R.drawable.ic_government){
                    showActivity(GovernmentActivity.class);
                }
                else if (navDrawer.getIcon() == R.drawable.ic_logout){
                    showActivity(GenericAuthActivity.class);
                }
                slidingRootNav.closeMenu();
            }
        });
        //endregion
    }
    //endregion

    //region set recent link recycler adapter
    private void setRecentlyViewedRecyclerAdapter(){
        RecyclerAdapterRecentlyViewedLink recyclerAdapter = new RecyclerAdapterRecentlyViewedLink(getRecentlyViewedLink(),MainActivity.this);
        recentlyViewedRecycler.setLayoutManager(new LinearLayoutManager(this));
        recentlyViewedRecycler.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }
    //endregion

    //region start activity
    private void showActivity(Class activity) {
        startActivity(new Intent(MainActivity.this,activity));
    }
    //endregion

    //region get drawer list items
    private ArrayList<NavDrawer> getDrawerItem() {
        ArrayList<NavDrawer> items = new ArrayList<>();
        items.add(new NavDrawer(R.drawable.ic_user,getString(R.string.profile)));
        items.add(new NavDrawer(R.drawable.ic_education,getString(R.string.education)));
        items.add(new NavDrawer(R.drawable.ic_events,getString(R.string.events)));
        items.add(new NavDrawer(R.drawable.ic_scholarship,getString(R.string.scholarship_portal)));
        items.add(new NavDrawer(R.drawable.ic_government,getString(R.string.government)));
        items.add(new NavDrawer(R.drawable.ic_logout,getString(R.string.logout)));
        return items;
    }
    //endregion

    //region get recycler items for recently viewed links
    private ArrayList<Post> getRecentlyViewedLink(){
        ArrayList<Post> postArrayList = new ArrayList<>();
        postArrayList.add(new Post(1,"Daffodil International University","daffodilvarsity@diu.edu.bd","+880-1739-574727","http://studentportal.diu.edu.bd/", "Sobahanbagh,Dhanmondi-27,Dhaka",1,"10-Jan-2020"));
        postArrayList.add(new Post(2,"BUET","buet@edu.bd","+880-1739-574727","http://buet.diu.edu.bd/", "Shahbagh,Palashi,Dhaka",2,"30-Jun-2019"));
        postArrayList.add(new Post(3,"DMC","dhakamedicalcollege@edu.bd","+880-4512-574727","http://studentportal.diu.edu.bd/", "Sobahanbagh,Dhanmondi-27,Dhaka",2,"20-Aug-2018"));
        return postArrayList;
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        exitApp(MainActivity.this);
    }
    //endregion
}