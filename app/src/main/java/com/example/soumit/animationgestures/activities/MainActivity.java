package com.example.soumit.animationgestures.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.soumit.animationgestures.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchDemo(View v){
        switch (v.getId()){
            case R.id.btnAnimationDemo:
                startActivity(new Intent(this, AnimationDemoActivity.class));
                break;
            default:
                startActivity(new Intent(this, GestureDemoActivity.class));
                break;
        }
    }

}
