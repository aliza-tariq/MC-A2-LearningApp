package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView textViewOp1,textViewOp2,textViewOp3,textViewResults,resultStatus,textViewInfo;

    private Button option1,option2,option3;

    int total=0,correct=0,incorrect=0;
    Vector<String> vecStr = new Vector<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOp1=findViewById(R.id.textViewOp1);
        textViewOp2=findViewById(R.id.textViewOp2);
        textViewOp3=findViewById(R.id.textViewOp3);
        textViewResults=findViewById(R.id.textViewAns);
        textViewInfo=findViewById(R.id.textView5);

        option1=findViewById(R.id.buttonOpt1);
        option2=findViewById(R.id.buttonOpt2);
        option3=findViewById(R.id.buttonOpt3);
        resultStatus=findViewById(R.id.textViewTotal);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);


        setQuestion();
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

    public void setCorrectAns()
    {
        textViewInfo.setText("CORRECT");
        textViewInfo.setBackgroundColor(Color.GREEN);
    }

    public void setWrongAns()
    {
        textViewInfo.setText("WRONG");
        textViewInfo.setBackgroundColor(Color.RED);
    }


    @Override
    public void onClick(View view)
    {
        int num1=Integer.parseInt(textViewOp1.getText().toString());
        int num2=Integer.parseInt(textViewOp2.getText().toString());
        int result=num1*num2;
        int optSelected=0;
        switch (view.getId()) {
            case R.id.buttonOpt1:
                optSelected=Integer.parseInt(option1.getText().toString());
                break;
            case R.id.buttonOpt2:
                optSelected=Integer.parseInt(option2.getText().toString());
                break;
            case R.id.buttonOpt3:
                optSelected=Integer.parseInt(option3.getText().toString());
                break;
        }

        boolean status=false;
        if(result==optSelected)
        {
            correct++;
            status=true;
            setCorrectAns();
        }
        else {
            incorrect++;
            setWrongAns();
        }
        total++;
        resultStatus.setText("Total : "+total+"\nCorrect : "+correct+"\nIncorrect : "+incorrect);
        String str="";

        String column1Format = "%-15.15s";  // fixed size 3 characters, left aligned
        String column2Format = "%-3.3s";  // fixed size 8 characters, left aligned
        String column3Format = "%-3.3s";
        String formatInfo = column1Format + " " + column2Format + " " + column3Format;
        
        String count=Integer.toString((int)(total));
        if(status==true) {
            str = count+". "+Integer.toString(num1) + "x" + Integer.toString(num2) + "=" + Integer.toString(result) + "_____" +
                    Integer.toString(optSelected)+"_____"+"\u2714";
        }
        else
        {
            str =  count+". "+Integer.toString(num1) + "x" + Integer.toString(num2) + "=" + Integer.toString(result) + "_____" +
                    Integer.toString(optSelected)+"_____"+"\u2716";
        }
        if(vecStr.size()==10)
        {
            vecStr.remove(0);
        }

        vecStr.add(str);
        String data="";
        for(int i=0;i<vecStr.size();i++)
        {

            data=data+vecStr.get(i)+"\n";
        }
        data="   QUESTION___YOUR ANS___\u2714/\u2716\n"+data;

        textViewResults.setText(data);

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