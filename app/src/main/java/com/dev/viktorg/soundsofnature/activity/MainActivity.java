package com.dev.viktorg.soundsofnature.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dev.viktorg.soundsofnature.R;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startListenerActivity(View view) {
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }

    public void startQuizActivity(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}