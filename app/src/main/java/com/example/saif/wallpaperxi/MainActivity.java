package com.example.saif.wallpaperxi;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {



    private ViewPager viewPager;
    private TabLayout tabLayout;
    private DrawerLayout drawerLayout;
    private android.support.v7.widget.Toolbar tb;
    private TextView tvnavusername;
    private NavigationView navigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayoutmain);
        tabLayout=(TabLayout)findViewById(R.id.tablayout_id);
        viewPager=(ViewPager)findViewById(R.id.viewpager_id);
        tb=  findViewById(R.id.toolbar_id);


        //drawer menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,tb,R.string.open,R.string.close);
        
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //navigation view
        navigationView= findViewById(R.id.navdrawer);
        View h = navigationView.inflateHeaderView(R.layout.nav_header);




        ViewPagerAdaptr  viewpageradapter= new ViewPagerAdaptr(getSupportFragmentManager());


        viewpageradapter.Addfragment(new FragmentForExplore(), "EXPLORE");
        viewpageradapter.Addfragment(new FragmentCategory(), "CATEGORY");
        viewpageradapter.Addfragment(new FragmentJustForYou(), "JUST FOR YOU");


        viewPager.setAdapter(viewpageradapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
