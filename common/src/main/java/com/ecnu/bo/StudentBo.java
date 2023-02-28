package com.ecnu.bo;

import lombok.Data;

import java.util.Date;


@Data
public  class StudentBo {

    private String stuNo;
    private String name;
    private String password;
    private String sex;
    private String department;
    private String email;
    private String phone;
    private Date inDate;
    private Date outDate;
    private String dateYear;

}

