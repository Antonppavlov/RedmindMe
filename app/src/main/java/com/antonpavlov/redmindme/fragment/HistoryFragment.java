//package com.antonpavlov.redmindme.fragment;
//
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.antonpavlov.redmindme.R;
//import com.antonpavlov.redmindme.adapter.RemindListAdapter;
//import com.antonpavlov.redmindme.dto.RemindDTO;
//import com.antonpavlov.redmindme.fragment.abstact.AbstractTabFragment;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import ru.trancletor.www.yandex.database.Initializer;
//import ru.trancletor.www.yandex.object.Word;
//
//public class HistoryFragment extends AbstractTabFragment {
//
//    private final static int LAYOUT = R.layout.history_fragment;
//
//    private Context context;
//    private View view;
//
//
//    private static HistoryFragment historyFragment;
//
//    public static HistoryFragment getInstance(Context context) {
//        historyFragment = new HistoryFragment();
//        historyFragment.context = context;
//        historyFragment.setTitle(context.getString(R.string.history));
//
//
//        return historyFragment;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(LAYOUT, container, false);
//
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//
//        List<Word> wordList = Initializer.getWordDAO().getWordList();
//
//        recyclerView.setAdapter(new RemindListAdapter(wordList));
//
//        return view;
//    }
//
//}
