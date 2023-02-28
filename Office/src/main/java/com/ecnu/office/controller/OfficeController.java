package com.ecnu.office.controller;


import com.ecnu.bo.CourseBo;
import com.ecnu.bo.StudentBo;
import com.ecnu.bo.TeacherBo;
import com.ecnu.office.entity.*;
import com.ecnu.office.feign.CourseFeign;
import com.ecnu.office.feign.StudentFeign;
import com.ecnu.office.feign.TeacherFeign;
import com.ecnu.office.service.OfficeService;
import com.ecnu.office.vo.OfficeVo;
import com.ecnu.office.vo.param.*;
import com.ecnu.utils.R;
import com.ecnu.vo.param.ScheduleCourseParam;
import com.ecnu.vo.query.CourseConditionQuery;
import com.ecnu.vo.param.DepartmentYearParam;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;
    @Autowired
    private StudentFeign studentFeign;
    @Autowired
    private TeacherFeign teacherFeign;
    @Autowired
    private CourseFeign courseFeign;

    //登录
    @PostMapping("/login")
    public R officeLogin(@RequestBody LoginParam loginParam){
        OfficeVo office=officeService.login(loginParam);
        if(office!=null){
            return R.ok().put("data",office);
        }
        return R.error("登录失败。");
    }

    //修改密码
    @PutMapping("/updatepwd")
    public R modifyPwd(@RequestBody ModifyPwdParam pwdParam){
        if(officeService.changePwd(pwdParam)){
            return R.ok("更新成功！");
        }
        return R.error("更新失败。");
    }

    @GetMapping("/mine")
    public R getMyInfo(@RequestParam String officeNo) {
        OfficeVo result = officeService.getMyInfo(officeNo);
        if (result == null) {
            return R.error("查询为空");
        }
        return R.putData(result);
    }

    @PutMapping("/updateinfo")
    public R updateOfficeInfo(@RequestBody ModifyInfoParam param) {
        if (officeService.changeInfo(param)) {
            return R.ok();
        }
        return R.error("更新教务信息失败");
    }


    /*********************************学生********************************/

    //查看学院年级学生名单  {只能查看自己负责年级的}
    @GetMapping("/student")
    public R getStudentsByDept(DepartmentYearParam param){
        return studentFeign.getStudentsByDept(param);
    }

    //添加学生
    @PostMapping("/student")
    public R addAStudent(@RequestBody StudentBo student){
        return studentFeign.addAStudent(student);
    }

    //修改学生信息
    @PutMapping("/student")
    public R modifyStudentInfo(@RequestBody StudentBo student){
        return studentFeign.modifyStudentInfo(student);
    }

    //通过学号查询学生
    @GetMapping("/student/number")
    public R getStuInfoByNumber(String stuNo){
        return studentFeign.getStudentInfo(new ArrayList<String>(){{add(stuNo);}});
    }

    //通过名字模糊查询学生
    @GetMapping("/student/name")
    public R getStuInfoByName(@RequestParam String key){
        return studentFeign.getStusInfoByName(key);
    }

    //删除学生
    @DeleteMapping("/student/{stuNo}")
    public R dropStudentInfo(@PathVariable String stuNo){
        return studentFeign.dropStudentInfo(stuNo);
    }




    /****************************老师*************************/
    //查看教师名单
    @GetMapping("/teacher")
    public R getTeachersByDept(DepartmentYearParam departmentParam){
        return teacherFeign.getTeachersByDept(departmentParam);
    }


    //添加老师
    @PostMapping("/teacher")
    public R addATeacher(@RequestBody TeacherBo teacher){
        return teacherFeign.addTeacher(teacher);
    }

    //修改老师信息
    @PutMapping("/teacher")
    public R modifyTeacherInfo(@RequestBody TeacherBo teacher){
        return teacherFeign.modifyTeacherInfo(teacher);
    }

    //按工号对老师进行查找
    @GetMapping("/teacher/number")
    public R getTeachInfoByNo(@RequestParam String teacherNo){
        return teacherFeign.getTeacherInfoByNo(teacherNo);
    }

    //按姓名对老师进行模糊查找
    @GetMapping("/teacher/name")
    public R getTeachersInfoByName(@RequestParam String key){
        return teacherFeign.getTeachersInfoByName(key);
    }

    //删除老师
    @DeleteMapping("/teacher/{teacherNo}")
    public R dropTeacherInfo(@PathVariable("teacherNo")String teacherNo){
        return teacherFeign.dropTeacherInfo(teacherNo);
    }


    /*********************************课程********************************/




    //根据条件查询之前开过的课程
    @GetMapping("/course/previous")
    public R officeGetPreviousCourse(CourseConditionQuery query){
        return courseFeign.officeGetPreviousCourse(query);
    }

    //根据条件查询未修课程
    @GetMapping("/course/later")
    public R officeGetLaterCourse(CourseConditionQuery query){
        return courseFeign.officeGetLaterCourse(query);
    }

    //添加课程
    @GlobalTransactional
    @PostMapping("/course")
    public R officeAddCourse(@RequestBody CourseBo course){
        String teacherNo = course.getTeacherNo();
        R tempData = teacherFeign.getTeacherInfoByNo(teacherNo);
        Map teacherInfo = (Map)tempData.get("data");
        course.setDepartment((String) teacherInfo.get("department"));
        course.setTeacher((String) teacherInfo.get("name"));
        course.setTitle((String) teacherInfo.get("title"));
        return courseFeign.officeAddCourse(course);
    }

    //修改课程
    @GlobalTransactional
    @PutMapping("/course")
    public R officeModifyCourse(@RequestBody CourseBo course){
        String teacherNo = course.getTeacherNo();
        R tempData = teacherFeign.getTeacherInfoByNo(teacherNo);
        Map teacherInfo = (Map)tempData.get("data");
        course.setDepartment((String) teacherInfo.get("department"));
        course.setTeacher((String) teacherInfo.get("name"));
        course.setTitle((String) teacherInfo.get("title"));
        return courseFeign.officeModifyCourse(course);
    }

    //删除课程
    @DeleteMapping("/course/delete/{courseId}")
    public R officeDropCourse(@PathVariable("courseId")int id){
        return courseFeign.deleteCourseById(id);
    }


    //排课
    @PostMapping("/course/schedule")
    public R officeScheduleTable(@RequestBody ScheduleCourseParam param){
        return courseFeign.scheduleCourse(param);
    }

    @PutMapping("/course/schedule")
    public R officeUpdateScheduleTable(@RequestBody ScheduleCourseParam param){
        return courseFeign.updateScheduledCourse(param);
    }

    @GetMapping("/course/haveScheduled")
    public R officeHaveScheduled(CourseConditionQuery query) {
        return courseFeign.haveScheduled(query);
    }

    @DeleteMapping("/course/haveScheduled/delete/{secCourseId}")
    public R officeDeleteTheScheduledOne(@PathVariable("secCourseId") int secCourseId) {
        return courseFeign.deleteScheduledOne(secCourseId);
    }














}
