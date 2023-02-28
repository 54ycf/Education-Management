package com.ecnu.office.service;

import com.ecnu.office.entity.*;
import com.ecnu.office.vo.OfficeVo;
import com.ecnu.office.vo.param.*;

import java.util.List;

public interface OfficeService {

    OfficeVo login(LoginParam loginParam);



    OfficeVo getMyInfo(String officeNo);

    boolean changeInfo(ModifyInfoParam param);

    boolean changePwd(ModifyPwdParam pwdParam);
}
