package com.example.becomefit;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class customexe1 extends AppCompatActivity {
    ListView listView;
    Button b1,b2;
    int idd;
    int count1;
    int h=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customexe1);
        b1=findViewById(R.id.button5);
        b2=findViewById(R.id.button8);
        Intent i= getIntent();
        String name1=i.getStringExtra("name");
        int age1=i.getIntExtra("age",0);
        String abs1=i.getStringExtra("abs");
        String full1=i.getStringExtra("full");
        String leg1=i.getStringExtra("leg");
        String arm1=i.getStringExtra("arm");
        String male1=i.getStringExtra("male");
        String femlae1=i.getStringExtra("female");
        Toast.makeText(this, "ok"+name1, Toast.LENGTH_SHORT).show();
        ok db=new ok(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=0;
                String name="";
                int age=0;
                String gender="";
                String type="";
                Cursor cursor=db.SelectData();
                while (cursor.moveToNext()) {
                    id = cursor.getInt(0);
                    name = cursor.getString(1);
                    age = cursor.getInt(2);
                    gender = cursor.getString(3);
                    type = cursor.getString(4);
                    int z = 0;
                    if (name.equals(name1)) {
                        idd=id;
                        count1=z+1;
                    }

                    if(age==age1){
                        idd=id;
                        count1=count1+1;
                    }

                    if (gender.equals(male1)){
                        idd=id;
                        count1=count1+1;

                    }

                    if(gender.equals(femlae1)){
                        idd=id;
                        count1=count1+1;
                    }
                    if (type.equals(abs1)){
                        idd=id;
                        count1=count1+1;
                    }
                    if(type.equals(full1)){
                        idd=id;
                        count1=count1+1;
                    }
                    if (type.equals(leg1)){
                        idd=id;
                        count1=count1+1;
                    }
                    if(type.equals(arm1)){
                        idd=id;
                        count1=count1+1;
                    }

                    int count = count1;
                    int stid = idd;
                    db.insertData1(count, stid);
                    Toast.makeText(customexe1.this, "Inset successfully", Toast.LENGTH_LONG).show();
                    count1=0;
                    idd=0;
                }

            }
        });
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent ii = new Intent(customexe1.this,fetch.class);
        startActivity(ii);
    }
});
    }
}