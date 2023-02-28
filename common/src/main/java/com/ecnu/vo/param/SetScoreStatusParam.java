package com.ecnu.vo.param;

import lombok.Data;

@Data
public class SetScoreStatusParam {
    private String stuNo;
    private int secCourseId;
    private String scoreStatus;
}
