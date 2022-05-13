package com.example.studentproject.dao;

import com.example.studentproject.Student;

import java.util.List;

public interface IStudentDao {
    public List<Student> getAll();

    public boolean insert(Student t);

    public boolean update(Student t);

    public Student getById(Integer id);

    public boolean deleteById(Integer id);
}
