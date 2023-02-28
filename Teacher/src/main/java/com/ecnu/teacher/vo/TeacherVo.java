package com.ecnu.teacher.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TeacherVo {
    private String teacherNo;
    private String name;
    private String sex;
    private String department;
    private String title;
    private String email;
    private String phone;
    private Date inDate;
}
