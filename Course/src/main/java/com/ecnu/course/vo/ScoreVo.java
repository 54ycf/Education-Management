package com.ecnu.course.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreVo {

    /*学生查看自己的成绩*/
    private int secCourseId;
    private String years;
    private String semester;
    private int courseId;
    private String name;
    private String type;
    private int credit;
    private double usualScore;
    private double finalScore;
    private double totalScore;
    private String levels;
    private double point;

    private String scoreStatus;
}
