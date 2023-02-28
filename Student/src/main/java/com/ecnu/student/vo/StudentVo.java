package com.ecnu.student.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo {
    private String stuNo;
    private String name;
    private String sex;
    private String department;
    private Date inDate;
    private Date outDate;
    private String email;
    private String phone;
    private String gradeYear;
}