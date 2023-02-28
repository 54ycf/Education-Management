package com.ecnu.course.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecCourseVo {

    //查找某学期的课程
    private int secCourseId;

    private int courseId;
    private String name;//课程名称
    private String type;
    private String department;
    private String teacher;
    private String title;
    private String day;
    private String order; //day order 表示星期几第几节课
    private String classroom;
    private int credit;
    private String teacherNo;
    private String bigType;

    private int limitNum;
    private int actualNum;

    private String years;
    private String semester;
}