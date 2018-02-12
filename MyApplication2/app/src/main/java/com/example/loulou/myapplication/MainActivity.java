package com.example.loulou.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("__________________________CREATE__________________________");
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {

        super.onStart();
        System.out.println("__________________________START__________________________");
    }

    protected void onStop() {

        super.onStop();
        System.out.println("__________________________STOP__________________________");
    }
    protected  void onRestart() {

        super.onRestart();
        System.out.println("__________________________RESTART__________________________");
    }
    protected void onResume(){

        super.onResume();
        System.out.println("__________________________RESUME__________________________");
    }
    protected void onPause() {

        super.onPause();
        System.out.println("__________________________PAUSE__________________________");
    }

}
