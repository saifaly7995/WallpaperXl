package com.example.saif.wallpaperxi;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdaptr  extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList= new ArrayList<>();
    private final List<String> fragmentTitles= new ArrayList<>();

    public ViewPagerAdaptr(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new FragmentForExplore();
        } else if (position == 1) {
            return new FragmentCategory();
        } else if (position == 2) {
            return new FragmentJustForYou();
        }
        else return new FragmentForExplore();


    }

    @Override
    public int getCount() {
        return fragmentTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }

    public  void  Addfragment(Fragment fragment,String Title){
        fragmentList.add(fragment);
        fragmentTitles.add(Title);
    }
}

