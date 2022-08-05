package com.example.becomefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sqldata extends AppCompatActivity {
    EditText edtid,edtname,edtage,edtype,edtgender;
    Button btn,bt1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqldata);
        edtid=findViewById(R.id.idd);
        edtname=findViewById(R.id.editTextTextPersonName2);
        edtage=findViewById(R.id.editTextNumber);
        edtype=findViewById(R.id.editTextTextPersonName4);
        edtgender=findViewById(R.id.editTextTextPersonName3);
        btn=findViewById(R.id.button);
        bt1=findViewById(R.id.button2);
        t1=findViewById(R.id.textView);
        ok db=new ok(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(edtid.getText().toString());
                int agee=Integer.parseInt(edtage.getText().toString());
                db.insertData(id,edtname.getText().toString(),agee,edtgender.getText().toString(),edtype.getText().toString());
                Toast.makeText(sqldata.this,"Inset successfully",Toast.LENGTH_LONG).show();
                edtid.setText("");
                edtname.setText("");
            }   });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=0;
                String name="";
                int age=0;
                String gender="";
                String type="";
                Cursor cursor=db.SelectData();
                while (cursor.moveToNext()){
                    id=cursor.getInt(0);
                    name=cursor.getString(1);
                    age=cursor.getInt(2);
                    gender=cursor.getString(3);
                    type=cursor.getString(4);
                }
                t1.setText("ID="+id+"Name="+name+"age="+age+"gender="+gender+"type="+type);
            }
        });
    }
}