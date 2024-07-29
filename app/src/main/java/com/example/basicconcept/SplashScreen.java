package com.example.basicconcept;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set the content view to the splash screen layout
        setContentView(R.layout.splash_screen);

        //Progress Bar
        ProgressBar progressBar = findViewById(R.id.linearprogressBar);
        // ValueAnimator to animate progress
        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.setDuration(2000); // 2 seconds
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressBar.setProgress((int) animation.getAnimatedValue());
            }
        });
        animator.start();


        // Delay for 2 seconds before transitioning to the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);

                // Finish the splash screen activity
                finish();
            }
        }, 2000); // 2000 milliseconds = 2 seconds
    }
}
