package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView countDownText;
    Button buttonStart;
    CountDownTimer countDownTimer;

    public long timeLeftInMillis = 10000; // 1 dakika

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countDownText = findViewById(R.id.countDownText);
        buttonStart = findViewById(R.id.buttonStart);

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                timeLeftInMillis = millisUntilFinished;
                System.out.println(timeLeftInMillis);

                updateCountDownText();
            }
            @Override
            public void onFinish()
            {
                countDownText.setText("Bitti!");
            }
        };

        buttonStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                countDownTimer.start();
            }
        });
    }

    public void updateCountDownText()
    {
        System.out.println("update fonksiyonu");
        int minutes = (int) (timeLeftInMillis /1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        countDownText.setText(String.valueOf(seconds));
    }
}