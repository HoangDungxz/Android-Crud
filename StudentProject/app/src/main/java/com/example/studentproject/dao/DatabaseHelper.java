package com.example.studentproject.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contact.SQLite";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tblStudent (\n" +
                "    id       INTEGER      PRIMARY KEY AUTOINCREMENT,\n" +
                "    fullname VARCHAR (50) NOT NULL,\n" +
                "    phone    VARCHAR (11),\n" +
                "    email    VARCHAR (50) \n" +
                ");\n";
        db.execSQL(sql);

        sql = "INSERT INTO tblStudent(fullname,phone,email) VALUES ('Vương Thị Thúy','0123456789','thuy@gmail.com')";
        db.execSQL(sql);
        sql = "INSERT INTO tblStudent(fullname,phone,email) VALUES ('Hoang Trung Dung','0123456789','dung@gmail.com')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
