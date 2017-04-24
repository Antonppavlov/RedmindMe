package com.antonpavlov.redmindme;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.antonpavlov.redmindme.adapter.TabsFragmentAdapter;
import com.antonpavlov.redmindme.app.DbConnection;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            DbConnection.initConnection(getApplicationContext());
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getSQLState(), Toast.LENGTH_SHORT).show();
        }

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setTheme(R.style.AppDefault);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(LAYOUT);
        initTabLayout();
    }


    private void  initTabLayout() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        TabsFragmentAdapter tabsAdapter = new TabsFragmentAdapter(getApplicationContext(),getSupportFragmentManager());
        viewPager.setAdapter(tabsAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }


}
