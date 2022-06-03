package com.example.reaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class ans3 extends AppCompatActivity {

    private int seconds;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans3);
        running = true;
        runTimer();
    }
    public void stop(View view) {
        running = false;

    }

    public void menu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        running = false;
        seconds = 0;
    }

    public void runTimer(){
        final TextView textView = (TextView) findViewById(R.id.timer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int secs = (seconds) /10;
                int msecs = (seconds%10);
                String time = String.format("%d.%d", secs, msecs);
                textView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 100);
            }
        });
    }
}