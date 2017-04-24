package com.antonpavlov.redmindme.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.antonpavlov.redmindme.R;
import com.antonpavlov.redmindme.adapter.SpinnerAdapter;
import com.antonpavlov.redmindme.fragment.abstact.AbstractTabFragment;
import com.antonpavlov.redmindme.yandex.ApiKeys;
import com.antonpavlov.redmindme.yandex.language.Language;
import com.antonpavlov.redmindme.yandex.translate.Translate;

public class TranslatorFragment extends AbstractTabFragment {

    private final static int LAYOUT = R.layout.transletor_fragment;
    private Context context;
    private View view;

    private Spinner spinner1;
    private Spinner spinner2;

    private TextView translatedText;
    private EditText inputField;


    private static TranslatorFragment translatorFragment;

    public static TranslatorFragment getInstance(Context context) {
        translatorFragment = new TranslatorFragment();
        translatorFragment.context = context;
        translatorFragment.setTitle(context.getString(R.string.translator));

        return translatorFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);

        String[] arrayString = Language.getNameList();
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(context, 2, arrayString);

        spinner1.setAdapter(spinnerAdapter);
        spinner2.setAdapter(spinnerAdapter);

        SelectItemListener selectItemListener = new SelectItemListener();
        spinner1.setOnItemSelectedListener(selectItemListener);
        spinner2.setOnItemSelectedListener(selectItemListener);


        String translation = null;
        try {
            Translate.setKey(ApiKeys.YANDEX_API_KEY);
            translation = Translate.execute("The quick brown fox jumps over the lazy dog.", Language.English, Language.Russian);
        } catch (Exception e) {
            e.printStackTrace();
        }


        inputField = (EditText) view.findViewById(R.id.inputField);
        translatedText = (TextView) view.findViewById(R.id.translatedText);
translatedText.setText(translation);

        inputField.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String s1 = inputField.getText().toString();
                Language language1 = Language.values()[spinner1.getSelectedItemPosition()];
                Language language2 = Language.values()[spinner2.getSelectedItemPosition()];

                String translation = null;
                try {
                    Translate.setKey(ApiKeys.YANDEX_API_KEY);
                     translation = Translate.execute("The quick brown fox jumps over the lazy dog.", Language.English, Language.Russian);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                translatedText.setText(translation);
                // Прописываем то, что надо выполнить после изменения текста
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        return view;
    }


    private class SelectItemListener implements AdapterView.OnItemSelectedListener {


        @Override
        public void onItemSelected(AdapterView<?> parent,
                                   View itemSelected, int selectedItemPosition, long selectedId) {
            String[] arrayString = Language.getNameList();
            Toast toast = Toast.makeText(context,
                    "Ваш выбор: " + arrayString[selectedItemPosition], Toast.LENGTH_SHORT);
            toast.show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
