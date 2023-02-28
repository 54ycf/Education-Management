package com.ecnu.bo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TeacherBo {
    private String teacherNo;
    private String password;
    private String name;
    private String sex;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date inDate;
    private String department;
    private String email;
    private String phone;

}
