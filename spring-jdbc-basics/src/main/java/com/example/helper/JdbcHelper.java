package com.example.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IStudentDAO;
import com.example.model.Student;

@Service
public class JdbcHelper {
    @Autowired
    private IStudentDAO studentDao;

    public void initDataBase() {
        Student student1 = new Student();
        student1.setStudentName("Fran");
        student1.setStudentLastname("Martínez");
        student1.setStudentGrade(2);

        Student student2 = new Student();
        student2.setStudentName("Aaron");
        student2.setStudentLastname("Martínez");
        student2.setStudentGrade(3);

        Student student3 = new Student();
        student3.setStudentName("Laura");
        student3.setStudentLastname("Martínez");
        student3.setStudentGrade(1);

        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        studentDao.save(students);
    }

}
