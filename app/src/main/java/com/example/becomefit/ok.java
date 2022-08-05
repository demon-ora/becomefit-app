package com.example.becomefit;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ok extends SQLiteOpenHelper {
    private static final String Database_name = "power";
    String query;
    String query1;

    public ok(@Nullable Context context) {

        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE man(id INTEGER PRIMARY KEY,name TEXT,age INTEGER,gender TEXT,type TEXT)";
        String query1 ="CREATE TABLE man1(id INTEGER PRIMARY KEY AUTOINCREMENT,count INTEGER,stid INTEGER , FOREIGN KEY(stid) REFERENCES man (id))";
        db.execSQL(query);
        db.execSQL(query1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + query);
        db.execSQL("DROP TABLE IF EXISTS " + query1);
        onCreate(db);

    }
    public void insertData(int id,String name,int age,String gender,String type)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("age",age);
        contentValues.put("gender",gender);
        contentValues.put("type",type);
        db.insert("man",null,contentValues);
        db.close();    }

    public void insertData1(int count,int stid)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("count",count);
        contentValues.put("stid",stid);
        db.insert("man1",null,contentValues);
        db.close();    }


    public Cursor SelectData(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM man";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }

    public Cursor SelectData1(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT man.name as name,man.age as age,man1.count as count FROM man1 INNER JOIN man ON man1.stid=man.id ORDER BY count desc";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }
    public void deleteData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM man1");
    }

}