package com.ecnu.teacher.service;


import com.ecnu.bo.TeacherBo;
import com.ecnu.teacher.vo.TeacherVo;
import com.ecnu.teacher.vo.param.*;
import com.ecnu.vo.param.DepartmentYearParam;

import java.util.List;

public interface TeacherService {

    TeacherVo login(LoginParam loginParam);

    boolean changePwd(ModifyPwdParam modifyPwdParam);

    boolean changeInfo(ModifyInfoParam modifyInfoParam);


    List<TeacherVo> getDepartmentTeachers(DepartmentYearParam param);

    boolean addTeacher(TeacherBo teacher);

    boolean modifyTeacher(TeacherBo teacher);

    TeacherVo getTeacherByNo(String teacherNo);

    List<TeacherVo> getTeachersInfoByName(String key);

    boolean dropTeacher(String teacherNo);
}
