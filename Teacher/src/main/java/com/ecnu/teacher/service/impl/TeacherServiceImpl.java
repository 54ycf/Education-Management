package com.ecnu.teacher.service.impl;

import com.ecnu.bo.TeacherBo;
import com.ecnu.teacher.mapper.TeacherMapper;
import com.ecnu.teacher.service.TeacherService;
import com.ecnu.teacher.vo.TeacherVo;
import com.ecnu.teacher.vo.param.*;
import com.ecnu.vo.param.DepartmentYearParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper mapper;

    @Override
    public TeacherVo login(LoginParam loginParam) {
        return mapper.login(loginParam);
    }

    @Override
    public boolean changePwd(ModifyPwdParam modifyPwdParam) {
        return mapper.updatePwd(modifyPwdParam) > 0;
    }

    @Override
    public boolean changeInfo(ModifyInfoParam modifyInfoParam) {
        return mapper.updateInfo(modifyInfoParam) > 0;
    }

    @Override
    public List<TeacherVo> getDepartmentTeachers(DepartmentYearParam param) {
        return mapper.searchDepartmentTeachers(param);
    }

    @Override
    public boolean addTeacher(TeacherBo teacher) {
        if (mapper.getTeacherByNo(teacher.getTeacherNo())!=null) return false;
        teacher.setPassword("123456");
        return mapper.insertTeacher(teacher) > 0;
    }

    @Override
    public boolean modifyTeacher(TeacherBo teacher) {
        return mapper.modifyTeacher(teacher) > 0;
    }

    @Override
    public TeacherVo getTeacherByNo(String teacherNo) {
        return mapper.getTeacherByNo(teacherNo);
    }

    @Override
    public List<TeacherVo> getTeachersInfoByName(String key) {
        return mapper.getTeacherByName(key);
    }

    @Override
    public boolean dropTeacher(String teacherNo) {
        return mapper.deleteTeacher(teacherNo) > 0;
    }


}
