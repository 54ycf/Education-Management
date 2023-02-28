package com.ecnu.student.service.impl;

import com.ecnu.bo.StudentBo;
import com.ecnu.student.vo.StudentVo;
import com.ecnu.student.mapper.StudentMapper;
import com.ecnu.student.service.StudentService;
import com.ecnu.student.vo.param.*;
import com.ecnu.vo.param.DepartmentYearParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper mapper;

    @Override
    public StudentVo login(LoginParam loginParam) {
        return mapper.login(loginParam);
    }

    @Override
    public boolean changePwd(ModifyPwdParam param) {
        return mapper.updatePwd(param) > 0;
    }

    @Override
    public boolean changeInfo(ModifyInfoParam param) {
        return mapper.updateInfo(param) > 0;
    }

    @Override
    public List<StudentVo> getStudentInfo(List<String> stuNos) {
        List<StudentVo> result = new ArrayList<>();
        stuNos.forEach(item -> result.add(mapper.getStudentInfoByNo(item)));
        return result;
    }

    @Override
    public StudentVo getMyInfo(String stuNo) {
        return mapper.getStudentInfoByNo(stuNo);
    }


    @Override
    public List<StudentVo> getDepartmentStudents(DepartmentYearParam param) {
        return mapper.searchDepartmentStudents(param);
    }

    //添加学生
    @Override
    public boolean addStudent(StudentBo student) {
        StudentVo one=mapper.getStudentInfoByNo(student.getStuNo());
        if(one!=null){
            return false;//表示该学生已存在
        }
        student.setPassword("123456");
        return mapper.insertStudent(student) > 0;//表示添加成功
//表示添加失败
    }

    @Override
    public boolean modifyStudent(StudentBo student) {
        return mapper.updateStudent(student) > 0;
    }

    @Override
    public List<StudentVo> getStudentsByName(String key) {
        return mapper.searchStudentByName(key);
    }


    @Override
    public boolean dropStudent(String stuNo) {
        return mapper.deleteStudent(stuNo) > 0;
    }
}
