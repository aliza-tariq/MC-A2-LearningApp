package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewOp1,textViewOp2,textViewOp3,textViewResults,result;

    private Button option1,option2,option3;

    int total=0,correct=0,incorrect=0;
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

    public int generateRnadomNumber(int range)
    {
        Random random=new Random();
        int num=random.nextInt(range);
        return num;
    }
    public int randomNumber(int min,int max)
    {
       return (int)(Math.random() * (max - min + 1) + min);
    }
    public void setQuestion()
    {
        int num1=generateRnadomNumber(10);
        int num2=generateRnadomNumber(10);
        int answer=num1*num2;

        int opt1=answer;


        int opt2=randomNumber(answer-10,answer+10);
        while(opt2==answer||opt2==opt1)
        {
            opt2=randomNumber(answer-10,answer+10);
        }

        int opt3=randomNumber(answer-10,answer+10);
        while(opt3==answer||opt3==opt1||opt3==opt2)
        {
            opt3=randomNumber(answer-10,answer+10);
        }

        textViewOp1.setText(Integer.toString(num1));
        textViewOp2.setText(Integer.toString(num2));

        int resultOpt=generateRnadomNumber(3);
        if(resultOpt==0) {
            option1.setText(Integer.toString(opt1));
            option2.setText(Integer.toString(opt2));
            option3.setText(Integer.toString(opt3));
        }
        else if(resultOpt==1)
        {
            int resultOpt2=generateRnadomNumber(2);
            option2.setText(Integer.toString(opt1));
            if(resultOpt2==0)
            {
                option1.setText(Integer.toString(opt2));
                option3.setText(Integer.toString(opt3));
            }
            else
            {
                option1.setText(Integer.toString(opt3));
                option3.setText(Integer.toString(opt2));
            }
        }
        else
        {
            int resultOpt2=generateRnadomNumber(2);
            option3.setText(Integer.toString(opt1));
            if(resultOpt2==0)
            {
                option1.setText(Integer.toString(opt2));
                option2.setText(Integer.toString(opt3));
            }
            else
            {
                option1.setText(Integer.toString(opt3));
                option2.setText(Integer.toString(opt2));
            }
        }

    }


    public void optionOne(View view)
    {
        setQuestion();
    }

    public void optionTwo(View view)
    {
        setQuestion();
    }
    public void optionThree(View view)
    {
        setQuestion();
    }

}