package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class ResultActivity extends AppCompatActivity {

    private TextView textViewReceiveMessage;
    private ListView listViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewReceiveMessage = findViewById(R.id.resultText);
        listViewResult=findViewById(R.id.listViewResult);

        Intent intent = getIntent();
        //textViewReceiveMessage.setText(intent.getStringExtra("WelcomeMessage"));
        int number = intent.getIntExtra("nmbr",0);

        textViewReceiveMessage.setText(Integer.toString(number));


        DBHelper dbHelper = new DBHelper(ResultActivity.this);
        List<ResultModel> list = dbHelper.getAllResults();
        ArrayAdapter arrayAdapter = new ArrayAdapter<ResultModel>
                (ResultActivity.this, android.R.layout.simple_list_item_1,list);
        listViewResult.setAdapter(arrayAdapter);

    }
}