package com.example.testgallery.testsqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper db = null;

    //Generic info
    private static final String DATABASE_NAME = "sqlitedb.sqlite";
    private static final int DATABASE_VERSION = 5;

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
        final String CREATE_DATABASE = "CREATE TABLE pets (pets_id INTEGER PRIMARY KEY, name TEXT)";
        //final String INSERT_PET = "INSET INTO pets (name) VALUES(\"Bau\");";
        try {
            sqLiteDatabase.execSQL(CREATE_DATABASE);

        }catch(SQLiteException s) { s.fillInStackTrace();}
        //sqLiteDatabase.execSQL(INSERT_PET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        final String DROP_DATABASE = "DROP TABLE IF EXISTS pets";
        sqLiteDatabase.execSQL(DROP_DATABASE);
        onCreate(sqLiteDatabase);
    }
}
