package com.ecnu.student.vo.param;

import lombok.Data;

@Data
public class ModifyPwdParam {
    private String stuNo;
    private String oldPwd;
    private String newPwd;
}
