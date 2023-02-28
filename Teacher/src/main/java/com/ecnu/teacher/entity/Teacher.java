package com.ecnu.teacher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int id;
    private String teacherNumber;
    private String name;
    private String password;
    private String sex;
    private String department;
    private String title;
    private String email;
    private String phone;
    private Date inDate;
}
