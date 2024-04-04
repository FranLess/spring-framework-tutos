package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Student;

//This Bean is defined in the config file due to Implementation of @Transactional proxy
// This creates conflic with the direct type of StudentDAOImp so it has to be defined
// As the interface type (IStudentDAO)
public class StudentDAOImp implements IStudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM student where id_student = ?";
        int rowsUpdated = jdbcTemplate.update(sql, id);
        return rowsUpdated;
    }

    @Override
    public int save(Student student) {
        String sql = "INSERT INTO student values(null, ?,?,?)";
        Object[] args = { student.getStudentName(), student.getStudentLastname(), student.getStudentGrade() };
        int rowsUpdated = jdbcTemplate.update(sql, args);
        return rowsUpdated;
    }

    @Override
    @Transactional
    public int[] save(List<Student> students) {
        String sql = "INSERT INTO student values(null, ?,?,?)";
        List<Object[]> studentsValues = new ArrayList<Object[]>();
        for (Student student : students) {
            Object[] args = { student.getStudentName(), student.getStudentLastname(), student.getStudentGrade() };
            studentsValues.add(args);
        }
        int[] rowsUpdated = jdbcTemplate.batchUpdate(sql, studentsValues);
        System.out.println("STUDENTS SAVED");
        return rowsUpdated;

    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM student WHERE id_student = ?";

        Student student = null;
        try {

            student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
        } catch (Exception e) {
            System.err.println("Student not found");
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public List<Student> findByGrade(int grade) {
        String sql = "SELECT * FROM student WHERE student_grade = ?";
        List<Student> student = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), grade);
        return student;
    }

    @Override
    public void truncateTable(String table) {
        // List of allowed table names
        List<String> allowedTables = Arrays.asList("student", "table2", "table3");

        if (allowedTables.contains(table)) {
            String sql = "DELETE FROM " + table;
            jdbcTemplate.execute(sql);
        } else {
            throw new IllegalArgumentException("Invalid table name");
        }
    }

    @Override
    public Map<String, List<Student>> groupByGrade() {
        Map<String, List<Student>> grades = new HashMap<>();
        List<Student> students = findAll();
        for (Student student : students) {
            grades.computeIfAbsent(
                    String.valueOf(student.getStudentGrade()),
                    k -> new ArrayList<Student>())
                    .add(student);
        }
        return grades;
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    @Transactional
    public int[] update(List<Student> students) {
        String sql = "UPDATE student SET student_name = ?, student_lastname = ?, student_grade = ? WHERE id_student = ?";
        int[] rowsUpdated = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, students.get(i).getStudentName());
                ps.setString(2, students.get(i).getStudentLastname());
                ps.setInt(3, students.get(i).getStudentGrade());
                ps.setInt(4, students.get(i).getIdStudent());
            }

            @Override
            public int getBatchSize() {
                return students.size();
            }

        });
        return rowsUpdated;
    }

}
