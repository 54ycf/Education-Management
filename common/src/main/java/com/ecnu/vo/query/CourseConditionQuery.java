package com.ecnu.vo.query;

import lombok.Data;

@Data
public class CourseConditionQuery {
    private String gradeYear;
    private String department;
    private Integer semester;
    private String years;
    private Integer courseId;
    private String name;
    private Integer credit;
    private String teacher;
}
