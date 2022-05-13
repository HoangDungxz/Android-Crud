package com.example.studentproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentproject.Student;

import java.util.ArrayList;
import java.util.List;

public class ImplStudentDao implements IStudentDao {

    private SQLiteDatabase mDb;

    public ImplStudentDao(Context ctx) {
        DatabaseHelper databaseHelper = new DatabaseHelper(ctx);
        mDb = databaseHelper.getWritableDatabase();
    }

    @Override
    public List<Student> getAll() {
        String sql = "SELECT * FROM tblStudent";

        Cursor c = mDb.rawQuery(sql, null);

        List<Student> studentList = new ArrayList<>();
        while (c.moveToNext()) {
            Integer id = c.getInt(c.getColumnIndex("id"));
            String fullname = c.getString(c.getColumnIndex("fullname"));
            String phone = c.getString(c.getColumnIndex("phone"));
            String email = c.getString(c.getColumnIndex("email"));

            Student student = new Student(id, fullname, phone, email);

            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public boolean insert(Student t) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", t.getFullname());
        contentValues.put("phone", t.getPhone());
        contentValues.put("email", t.getEmail());

        long newID = mDb.insert("tblStudent", null, contentValues);
        if (newID > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Student s) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", s.getFullname());
        contentValues.put("phone", s.getPhone());
        contentValues.put("email", s.getEmail());

        long newID = mDb.update("tblStudent", contentValues, "id=?", new String[]{String.valueOf(s.getId())});
        if (newID > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student getById(Integer id) {
        String sql = "SELECT * FROM tblStudent WHERE id = ?";
        Cursor c = mDb.rawQuery(sql, new String[]{String.valueOf(id)});

        while (c.moveToNext()) {
            String fullname = c.getString(c.getColumnIndex("fullname"));
            String phone = c.getString(c.getColumnIndex("phone"));
            String email = c.getString(c.getColumnIndex("email"));
            Student student = new Student(id, fullname, phone, email);
            return student;
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        int row = mDb.delete("tblStudent", "id = ?", new String[]{String.valueOf(id)});
        if (row > 0) {
            return true;
        }
        return false;
    }
}
