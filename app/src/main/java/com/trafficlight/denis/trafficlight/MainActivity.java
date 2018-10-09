package com.trafficlight.denis.trafficlight;

import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int color;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color",  color);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("color")) {
            color = savedInstanceState.getInt("color");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        resetUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        resetUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    private void resetUI() {
        (findViewById(R.id.constraintLayout)).setBackgroundColor(color);
        Log.d(TAG, "resetUI");
    }

    public void onClickBtnColor(View view) {
        ConstraintLayout mainLayout = findViewById(R.id.constraintLayout);
        switch (view.getId()) {
            case R.id.redButton:
                color = ContextCompat.getColor(this, R.color.red);
                break;
            case R.id.yellowButton:
                color = ContextCompat.getColor(this, R.color.yellow);
                break;
            case R.id.greenButton:
                color = ContextCompat.getColor(this, R.color.green);
                break;
        }
        mainLayout.setBackgroundColor(color);
    }
}
