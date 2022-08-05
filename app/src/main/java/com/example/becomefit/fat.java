package com.example.becomefit;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class fat extends AppCompatActivity {
EditText e1,e2,e3;
TextView t1;
CheckBox c1,c2;
    Double height,weight,bmi,age,fatper;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat);
        e1=findViewById(R.id.editTextTextPersonName8);
        e2=findViewById(R.id.editTextTextPersonName9);
        e3=findViewById(R.id.editTextTextPersonName10);
        t1=findViewById(R.id.result1);
        c1=findViewById(R.id.checkBox3);
        c2=findViewById(R.id.checkBox2);
        b1=findViewById(R.id.submitvalue);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = Double.parseDouble(e1.getText().toString());
                height = Double.parseDouble(e2.getText().toString());
                age =Double.parseDouble(e3.getText().toString());
                bmi = (weight/(height*height));
         if(c1.isChecked()){
             fatper = (((1.20*bmi)+(0.23*age))-16.4);
     t1.setText(Double.toString(fatper));
         }
         else if(c2.isChecked()){
             fatper=(((1.20*bmi)+(0.23*age))-5.2);
         t1.setText(Double.toString(fatper));
         }

            }
        });
    }
}