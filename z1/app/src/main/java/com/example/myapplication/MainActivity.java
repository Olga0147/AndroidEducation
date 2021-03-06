package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private Button button;

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!TextUtils.isEmpty(editText.getText())){
                String nameString=editText.getText().toString();
                Toast.makeText(MainActivity.this,nameString,Toast.LENGTH_SHORT).show();

                Intent secondIntent =
                        new Intent(MainActivity.this, SecondActivity.class);
                secondIntent.putExtra(SecondActivity.TEXT, nameString);
                startActivity(secondIntent);

            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.btn_1);

        button.setOnClickListener(onClickListener);
    }
}