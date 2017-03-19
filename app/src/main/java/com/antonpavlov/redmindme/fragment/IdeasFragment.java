package com.antonpavlov.redmindme.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antonpavlov.redmindme.R;
import com.antonpavlov.redmindme.fragment.abstact.AbstractTabFragment;

public class IdeasFragment extends AbstractTabFragment {

    private final static int LAYOUT = R.layout.example_fragment;

    private Context context;
    private View view;


    private static IdeasFragment ideasFragment;

    public static IdeasFragment getInstance(Context context) {
        ideasFragment = new IdeasFragment();
        ideasFragment.context = context;
        ideasFragment.setTitle(context.getString(R.string.ideas));


        return ideasFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView textView = (TextView) getActivity().findViewById(R.id.text_view_title_history_fragment);
//        textView.setText(title);


        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }

}
