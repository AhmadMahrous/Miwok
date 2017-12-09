package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        String[] words = {"one", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        Log.v("Words", words[0]);
    }
}
