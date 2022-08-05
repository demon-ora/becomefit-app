package com.example.becomefit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class mr extends AppCompatActivity {
EditText e1;
Button b1;
TextView t1;
Double weight,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mr);
        t1=findViewById(R.id.result1);
        e1 =findViewById(R.id.editTextTextPersonName8);
        b1=findViewById(R.id.submitvalue);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight=Double.parseDouble(e1.getText().toString());
                result=((weight*1.1307)+0.6998);
                t1.setText(Double.toString(result));
            }
        });
    }
}