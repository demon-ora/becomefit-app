package com.example.becomefit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.UUID;

public class upload extends AppCompatActivity {
EditText e1,e2,e3;
Button b1;
    private final int Imageback=1;
    StorageReference Folder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        e1=findViewById(R.id.editTextTextPersonName2);
        e2=findViewById(R.id.editTextTextPersonName3);
        e3=findViewById(R.id.editTextTextPersonName4);
        b1=findViewById(R.id.button4);
       Folder = FirebaseStorage.getInstance().getReference().child("image");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
              intent.setType("image/*");
              startActivityForResult(intent,Imageback);
            }
        });

//b2.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//
//        HashMap<String,String> m =new HashMap<>();
//        m.put("name",e1.getText().toString());
//        m.put("type",e2.getText().toString());
//        m.put("des",e3.getText().toString());
//        FirebaseDatabase.getInstance().getReference().child("data").push().setValue(m);
//    }
//});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== Imageback){
            if(resultCode==RESULT_OK){
                final ProgressDialog p =new ProgressDialog(upload.this);
                p.setTitle("uploading");
                p.show();
                Uri ImageData = data.getData();
                StorageReference Imagename = Folder.child("image"+ImageData.getLastPathSegment());
                Imagename.putFile(ImageData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(upload.this, "ok", Toast.LENGTH_SHORT).show();
                        Imagename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                DatabaseReference imagestore =FirebaseDatabase.getInstance().getReference().child("data");
                                HashMap<String,String> m =new HashMap<>();
                                m.put("name",e1.getText().toString());
                                m.put("type",e2.getText().toString());
                                m.put("des",e3.getText().toString());
                                m.put("imageurl", String.valueOf(uri));
                                imagestore.push().setValue(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        p.dismiss();
                                        Toast.makeText(upload.this, "comp", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }
                        });
                    }
                });
            }
        }
    }
}