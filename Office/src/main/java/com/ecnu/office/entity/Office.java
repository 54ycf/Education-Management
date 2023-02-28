package com.ecnu.office.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {

    private String officeNumber;
    private String name;
    private String password;
    private String sex;
    private String department;
    private String gradeYear;
    private String email;
    private String phone;
    private String inDate;
}
