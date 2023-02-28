package com.ecnu.student.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {

    private int stuId;
    private Course course;
    private Sections sections;
    private double usualScore;
    private double finalScore;
    private double totalScore;
    private String levels;
    private double point;
}
