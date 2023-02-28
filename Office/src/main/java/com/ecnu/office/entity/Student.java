package com.ecnu.office.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String sex;
    private String stuNumber;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date inDate;
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date outDate;
    private String department;
    private String email;
    private String phone;
}
