package com.example.firabasefirstexperience.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.firabasefirstexperience.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartLoadingActivity extends AppCompatActivity {

    private FirebaseUser fbUser;

    private static final int LOADING_SCREEN_SHOW_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_loading);

        fbUser = FirebaseAuth.getInstance().getCurrentUser();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (fbUser != null) {
                    Intent intent = new Intent(StartLoadingActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(StartLoadingActivity.this, StartActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, LOADING_SCREEN_SHOW_TIME);
    }
}