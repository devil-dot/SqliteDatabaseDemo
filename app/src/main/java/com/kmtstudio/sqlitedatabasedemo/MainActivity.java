package com.kmtstudio.sqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase liteDatabase = dbHelper.getWritableDatabase();

    }
}