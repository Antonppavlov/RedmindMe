package com.antonpavlov.redmindme.adapter;


import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.antonpavlov.redmindme.fragment.FavoritesFragment;
import com.antonpavlov.redmindme.fragment.TranslatorFragment;
import com.antonpavlov.redmindme.fragment.abstact.AbstractTabFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> mapTab;
    private Context context;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        mapTab = new HashMap<>();
        mapTab.put(0, TranslatorFragment.getInstance(context));
//        mapTab.put(1, HistoryFragment.getInstance(context));
        mapTab.put(1, FavoritesFragment.getInstance(context));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mapTab.get(position).getTitle();
    }

    @Override
    public AbstractTabFragment getItem(int position) {
        return mapTab.get(position);
    }

    @Override
    public int getCount() {
        return mapTab.size();
    }
}
