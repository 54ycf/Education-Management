package com.ecnu.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseBo {
    private int courseId;
    private String name;
    private String type;
    private String department;
    private String teacher;
    private String title;
    private Integer credit;
    private String teacherNo;
    private String bigType;
}
