package com.kmtstudio.sqlitedatabasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Student";
    private static final String TABLE_NAME = "student_details";
    private static final String ID = "_Id";
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";
    private static final int VERSION_NUMBER = 3;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+AGE+" INTEGER, "+GENDER+" VARCHAR(15))";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    private Context context;

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Toast.makeText(context,"onCreate is called",Toast.LENGTH_LONG).show();
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context,"onUpgrade is called",Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
        }
    }
}
