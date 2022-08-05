package com.example.becomefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Setting extends AppCompatActivity {
TextView t1,t2,t3,t4,t5,t6,t7,t8;
Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        t1=findViewById(R.id.textView8);
        t2=findViewById(R.id.textView7);
        t3=findViewById(R.id.textView6);
        t4=findViewById(R.id.textView5);
        t5=findViewById(R.id.text);
        t6=findViewById(R.id.text2);
        t8=findViewById(R.id.text4);
        t7=findViewById(R.id.text3);
        b1=findViewById(R.id.button7);
        b2=findViewById(R.id.button6);
        b3=findViewById(R.id.button);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,loginpage.class);
                startActivity(intent);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,fat.class);
                startActivity(intent);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,bmi.class);
                startActivity(intent);
            }
        });

        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,mr.class);
                startActivity(intent);
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,rate.class);
                startActivity(intent);
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.celon.com.np"));
                startActivity(intent);
            }
        });

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,tips.class);
                startActivity(intent);
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,alarm.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,MainActivity.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,MainActivity.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,Setting.class);
                startActivity(intent);
            }
        });



    }
        }


