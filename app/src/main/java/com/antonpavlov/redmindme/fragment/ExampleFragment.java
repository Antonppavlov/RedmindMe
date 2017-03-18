package com.antonpavlov.redmindme.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antonpavlov.redmindme.R;

public class ExampleFragment extends Fragment {

    private View view;
    private final static int LAYOUT = R.layout.example_fragment;

    public static ExampleFragment getInstance() {
        return new ExampleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }
}
