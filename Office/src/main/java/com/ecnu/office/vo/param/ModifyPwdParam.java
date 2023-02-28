package com.ecnu.office.vo.param;

import lombok.Data;

@Data
public class ModifyPwdParam {
    private String OfficeNo;
    private String oldPwd;
    private String newPwd;
}
