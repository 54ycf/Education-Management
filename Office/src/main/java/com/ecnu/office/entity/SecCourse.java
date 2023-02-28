package com.ecnu.office.entity;

import com.ecnu.bo.CourseBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecCourse {
    private CourseBo course;
    private Sections sections;
}
