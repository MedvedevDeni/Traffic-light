package com.trafficlight.denis.trafficlight;

import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int color;
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.constraintLayout);
        color = ContextCompat.getColor(this, R.color.lightGray);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color",  color);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("color")) {
            color = savedInstanceState.getInt("color");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        resetUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void resetUI() {
        mainLayout.setBackgroundColor(color);
    }

    public void onClickBtnColor(View view) {
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
