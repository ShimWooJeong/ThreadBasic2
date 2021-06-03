package com.example.threadbasic2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread wr;
    boolean running = true;
    final String TAG = "THREAD2";
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
protected void onStart() {
        super.onStart();
        i = 0;
        running = true;
        wr = new Thread(new Runnable() {
            @Override
            public void run() {
                for(i = 0; i < 20 && running;){
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e) {
                    }
                }
                Log.v(TAG, "Thread time=" + i);
            }
        });
        wr.start();
        Log.v(TAG, "Now I am in onStart");
        Log.v(TAG, "Thread time=" + i);
    }

    @Override
    public void onStop() {
        super.onStop();
        running = false;
        i++;

        Log.v(TAG, "Now I am in onStop");
        Log.v(TAG, "Runnable time=" + i);
        Log.v(TAG, "Thread time=" + i);

    }

    @Override
    public void onPause() {
        super.onPause();
        running = false;
        i++;

        Log.v(TAG, "Now I am in onPause");
        Log.v(TAG, "Runnable time=" + i);
        Log.v(TAG, "Thread time=" + i);
        i++;
        Log.v(TAG, "Runnable time=" + i);
        Log.v(TAG, "Thread time=" + i);
    }

    @Override
    public void onResume() {
        super.onResume();
        running = false;
        i++;

        Log.v(TAG, "Now I am in onResume");
        Log.v(TAG, "Runnable time=" + i);
        Log.v(TAG, "Thread time=" + i);
    }

}
