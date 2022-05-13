package com.example.studentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentproject.dao.IStudentDao;
import com.example.studentproject.dao.ImplStudentDao;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
    }

    public void actionAdd(View v) {
        EditText edtFullName = findViewById(R.id.itemfullname);
        EditText edtPhone = findViewById(R.id.itemphone);
        EditText edtEmail = findViewById(R.id.itememail);

        String fullname = edtFullName.getText().toString();
        String phone = edtPhone.getText().toString();
        String email = edtEmail.getText().toString();

        Student s = new Student(fullname, phone, email);

        IStudentDao iStudentDao = new ImplStudentDao(this);
        boolean isOk = iStudentDao.insert(s);

        if (isOk) {
            Toast.makeText(this, "Them moi thanh cong", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Them moi that bai", Toast.LENGTH_SHORT).show();
        }

//        Intent intent = new Intent(this, DeleteActivity.class);
        
    }


}
