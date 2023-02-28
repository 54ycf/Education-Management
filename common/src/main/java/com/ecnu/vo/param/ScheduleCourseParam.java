package com.ecnu.vo.param;

import lombok.Data;

@Data
public class ScheduleCourseParam {
    private Integer secCourseId;
    private String years;
    private int semester;
    private int courseId;
    private String day;
    private String order;
    private String classroom;
    private String gradeYear;
    private int limitNum;
}
