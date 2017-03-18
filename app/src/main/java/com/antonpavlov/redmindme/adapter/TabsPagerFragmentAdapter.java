package com.antonpavlov.redmindme.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.antonpavlov.redmindme.fragment.ExampleFragment;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public TabsPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
        tabs = new String[]{"Таб 1", "Напоминания", "Таб 2"};
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                return ExampleFragment.getInstance();
            }
            case 1: {
                return ExampleFragment.getInstance();
            }
            case 2: {
                return ExampleFragment.getInstance();
            }
        }


        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
