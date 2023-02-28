package com.ecnu.bo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseScoreBo {
    private int secCourseId;

    private int courseId;

    /*student*/
    private String name;
    private String stuNo;


    private double usualScore;
    private double finalScore;
    private double totalScore;
    private String levels;
    private double point;

    /*sections*/
    private String years;
    private String semester;

    private String scoreStatus;
}
