package com.teamtraverse.tottho.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.teamtraverse.tottho.R;
import com.teamtraverse.tottho.adapters.NavDrawerRecyclerAdapter;
import com.teamtraverse.tottho.models.drawer.NavDrawer;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SlidingRootNav slidingRootNav;
    private ImageView drawerButton;
    private RecyclerView navRecycler;

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
    }

    private void bindUIWithComponents() {
        //region set drawer adapter
        setDrawerAdapter();
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
                slidingRootNav.closeMenu();
            }
        });
        //endregion
    }
    //endregion

    //region get drawer list items
    private ArrayList<NavDrawer> getDrawerItem() {
        ArrayList<NavDrawer> items = new ArrayList<>();
        items.add(new NavDrawer(R.drawable.ic_user,getString(R.string.profile)));
        items.add(new NavDrawer(R.drawable.ic_education,getString(R.string.education)));
        items.add(new NavDrawer(R.drawable.ic_events,getString(R.string.events)));
        items.add(new NavDrawer(R.drawable.ic_scholarship,getString(R.string.scholarship_portal)));
        items.add(new NavDrawer(R.drawable.ic_logout,getString(R.string.logout)));
        return items;
    }
    //endregion

}