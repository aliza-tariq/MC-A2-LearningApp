package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class ResultActivity extends AppCompatActivity {

    private TextView textViewReceiveMessage;
    private ListView listViewResult;
    private TextView [] questions;
    private Button[][] options;
    private Button [] status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        questions=new TextView[10];
            questions[0]=findViewById(R.id.question1);
            questions[1]=findViewById(R.id.question2);
            questions[2]=findViewById(R.id.question3);
            questions[3]=findViewById(R.id.question4);
            questions[4]=findViewById(R.id.question5);
            questions[5]=findViewById(R.id.question6);
            questions[6]=findViewById(R.id.question7);
            questions[7]=findViewById(R.id.question8);
            questions[8]=findViewById(R.id.question9);
            questions[9]=findViewById(R.id.question10);
            options =new Button[10][3];

    options[0][0]=findViewById(R.id.q1btn1);
    options[0][1]=findViewById(R.id.q1btn2);
    options[0][2]=findViewById(R.id.q1btn3);

        options[1][0]=findViewById(R.id.q2btn1);
        options[1][1]=findViewById(R.id.q2btn2);
        options[1][2]=findViewById(R.id.q2btn3);


        options[2][0]=findViewById(R.id.q3btn1);
        options[2][1]=findViewById(R.id.q3btn2);
        options[2][2]=findViewById(R.id.q3btn3);


        options[3][0]=findViewById(R.id.q4btn1);
        options[3][1]=findViewById(R.id.q4btn2);
        options[3][2]=findViewById(R.id.q4btn3);

        options[4][0]=findViewById(R.id.q5btn1);
        options[4][1]=findViewById(R.id.q5btn2);
        options[4][2]=findViewById(R.id.q5btn3);

        options[5][0]=findViewById(R.id.q6btn1);
        options[5][1]=findViewById(R.id.q6btn2);
        options[5][2]=findViewById(R.id.q6btn3);

        options[6][0]=findViewById(R.id.q7btn1);
        options[6][1]=findViewById(R.id.q7btn2);
        options[6][2]=findViewById(R.id.q7btn3);

        options[7][0]=findViewById(R.id.q8btn1);
        options[7][1]=findViewById(R.id.q8btn2);
        options[7][2]=findViewById(R.id.q8btn3);

        options[8][0]=findViewById(R.id.q9btn1);
        options[8][1]=findViewById(R.id.q9btn2);
        options[8][2]=findViewById(R.id.q9btn3);

        options[9][0]=findViewById(R.id.q10btn1);
        options[9][1]=findViewById(R.id.q10btn2);
        options[9][2]=findViewById(R.id.q10btn3);

        status=new Button[10];
        status[0]=findViewById(R.id.status1);
        status[1]=findViewById(R.id.status2);
        status[2]=findViewById(R.id.status3);
        status[3]=findViewById(R.id.status4);
        status[4]=findViewById(R.id.status5);
        status[5]=findViewById(R.id.status6);
        status[6]=findViewById(R.id.status7);
        status[7]=findViewById(R.id.status8);
        status[8]=findViewById(R.id.status8);
        status[9]=findViewById(R.id.status10);

        setQuestions();

//        DBHelper dbHelper = new DBHelper(ResultActivity.this);
//        List<ResultModel> list = dbHelper.getAllResults();
//        System.out.println(list);
//        for(int i=0;i<4;i++)
//        {
//            System.out.println(list.get(i));
//        }
       // ArrayAdapter arrayAdapter = new ArrayAdapter<ResultModel>
         //       (ResultActivity.this, android.R.layout.simple_list_item_1,list);
        //listViewResult.setAdapter(arrayAdapter);

    }


    public void setQuestions()
    {
        DBHelper dbHelper = new DBHelper(ResultActivity.this);
        List<ResultModel> list = dbHelper.getAllResults();
        System.out.println(list);
        for(int i=0;i<10;i++)
        {
            System.out.println(list.get(i));
            questions[i].setText(String.valueOf(i+1)+") "+list.get(i).getQuestion());
            options[i][0].setText(String.valueOf(list.get(i).getOptiona()));
            options[i][1].setText(String.valueOf(list.get(i).getOptionb()));
            options[i][2].setText(String.valueOf(list.get(i).getOptionc()));
            status[i].setText(list.get(i).getStatus());


            if(list.get(i).getResult()==list.get(i).getOptionSelected())
            {
                if(list.get(i).getOptiona()==list.get(i).getResult())
                {
                    options[i][0].setBackgroundColor(Color.GREEN);
                }
                else if(list.get(i).getOptionb()==list.get(i).getResult())
                {
                    options[i][1].setBackgroundColor(Color.GREEN);
                }
                else if(list.get(i).getOptionc()==list.get(i).getResult()) {
                    options[i][2].setBackgroundColor(Color.GREEN);
                }
            }
            else
            {
                if(list.get(i).getOptiona()==list.get(i).getResult())
                {
                    options[i][0].setBackgroundColor(Color.GREEN);
                }
                else if(list.get(i).getOptionb()==list.get(i).getResult())
                {
                    options[i][1].setBackgroundColor(Color.GREEN);
                }
                else if(list.get(i).getOptionc()==list.get(i).getResult()) {
                    options[i][2].setBackgroundColor(Color.GREEN);
                }

                if(list.get(i).getOptiona()==list.get(i).getOptionSelected())
                {
                    options[i][0].setBackgroundColor(Color.RED);
                }
                else if(list.get(i).getOptionb()==list.get(i).getOptionSelected())
                {
                    options[i][1].setBackgroundColor(Color.RED);
                }
                else if(list.get(i).getOptionc()==list.get(i).getOptionSelected()) {
                    options[i][2].setBackgroundColor(Color.RED);
                }
            }
        }


    }
}