package com.example.studentproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Toast;

import com.example.studentproject.dao.IStudentDao;
import com.example.studentproject.dao.ImplStudentDao;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        Integer id = null;
        if (b != null) {
            id = (Integer) b.get("id");
        }

        IStudentDao iStudentDao = new ImplStudentDao(this);
        boolean isOk = iStudentDao.deleteById(id);

        if (isOk) {
            Toast.makeText(this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Xoa that bai", Toast.LENGTH_SHORT).show();
        }

    }
}