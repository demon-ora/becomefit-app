package com.example.becomefit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class exelegs extends AppCompatActivity {
ListView listView;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exelegs);
        listView=findViewById(R.id.listview);
        b1=findViewById(R.id.button5);
        ArrayList<String> a = new ArrayList<>();
        ArrayAdapter<String> adapter =new ArrayAdapter<>(exelegs.this,R.layout.item,a);
        listView.setAdapter(adapter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(exelegs.this,legs1.class);
                startActivity(intent);
            }
        });
        FirebaseDatabase.getInstance().getReference().child("data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    a.clear();
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        data i = snapshot1.getValue(data.class);
                        if(i.getType().equals("leg")) {
                            String t = i.getName() + ":" + i.getType();
                            a.add(t);
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    }
