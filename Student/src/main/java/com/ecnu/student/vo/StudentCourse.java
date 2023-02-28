package com.ecnu.student.vo;

import lombok.Data;

@Data
public class StudentCourse {
    private int id;
    private String name;
    private String type;
    private int credit;
    private String teacher;
    private String title;

}
