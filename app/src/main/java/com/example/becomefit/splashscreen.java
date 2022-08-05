package com.example.becomefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
TextView textView;
ImageView imageView;
Animation up,down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        textView = findViewById(R.id.textView2);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textView.setAnimation(down);
        imageView = findViewById(R.id.imageView2);
        up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        imageView.setAnimation(up);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
           startActivity(new Intent(getApplicationContext(),MainActivity.class));
           finish();
            }
        },3500);
    }
}