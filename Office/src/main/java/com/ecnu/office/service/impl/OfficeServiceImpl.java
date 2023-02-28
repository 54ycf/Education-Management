package com.ecnu.office.service.impl;

import com.ecnu.office.entity.*;
import com.ecnu.office.mapper.OfficeMapper;
import com.ecnu.office.service.OfficeService;
import com.ecnu.office.vo.OfficeVo;
import com.ecnu.office.vo.param.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeMapper mapper;

    @Override
    public OfficeVo login(LoginParam loginParam) {
        return mapper.login(loginParam);
    }






    @Override
    public OfficeVo getMyInfo(String officeNo) {
        return mapper.getOfficeInfoByNo(officeNo);
    }

    @Override
    public boolean changeInfo(ModifyInfoParam param) {
        return mapper.updateInfo(param) > 0;
    }

    @Override
    public boolean changePwd(ModifyPwdParam pwdParam) {
        return mapper.updatePwd(pwdParam) > 0;
    }

}
