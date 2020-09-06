package com.teamtraverse.tottho.activities.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.activities.education.EducationActivity;
import com.teamtraverse.tottho.activities.events.EventsActivity;
import com.teamtraverse.tottho.activities.government.GovernmentActivity;
import com.teamtraverse.tottho.activities.profile.ProfileActivity;
import com.teamtraverse.tottho.activities.scholarship.ScholarshipActivity;
import com.teamtraverse.tottho.adapters.NavDrawerRecyclerAdapter;
import com.teamtraverse.tottho.adapters.RecyclerAdapterRecentlyViewedLink;
import com.teamtraverse.tottho.models.drawer.NavDrawer;
import com.teamtraverse.tottho.models.link.Post;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SlidingRootNav slidingRootNav;
    private ImageView drawerButton;
    private RecyclerView navRecycler, recentlyViewedRecycler;

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
    }
    //endregion

    private void bindUIWithComponents() {
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
                    showActivity(ScholarshipActivity.class);
                }
                else if (navDrawer.getIcon() == R.drawable.ic_government){
                    showActivity(GovernmentActivity.class);
                }
                else if (navDrawer.getIcon() == R.drawable.ic_logout){

                }
                slidingRootNav.closeMenu();
            }
        });
        //endregion
    }
    //endregion

    //region set recent link recycler adapter
    private void setRecentlyViewedRecyclerAdapter(){
        RecyclerAdapterRecentlyViewedLink recyclerAdapter = new RecyclerAdapterRecentlyViewedLink(getRecentlyViewedLink());
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
        postArrayList.add(new Post(1,"BUET","buet@edu.bd","+880-1739-574727","http://buet.diu.edu.bd/", "Shahbagh,Palashi,Dhaka",2,"30-Jun-2019"));
        postArrayList.add(new Post(1,"DMC","dhakamedicalcollege@edu.bd","+880-4512-574727","http://studentportal.diu.edu.bd/", "Sobahanbagh,Dhanmondi-27,Dhaka",2,"20-Aug-2018"));
        return postArrayList;
    }
    //endregion
}