package com.example.helloliting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"李挺verbose");
        Log.d(TAG,"李挺debug");
        Log.w(TAG,"李挺warning");
        Log.e(TAG,"李挺error");
    }
}