package com.example.khabo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME= "khabo.db";

    public DBHelper(Context context) {
        super(context,"khabo.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT, useremail TEXT primary key, userpassword TEXT,userphone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");

    }
    public boolean inserdata(String username,String useremail,String userpassword,String userphone){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("useremail",useremail);
        contentValues.put("userpassword",userpassword);
        contentValues.put("userphone",userphone);
        long result=MyDB.insert("users",null,contentValues);
        if (result==-1) return false;
        else
            return true;
    }
    public boolean checkuseremail(String useremail){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where useremail = ?",new String[]{useremail});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkusernamepassword(String username,String userpassword){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username = ? and userpassword = ?",new String[]{username,userpassword});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
