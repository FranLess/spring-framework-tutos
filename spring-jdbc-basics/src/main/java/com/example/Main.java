package com.example;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JdbcAppConfig;
import com.example.dao.IStudentDAO;
import com.example.dao.StudentDAOImp;
import com.example.helper.JdbcHelper;
import com.example.model.Student;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcAppConfig.class);
        JdbcHelper jdbcHelper = context.getBean(JdbcHelper.class);
        IStudentDAO daoImp = context.getBean(IStudentDAO.class);
        // IntStream.range(0, 3).forEach(i -> {
        // jdbcHelper.initDataBase();
        // });

        Map<String, List<Student>> groups = daoImp.groupByGrade();
        for (Entry<String, List<Student>> group : groups.entrySet()) {
            System.out.println(group.getKey());
            for (Student student : group.getValue()) {
                System.out.println(student.toString());
            }
        }

        // Student updateStudent = new Student();
        // updateStudent.setIdStudent(104);
        // updateStudent.setStudentName("Francock");
        // updateStudent.setStudentLastname("Francock");
        // updateStudent.setStudentGrade(1);

        // Student updateStudent2 = new Student();
        // updateStudent2.setIdStudent(107);
        // updateStudent2.setStudentName("Francock");
        // updateStudent2.setStudentLastname("Francock");
        // updateStudent2.setStudentGrade(1);

        // Student updateStudent3 = new Student();
        // updateStudent3.setIdStudent(110);
        // updateStudent3.setStudentName("Francock");
        // updateStudent3.setStudentLastname("Francock");
        // updateStudent3.setStudentGrade(1);

        // List<Student> students = Arrays.asList(updateStudent, updateStudent2,
        // updateStudent3);

        // daoImp.update(students);
    }
}