package com.example.becomefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {
 EditText name,password;
 Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        name=findViewById(R.id.editTextTextPersonName);
        password=findViewById(R.id.editTextTextPassword);
        b1=findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1= name.getText().toString();
                String password1 = password.getText().toString();
                if(name1.equals("elon") && password1.equals("upload")){
                    Intent intent = new Intent(loginpage.this,upload.class);
                    startActivity(intent);
                }
                else if(name1.equals("celon") && password1.equals("baby")){
                    Intent intent = new Intent(loginpage.this,sqldata.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(loginpage.this, "only admin can enter", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}