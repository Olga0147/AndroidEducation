package com.example.secondtask;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class SearchFragment extends Fragment {

    private Button button;
    private EditText editText;
    SharedPreferencesHelper sharedPreferencesHelper;

    public static SearchFragment newInstance() {
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String searcherName = sharedPreferencesHelper.getSearcherName();
            System.out.println(searcherName);
            String searchText = editText.getText().toString();

            switch (searcherName) {
                case "Google":
                    searchWeb("https://www.google.com/search?q=" + searchText);
                    break;
                case "Яндекс":
                    searchWeb("https://yandex.ru/search/?text=" + searchText);
                    break;
                case "Bing":
                    searchWeb("https://www.bing.com/search?q=" + searchText);
                    break;
                default:
                    break;
            }
        }
    };

    @SuppressLint("QueryPermissionsNeeded")
    public void searchWeb(String query) {

    startActivity(
            new Intent(
                    Intent.ACTION_VIEW, Uri.parse(query)
            ));
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search_fragment,container,false);

        button = view.findViewById(R.id.search_btn_id);
        button.setOnClickListener(onClickListener);
        editText = view.findViewById(R.id.search_text_id);
        sharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        return view;
    }

}
