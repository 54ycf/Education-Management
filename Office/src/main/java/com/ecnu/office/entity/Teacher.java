package com.ecnu.office.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int id;
    private String name;
    private String sex;
    private String teacherNumber;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date inDate;
    private String department;
    private String email;
    private String phone;

}
