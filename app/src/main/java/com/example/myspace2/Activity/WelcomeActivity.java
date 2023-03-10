package com.example.myspace2.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myspace2.MainActivity;
import com.example.myspace2.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toMain();
            }
        },2000);
    }
    private void toMain(){
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
    }
}
