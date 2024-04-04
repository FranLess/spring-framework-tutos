package com.example.model;

import lombok.Getter;
import lombok.Setter;

public class Student {
    @Setter
    @Getter
    private Integer idStudent;
    @Getter
    @Setter
    private String studentName;
    @Getter
    @Setter
    private String studentLastname;
    @Getter
    @Setter
    private int studentGrade;

    @Override
    public String toString() {
        return "Student [idStudent=" + idStudent + ", studentName=" + studentName + ", studentLastName="
                + studentLastname + ", studentGrade=" + studentGrade + "]";
    }

}
