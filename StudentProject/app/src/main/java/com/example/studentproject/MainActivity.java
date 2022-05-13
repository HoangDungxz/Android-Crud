package com.example.studentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.studentproject.adapter.AdapterStudent;
import com.example.studentproject.dao.IStudentDao;
import com.example.studentproject.dao.ImplStudentDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadContact();
    }

    private void LoadContact() {
        IStudentDao studentDao = new ImplStudentDao(this);
        List<Student> lst = studentDao.getAll();

        AdapterStudent adapterStudent = new AdapterStudent(this, lst);


        ListView listView = findViewById(R.id.listStudent);
        listView.setAdapter(adapterStudent);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, UpdateContextActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadContact();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menuAdd:
                Intent intent = new Intent(this, AddNewActivity.class);
                startActivity(intent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
