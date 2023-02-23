package com.example.myspace2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myspace2.Individual.Note;

public class NoteDataBaseHelper extends SQLiteOpenHelper {
    public NoteDataBaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }
    //表创建接口 有多张表时 方便统一调用
    public static interface TableCreateInterface {
        public void onCreate(SQLiteDatabase db);
        public void onUpdate(SQLiteDatabase db,int oldVersion, int newVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Note.getIntance().onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Note.getIntance().onUpdate(db,oldVersion,newVersion);
    }
}
