package com.example.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myList.db";
    private static final String TABLE_NAME = "myList_data";
    public static final String Col1 = "ID";
    public static final String Col2 = "ITEM1";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "Create Table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "ITEM1 TEXT)";
        db.execSQL(createTable);
       // String Table = "Create Table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "ID TEXT)";
       // db.execSQL(Table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean addData(String item1) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       // contentValues.put(Col1, id);
        contentValues.put(Col2, item1);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    

    public Cursor getListContents() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor data = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}
