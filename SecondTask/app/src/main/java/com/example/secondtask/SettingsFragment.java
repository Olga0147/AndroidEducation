package com.example.secondtask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    RadioGroup radioGroup;
    SharedPreferencesHelper sharedPreferencesHelper;

    private final RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton radioButton = group.findViewById(checkedId);
            sharedPreferencesHelper.addSearcherName(new Searcher(radioButton.getText().toString()));
        }
    };

    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.settins_fragment,container,false);
        radioGroup = view.findViewById(R.id.radio_group_id);

        sharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);

        return view;
    }

}
