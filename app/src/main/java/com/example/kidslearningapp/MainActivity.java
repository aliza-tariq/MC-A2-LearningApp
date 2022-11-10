package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textViewOp1,textViewOp2,textViewOp3,textViewResults,result;

    private Button option1,option2,option3;

    int skyRight=0,skyWrong=0,grassRight=0,grassWrong=0,rootRight=0,rootWrong=0;
    List<Integer> list=new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOp1=findViewById(R.id.textViewOp1);
        textViewOp2=findViewById(R.id.textViewOp2);
        textViewOp3=findViewById(R.id.textViewOp3);
        textViewResults=findViewById(R.id.textViewAns);

        option1=findViewById(R.id.buttonOpt1);
        option2=findViewById(R.id.buttonOpt2);
        option3=findViewById(R.id.buttonOpt3);
        result=findViewById(R.id.textViewTotal);


    }

    public int generateRnadomNumber(int start,int range)
    {
        Random random=new Random();
        int num=random.nextInt(start,range);
        return num;
    }
    public void setQuestion()
    {
        int num1=generateRnadomNumber(0,10);
        int num2=generateRnadomNumber(0,10);
        int answer=num1*num2;

        int opt1=generateRnadomNumber(answer-10,answer+10);
        while(opt1!=answer)
        {
            opt1=generateRnadomNumber(answer-10,answer+10);
        }


        int opt2=generateRnadomNumber(answer-10,answer+10);
        while(opt2!=answer&&opt2!=opt1)
        {
            opt2=generateRnadomNumber(answer-10,answer+10);
        }

        int opt3=generateRnadomNumber(answer-10,answer+10);
        while(opt3!=answer&&opt3!=opt1&&opt3!=opt2)
        {
            opt3=generateRnadomNumber(answer-10,answer+10);
        }

    }

}