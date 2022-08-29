package com.example.gabo;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    private ImageView img_main;
    private LinearLayout startLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        img_main = findViewById(R.id.img_main);
        startLayout =findViewById(R.id.startLayout);

        progressBar = findViewById(R.id.progressBar);
        // 상단 바 없앰
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ProThread thread = new ProThread(progressBar);
        thread.start();
/**
        startLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
*/
    }
    Handler handler = new Handler(){
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            int pcnt = msg.arg1;
            progressBar.setProgress(pcnt);
            super.handleMessage(msg);
        }
    };

    class ProThread extends Thread{
        ProgressBar progressBar;

        ProThread(ProgressBar progressBar){
            this.progressBar = progressBar;
        }
        @Override
        public void run() {
            try {
                for(int i = 0; i <= 100; i++){
                    Thread.sleep(20);
                    Message message = new Message();
                    message.arg1 = i;
                    handler.sendMessage(message);
                    //2초 이후에 화면 전환

                }
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            super.run();
        }
    }
}