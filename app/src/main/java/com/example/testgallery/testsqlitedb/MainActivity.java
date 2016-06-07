package com.example.testgallery.testsqlitedb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper db = DatabaseHelper.getInstance(this);
/*        SQLiteDatabase sql = db.getWritableDatabase();
        ContentValues conV = new ContentValues();
        conV.put("name","bau");
        long rows = sql.insert("pets", "name", conV);*/

        SQLiteDatabase dbCon = db.getReadableDatabase();
        Cursor cur = dbCon.rawQuery("SELECT name FROM pets", null);
        cur.moveToFirst();
        String nome = cur.getString(0);

        cur.close();

        ((TextView)findViewById(R.id.idDb)).setText(nome);
    }
}
