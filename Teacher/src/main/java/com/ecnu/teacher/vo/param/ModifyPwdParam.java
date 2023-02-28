package com.ecnu.teacher.vo.param;

import lombok.Data;

@Data
public class ModifyPwdParam {
    private String teacherNo;
    private String oldPwd;
    private String newPwd;
}
