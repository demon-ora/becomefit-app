package com.example.becomefit;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmi extends AppCompatActivity {
    EditText e1,e2;
    TextView t1,t2;
    Button b1;
    Double height,weight,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        e1=findViewById(R.id.editTextTextPersonName8);
        e2=findViewById(R.id.editTextTextPersonName9);
        t1=findViewById(R.id.result1);
        t2 =findViewById(R.id.textView13);
        b1=findViewById(R.id.submitvalue);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               weight = Double.parseDouble(e1.getText().toString());
           height = Double.parseDouble(e2.getText().toString());
                bmi = (weight/(height*height));
          t1.setText(Double.toString(bmi));
          if(bmi > 25){
              t2.setText("you are fat");
          }
          else if(bmi<25 && bmi>18){
              t2.setText("you are healthy");
          }
          else
              t2.setText("you are thin");
            }
        });
    }
}