package com.ecnu.teacher.mapper;

import com.ecnu.bo.TeacherBo;
import com.ecnu.teacher.vo.TeacherVo;
import com.ecnu.teacher.vo.param.LoginParam;
import com.ecnu.teacher.vo.param.ModifyInfoParam;
import com.ecnu.teacher.vo.param.ModifyPwdParam;
import com.ecnu.vo.param.DepartmentYearParam;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;


import java.util.List;


@Mapper
@Repository
public interface TeacherMapper {

    //登录
    @Select("select * from teacher where teacher_no=#{teacherNo} and password=#{password} limit 1")
    TeacherVo login(LoginParam loginParam);

    //修改密码
    @Update("update teacher set password=#{newPwd} where teacher_no=#{teacherNo} and password=#{oldPwd}")
    int updatePwd(ModifyPwdParam modifyPwdParam);

    //修改信息
    @Update("update teacher set phone=#{phone}, email=#{email} where teacher_no=#{teacherNo}")
    int updateInfo(ModifyInfoParam param);


    //查询一个学院的老师
    @Select("select * from teacher where department=#{department}")
    List<TeacherVo> searchDepartmentTeachers(DepartmentYearParam param);


    //根据教工号查询老师
    @Select("select * from teacher where teacher_no=#{teacherNo}")
    TeacherVo getTeacherByNo(String teacherNumber);

    //添加老师
    @Insert("insert into teacher(teacher_no,password,name,sex,department,title,in_date) values(#{teacherNo},#{password},#{name},#{sex},#{department}, #{title},#{inDate})")
    int insertTeacher(TeacherBo teacher);

    //教务修改老师信息
    @Update("update teacher set name=#{name},sex=#{sex},teacher_no=#{teacherNo},department=#{department}, in_date=#{inDate},title=#{title}, email=#{email},phone=#{phone} where teacher_no=#{teacherNo}")
    int modifyTeacher(TeacherBo teacher);

    //根据名字模糊查询老师
    @Select("select * from teacher where name like concat('%',#{key},'%')")
    List<TeacherVo> getTeacherByName(String key);


    @Delete("delete from teacher where teacher_no=#{teacherNo}")
    int deleteTeacher(String teacherNo);
}
