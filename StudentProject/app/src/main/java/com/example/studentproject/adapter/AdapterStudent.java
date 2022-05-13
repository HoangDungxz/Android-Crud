package com.example.studentproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentproject.DeleteActivity;
import com.example.studentproject.MainActivity;
import com.example.studentproject.R;
import com.example.studentproject.Student;
import com.example.studentproject.UpdateContextActivity;
import com.example.studentproject.dao.IStudentDao;
import com.example.studentproject.dao.ImplStudentDao;

import java.util.List;


public class AdapterStudent extends ArrayAdapter<Student> {

    private Context context;
    private List<Student> studentList;

    public AdapterStudent(@NonNull Context context, @NonNull List<Student> studentList) {
        super(context, R.layout.item_student, studentList);

        this.context = context;
        this.studentList = studentList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View v = convertView;

        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_student, null);
        }

        Student s = studentList.get(position);

        TextView edtFullName = v.findViewById(R.id.itemfullname);
        TextView edtPhone = v.findViewById(R.id.itemphone);
        TextView edtEmail = v.findViewById(R.id.itememail);

        ImageView btnUpdate = v.findViewById(R.id.itemBtnUpdate);
        ImageView btnDelete = v.findViewById(R.id.itemBtnDelete);

        edtFullName.setText(s.getFullname());
        edtPhone.setText(s.getPhone());
        edtEmail.setText(s.getEmail());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateContextActivity.class);
                int id = studentList.get(position).getId();
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DeleteActivity.class);
                int id = studentList.get(position).getId();
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });
        return v;

    }
}
