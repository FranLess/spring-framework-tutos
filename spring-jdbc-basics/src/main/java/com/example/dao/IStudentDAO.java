package com.example.dao;

import java.util.List;
import java.util.Map;

import com.example.model.Student;

public interface IStudentDAO { 
    int deleteById(int id);

    int save(Student student);

    int[] save(List<Student> students);

    int[] update(List<Student> students);

    Student findById(int id);

    List<Student> findByGrade(int grade);

    List<Student> findAll();

    void truncateTable(String table);

    Map<String, List<Student>> groupByGrade();
}
