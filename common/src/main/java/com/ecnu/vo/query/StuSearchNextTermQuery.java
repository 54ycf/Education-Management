package com.ecnu.vo.query;

import lombok.Data;

@Data
public class StuSearchNextTermQuery {
    private String stuNo;
    private String department;
    private String gradeYear;
    private String years;
    private Integer semester;
}
