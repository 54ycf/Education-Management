package com.ecnu.teacher.controller;


import com.ecnu.bo.CourseScoreBo;
import com.ecnu.bo.StudentBo;
import com.ecnu.bo.TeacherBo;
import com.ecnu.teacher.feign.CourseFeign;
import com.ecnu.teacher.feign.StudentFeign;
import com.ecnu.teacher.service.TeacherService;
import com.ecnu.teacher.vo.TeacherVo;
import com.ecnu.teacher.vo.param.*;
import com.ecnu.utils.R;
import com.ecnu.vo.param.DepartmentYearParam;
import com.ecnu.vo.param.SetScoreParam;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.TeacherSearchCourseQuery;
import com.ecnu.vo.query.TeacherSearchStudentQuery;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseFeign courseFeign;
    @Autowired
    StudentFeign studentFeign;


    //登录   //ok
    @PostMapping("/login")
    public R teacherLogin(@RequestBody LoginParam loginParam){
        TeacherVo teacher=teacherService.login(loginParam);
        if(teacher!=null){
            return R.ok().put("data",teacher);
        }
        return R.error("登录失败。");
    }


    @GetMapping("/mine")
    public R getMyInfo(@RequestParam String teacherNo) {
        TeacherVo result = teacherService.getTeacherByNo(teacherNo);
        if (result == null) {
            return R.error("查询为空");
        }
        return R.putData(result);
    }


    //修改密码
    @PutMapping("/updatepwd")
    public R modifyPwd(@RequestBody ModifyPwdParam modifyPwdParam){
        if(teacherService.changePwd(modifyPwdParam)){
            return R.ok("更新成功！");
        }
        return R.error("更新失败。");
    }

    //修改个人信息
    @PutMapping("/updateinfo")
    public R modifyInfo(@RequestBody ModifyInfoParam modifyInfoParam){
        if(teacherService.changeInfo(modifyInfoParam)){
            return R.ok("更新成功！");
        }
        return R.error("更新失败。");
    }


    //查找课程
    @GetMapping("/course")
    public R getTeachCourses(TeacherSearchCourseQuery query){
        return courseFeign.getTeachCourses(query);
    }

    //查找一门课程的学生
    @GetMapping ("/student")
    @GlobalTransactional
    public R getStudents(TeacherSearchStudentQuery query){
        R courseScore = courseFeign.getClassStudents(query);
        List<Map> data = (List<Map>)courseScore.get("data");
        List<String> stuNoList = new ArrayList<>();
        data.forEach(map -> stuNoList.add((String) map.get("stuNo")));
        R studentInfo = studentFeign.getStudentInfo(stuNoList);
        List<Map> students = (List<Map>)studentInfo.get("data");
        for (int i = 0; i < data.size(); i++) {
            data.get(i).put("name",students.get(i).get("name"));
        }
        return R.putData(data);
    }

    //填写一名学生的平时成绩和期末成绩
    @PutMapping("/score")
    public R setStuScore(@RequestBody SetScoreParam param){
        return courseFeign.setStuScore(param);
    }

    @PutMapping("/score/batch")
    public R setStuScoreBatch(@RequestBody List<SetScoreParam> params) {
        return courseFeign.setStuScoreBatch(params);
    }

    //驳回请求
    @PutMapping("/score/rejectAsk")
    public R rejectDoubtAsk(@RequestBody SetScoreStatusParam param) {
        return courseFeign.rejectAsk(param);
    }


    //查看学院教师名单
    @PostMapping("/department")
    public R getTeachersByDept(@RequestBody DepartmentYearParam param){
        List<TeacherVo> teacherList=teacherService.getDepartmentTeachers(param);
        if(teacherList.size()>0){
            return R.ok().put("data",teacherList);
        }
        return R.error("查询为空。");
    }

    @PostMapping("/add")
    public R addTeacher(@RequestBody TeacherBo teacher) {
        if (teacherService.addTeacher(teacher)) {
            return R.ok();
        }
        return R.error("添加教师失败");
    }

    @PutMapping("/modify")
    public R modifyTeacherInfo(@RequestBody TeacherBo teacher) {
        if (teacherService.modifyTeacher(teacher)) {
            return R.ok();
        }
        return R.error("修改教师信息失败");
    }

    @GetMapping("/no")
    public R getTeacherInfoByNo(@RequestParam String teacherNo) {
        TeacherVo result = teacherService.getTeacherByNo(teacherNo);
        if (result == null) {
            return R.error("查无此人");
        }
        return R.putData(result);
    }

    @GetMapping("/name")
    public R getTeachersInfoByName(@RequestParam String key) {
        List<TeacherVo> result = teacherService.getTeachersInfoByName(key);
        if (result.isEmpty()){
            return R.error("查无此人");
        }
        return R.putData(result);
    }

    @DeleteMapping("/delete/{teacherNo}")
    public R dropTeacherInfo(@PathVariable("teacherNo")String teacherNo){
        if (teacherService.dropTeacher(teacherNo)){
            return R.ok();
        }
        return R.error("删除失败");
    }

}
