package com.example.reaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = (TextView) findViewById(R.id.count);
        Intent intent1 = new Intent(this, ans1.class);
        Intent intent2 = new Intent(this, ans2.class);
        Intent intent3 = new Intent(this, ans3.class);
        Intent intent4 = new Intent(this, ans4.class);
        long sec = Long.parseLong(textView2.getText().toString());
         CountDownTimer timer = new CountDownTimer(sec*1000, 1000) {
             @Override
             public void onTick(long millisUntilFinished){
                textView2.setText(Long.toString(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                 int a=(int) (Math.random()*4+1);
                 if (a==1) {
                     startActivity(intent1);
                 } else if(a==2) {
                     startActivity(intent2);
                 } else if (a==3) {
                     startActivity(intent3);
                 } else if (a==4){
                     startActivity(intent4);
                 }


                textView2.setText("0");
            }

            };
            timer.start();
        }
    }
