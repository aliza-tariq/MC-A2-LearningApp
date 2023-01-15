package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView textViewOp1,textViewOp2,textViewOp3,textViewResults,resultStatus,textViewInfo;

    private Button option1,option2,option3,btnResult;

    int total=0,correct=0,incorrect=0;
    //TO STORE QUESTIONS
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
        btnResult=findViewById(R.id.BtnResult);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);


        setQuestion();

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                int number=123456;

                intent.putExtra("WelcomeMessage","السلام علیکم");
                intent.putExtra("nmbr",number);
                startActivity(intent);
            }
        });
    }

    //generate random num 0-range
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

    //Function to set Questions
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

///Extend class onClickListerner
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
        String str="",str2="*******************************";
        String options="\n        A. "+option1.getText().toString()+"\n        B. "+option2.getText().toString()+
                "\n        C. "+option3.getText().toString();


        String count=Integer.toString((int)(total));
        if(status==true) {
            str = count+". "+Integer.toString(num1) + "x" + Integer.toString(num2) + "=" + Integer.toString(result) +
                    options+"\nYour Ans :" +
                    Integer.toString(optSelected)+"_____"+"\u2714"+"\n\n"+str2+"\n";
        }
        else
        {
            str =  count+". "+Integer.toString(num1) + "x" + Integer.toString(num2) + "=" + Integer.toString(result) +
                    options+"\nYour Ans :"+
                    Integer.toString(optSelected)+"_____"+"\u2716"+"\n\n"+str2+"\n";
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
        textViewResults.setText(data);
        //STORE IN DATA BASE

        try {
            ResultModel resultModel;
            resultModel = new ResultModel("2 * 3 = ?",6,5,8,6,6);
            Toast.makeText(MainActivity.this, resultModel.toString(), Toast.LENGTH_SHORT).show();
            DBHelper dbHelper = new DBHelper(MainActivity.this);
            dbHelper.addQuestionResult(resultModel);

        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }

        setQuestion();
    }

    public void openWebPage(View view) {
        Uri webpage = Uri.parse("https://github.com/aliza-tariq/MC-A2-LearningApp.git");
        Intent intent = new
                Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

}