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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class exeabs extends AppCompatActivity {
    ListView listView;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exeabs);
        listView=findViewById(R.id.listview);
        b1=findViewById(R.id.button5);
        ArrayList<String> a = new ArrayList<>();
        ArrayAdapter<String> adapter =new ArrayAdapter<>(exeabs.this,R.layout.item,a);
        listView.setAdapter(adapter);
        FirebaseDatabase.getInstance().getReference().child("data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    a.clear();
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        data i = snapshot1.getValue(data.class);
                        if(i.getType().equals("abs")) {
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
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(exeabs.this,abs1.class);
                startActivity(intent);
            }
        });
    }
    }
