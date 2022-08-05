package com.example.becomefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class customexe extends AppCompatActivity {
Button b1;
EditText e1,e2;
RadioButton r1,r2;
CheckBox c1,c2,c3,c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customexe);
        b1=findViewById(R.id.button3);
        e1=findViewById(R.id.editTextTextPersonName5);
        e2=findViewById(R.id.editTextPhone);
        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);
        c1=findViewById(R.id.checkBox4);
        c2=findViewById(R.id.checkBox5);
        c3=findViewById(R.id.checkBox6);
        c4=findViewById(R.id.checkBox7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(customexe.this,customexe1.class);
                i.putExtra("name",e1.getText().toString());
                i.putExtra("age",Integer.parseInt(e2.getText().toString()));
//                String name =e1.getText().toString();
//                Integer age = Integer.parseInt(e2.getText().toString());
                if(c1.isChecked()){
                    String c11="abs";
                    i.putExtra("abs",c11);
                }
                else if(c2.isChecked()){
                    String c22="full";
                    i.putExtra("full",c22);
                }
                else if(c3.isChecked()){
                    String c33="leg";
                    i.putExtra("leg",c33);
                }
                else if(c4.isChecked()){
                    String c44="arm";
                    i.putExtra("arm",c44);
                }
                else{
                    Toast.makeText(customexe.this, "select check box", Toast.LENGTH_SHORT).show();
                }
                if(r1.isChecked()){
                    String r11 ="male";
                    i.putExtra("male",r11);
                }
                else if(r2.isChecked()){
                    String r22 ="female";
                    i.putExtra("femlae",r22);
                }
                else{
                    Toast.makeText(customexe.this, "Select radio box", Toast.LENGTH_SHORT).show();
                }
                startActivity(i);
            }
        });
    }
}