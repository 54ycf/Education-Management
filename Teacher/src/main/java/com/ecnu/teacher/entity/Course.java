package com.ecnu.teacher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int cid;
    private String name;
    private String type;
    private String department;
    private String teacher;
    private String title;
    private String time;
    private String classroom;
    private int credit;
    private int teacherId;
}
