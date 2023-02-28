package com.ecnu.student.mapper;

import com.ecnu.bo.StudentBo;
import com.ecnu.student.vo.StudentVo;
import com.ecnu.student.vo.param.LoginParam;
import com.ecnu.student.vo.param.ModifyInfoParam;
import com.ecnu.student.vo.param.ModifyPwdParam;
import com.ecnu.vo.param.DepartmentYearParam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {


    //登录，获取用户信息
    @Select("select * from student where stu_no=#{stuNo} and password=#{password} limit 1")
    StudentVo login(LoginParam loginParam);

    //修改密码
    @Update("update student set password=#{newPwd} where stu_no=#{stuNo} and password=#{oldPwd}")
    int updatePwd(ModifyPwdParam param);

    //修改信息
    @Update("update student set phone=#{phone}, email=#{email} where stu_no=#{stuNo}")
    int updateInfo(ModifyInfoParam param);

    @Select("select * from student where stu_no=#{stuNo}")
    StudentVo getStudentInfoByNo(String stuNo);


    @Select("select * from student where name like concat('%',#{key},'%')")
    List<StudentVo> searchStudentByName(String search);

    //获取某专业某年级学生
    List<StudentVo> searchDepartmentStudents(DepartmentYearParam param);

    //可以注册的时候添加上email和phone
    //添加学生
    @Insert("insert into student(stu_no,password,name,sex,department, email,phone,in_date,out_date,grade_year)  values(#{stuNo},#{password},#{name},#{sex},#{department},#{email},#{phone},#{inDate},#{outDate},#{gradeYear})")
    int insertStudent(StudentBo student);

    //更新学生信息
    int updateStudent(StudentBo student);

    @Delete("delete from student where stu_no=#{stuNo}")
    int deleteStudent(String stuNo);
}
