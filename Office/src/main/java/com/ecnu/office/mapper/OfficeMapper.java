package com.ecnu.office.mapper;


import com.ecnu.bo.CourseBo;
import com.ecnu.office.entity.*;
import com.ecnu.office.vo.OfficeVo;
import com.ecnu.office.vo.param.*;
import com.ecnu.vo.query.CourseConditionQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OfficeMapper {




    //登录
    @Select("select * from office where office_no=#{officeNo} and password=#{password} limit 1")
    OfficeVo login(LoginParam loginParam);



    @Select("select * from office where office_no=#{officeNo}")
    OfficeVo getOfficeInfoByNo(String officeNo);

    @Update("update office set phone=#{phone}, email=#{email} where office_no=#{officeNo}")
    int updateInfo(ModifyInfoParam param);

    //修改密码
    @Update("update office set password=#{newPwd} where office_no=#{officeNo} and password=#{oldPwd}")
    int updatePwd(ModifyPwdParam pwdParam);
}
