package com.example.becomefit;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class fetch extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        b1=findViewById(R.id.button6);
        ok db = new ok(this);
        Cursor cursor = db.SelectData1();
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            buffer.append("name= "+cursor.getString(0)+"\n");
            buffer.append("age= "+cursor.getInt(1)+"\n");
            buffer.append("count= "+cursor.getInt(2)+"\n");
        }
        AlertDialog.Builder builder =new AlertDialog.Builder(fetch.this);
        builder.setCancelable(true);
        builder.setTitle("something");
        builder.setMessage(buffer.toString());
        builder.show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteData();
            }
        });
    }
}