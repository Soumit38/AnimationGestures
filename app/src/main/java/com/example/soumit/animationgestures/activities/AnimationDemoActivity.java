package com.example.soumit.animationgestures.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.soumit.animationgestures.R;

/**
 * Created by Soumit on 2/18/2018.
 */

public class AnimationDemoActivity extends AppCompatActivity {

    private Button btnFadeOut;
    private TextView tvMessage;
    private Button btnRepeat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_demo);
        btnFadeOut = (Button) findViewById(R.id.btnFade);
        btnRepeat = (Button) findViewById(R.id.btnRepeat);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
    }

    public void onFadeOut(View v){
        btnFadeOut.animate().alpha(0).setDuration(2000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                btnFadeOut.animate().alpha(1f).setDuration(2000);
            }
        });
    }

    // Slide message from button up to display, then later slide out
    public void onSlideMessage(View v){
        tvMessage.setTranslationY(tvMessage.getHeight());
        tvMessage.setVisibility(View.VISIBLE);

        tvMessage.animate().translationY(0).setDuration(2000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                tvMessage.animate().translationY(tvMessage.getHeight()).setDuration(2000).setStartDelay(2000);
            }
        });
    }


    public void onRepeatAnimation(View v){
        //setup scaleY
        ObjectAnimator scaleAnimY = ObjectAnimator
                .ofFloat(btnRepeat, "scaleY", 1.0f, 1.5f);
        scaleAnimY.setDuration(3000);
        scaleAnimY.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnimY.setRepeatMode(ValueAnimator.REVERSE);

        //setup scaleX
        ObjectAnimator scaleAnimX = ObjectAnimator.ofFloat(btnRepeat, "scaleX", 1.0f, 1.5f);
        scaleAnimX.setDuration(3000);
        scaleAnimX.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnimX.setRepeatMode(ValueAnimator.REVERSE);

        //setup animation set
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleAnimX, scaleAnimY);
        set.start();
    }


    public void onActivityTransition(View v){
        Intent intent = new Intent(AnimationDemoActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

    // Returns height of the screen
    public int getScreenHeight(){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        return metrics.heightPixels;
    }

}
































