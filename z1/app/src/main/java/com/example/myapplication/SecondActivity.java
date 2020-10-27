package com.example.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String TEXT = "TEXT";
    private TextView tv;
    private Button b;

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            searchWeb(tv.getText().toString());
        }
    };

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_two);
        tv = findViewById(R.id.textV);
        Bundle bundle = getIntent().getExtras();
        tv.setText(bundle.getString(TEXT));

        b = findViewById(R.id.btn_2);
        b.setOnClickListener(onClickListener);

    }
}
