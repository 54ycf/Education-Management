package com.ecnu.student.service;

import com.ecnu.bo.StudentBo;
import com.ecnu.student.vo.StudentVo;
import com.ecnu.student.vo.param.*;
import com.ecnu.vo.param.DepartmentYearParam;

import java.util.List;

public interface StudentService {

    StudentVo login(LoginParam loginParam);

    boolean changePwd(ModifyPwdParam modifyPwdParam);

    boolean changeInfo(ModifyInfoParam modifyInfoParam);


    List<StudentVo> getStudentInfo(List<String> stuNos);

    StudentVo getMyInfo(String stuNo);


    List<StudentVo> getDepartmentStudents(DepartmentYearParam departmentParam);

    boolean addStudent(StudentBo student);

    boolean modifyStudent(StudentBo student);


    List<StudentVo> getStudentsByName(String key);

    boolean dropStudent(String stuNo);
}
