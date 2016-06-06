package com.example.testgallery.testsqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper db;

    //Generic info
    private static final String DATABASE_NAME = "sqlitedb.sqlite";
    private static final int DATABASE_VERSION = 1;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(Context cx) {
        if(db == null){
            db = new DatabaseHelper(cx.getApplicationContext());
        }
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String CREATE_DATABASE = "CREATE TABLE pets (_id INTEGER PRIMARY, name TEXT)";
        sqLiteDatabase.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }
}
