package com.antonpavlov.redmindme.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antonpavlov.redmindme.R;
import com.antonpavlov.redmindme.adapter.RemindListAdapter;
import com.antonpavlov.redmindme.dto.RemindDTO;
import com.antonpavlov.redmindme.fragment.abstact.AbstractTabFragment;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends AbstractTabFragment {

    private final static int LAYOUT = R.layout.history_fragment;

    private Context context;
    private View view;


    private static HistoryFragment historyFragment;

    public static HistoryFragment getInstance(Context context) {
        historyFragment = new HistoryFragment();
        historyFragment.context = context;
        historyFragment.setTitle(context.getString(R.string.history));


        return historyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new RemindListAdapter(createMokeData()));


        return view;
    }

    private List<RemindDTO> createMokeData() {
        List<RemindDTO> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(new RemindDTO("Item " + i, "Description " + i));
        }
        return list;
    }


}
