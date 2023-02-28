package com.ecnu.office.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    private int courseId;
    private int secId;
    private Student student;
    private double usualScore;
    private double finalScore;
    private double totalScore;
    private String levels;
    private double point;
}
