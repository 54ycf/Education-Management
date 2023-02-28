package com.ecnu.vo.param;

import lombok.Data;

@Data
public class SetScoreParam {

    private String stuNo;
    private int secCourseId;
    private double usualScore;
    private double finalScore;
}
