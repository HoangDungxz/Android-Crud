package com.example.studentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.studentproject.dao.IStudentDao;
import com.example.studentproject.dao.ImplStudentDao;


public class UpdateContextActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle b = getIntent().getExtras();
        Integer id = null;
        if (b != null) {
            id = (Integer) b.get("id");
        }
        IStudentDao iStudentDao = new ImplStudentDao(this);

        Student student = iStudentDao.getById(id);


        View v = LayoutInflater.from(this).inflate(R.layout.activity_update_context, null);

        EditText idInput = v.findViewById(R.id.itemId);
        idInput.setEnabled(false);
        idInput.setText(student.getId().toString());

        EditText fullNameInput = v.findViewById(R.id.itemfullname);
        fullNameInput.setText(student.getFullname());

        EditText phoneInput = v.findViewById(R.id.itemphone);
        phoneInput.setText(student.getPhone());

        EditText emailInput = v.findViewById(R.id.itememail);
        emailInput.setText(student.getEmail());

        super.onCreate(savedInstanceState);
        setContentView(v);
    }

    public void actionUpdate(View view) {

        EditText edtid = findViewById(R.id.itemId);
        EditText edtFullName = findViewById(R.id.itemfullname);
        EditText edtPhone = findViewById(R.id.itemphone);
        EditText edtEmail = findViewById(R.id.itememail);

        Integer id = Integer.parseInt(edtid.getText().toString());
        String fullname = edtFullName.getText().toString();
        String phone = edtPhone.getText().toString();
        String email = edtEmail.getText().toString();

        Student s = new Student(id, fullname, phone, email);

        IStudentDao iStudentDao = new ImplStudentDao(this);
        boolean isOk = iStudentDao.update(s);

        if (isOk) {
            Toast.makeText(this, "Sua thanh cong", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sua that bai", Toast.LENGTH_SHORT).show();
        }
    }
}