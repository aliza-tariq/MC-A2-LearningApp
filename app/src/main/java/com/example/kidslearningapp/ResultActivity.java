package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    private TextView textViewReceiveMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewReceiveMessage = findViewById(R.id.resultText);

        Intent intent = getIntent();
        //textViewReceiveMessage.setText(intent.getStringExtra("WelcomeMessage"));
        int number = intent.getIntExtra("nmbr",0);
        textViewReceiveMessage.setText(Integer.toString(number));


    }
}