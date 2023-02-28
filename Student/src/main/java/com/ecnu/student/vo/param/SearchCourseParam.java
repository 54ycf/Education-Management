package com.ecnu.student.vo.param;

import lombok.Data;

@Data
public class SearchCourseParam {
    private int stuId;
    private String year;
    private String semester;
}
