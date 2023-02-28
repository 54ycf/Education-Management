package com.ecnu.student.controller;

import com.ecnu.bo.StudentBo;
import com.ecnu.student.feign.CourseFeign;
import com.ecnu.student.vo.StudentVo;
import com.ecnu.student.service.StudentService;
import com.ecnu.student.vo.param.*;
import com.ecnu.utils.R;
import com.ecnu.vo.param.DepartmentYearParam;
import com.ecnu.vo.param.ManipulateCourseParam;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.StuSearchCourseQuery;
import com.ecnu.vo.query.StuSearchNextTermQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseFeign courseFeign;

    @PostMapping("/login")
    public R stuLogin(@RequestBody LoginParam loginParam){
        StudentVo student=studentService.login(loginParam);
        if(student!=null){
            return R.ok().put("data",student);
        }
        return R.error("学号或密码错误。");

    }


    @GetMapping("/mine")
    public R getMyInfo(@RequestParam String stuNo) {
        StudentVo result = studentService.getMyInfo(stuNo);
        if (result == null) {
            return R.error("查询为空");
        }
        return R.putData(result);
    }


    //修改密码
    @PutMapping("/updatepwd")
    public R modifyPwd(@RequestBody ModifyPwdParam modifyPwdParam){
        if(studentService.changePwd(modifyPwdParam)){
            return R.ok("更新成功！");
        }
        return R.error("更新失败。");
    }

    //修改个人信息
    @PutMapping("/updateinfo")
    public R modifyInfo(@RequestBody ModifyInfoParam modifyInfoParam){
        if(studentService.changeInfo(modifyInfoParam)){
            return R.ok("更新成功！");
        }
        return R.error("更新失败。");
    }

    /***************************************/

    //学生查看自己每学期的课表
    @GetMapping("/course")
    public R getStuCourse(StuSearchCourseQuery query){
        return courseFeign.getStuCourses(query);
    }

    //成绩查询
    @GetMapping("/score")
    public R queryStuScore(StuSearchCourseQuery query){
        return courseFeign.queryStuScore(query);
    }

    //质疑成绩
    @PutMapping("/score/doubt")
    public R doubtTheScore(@RequestBody SetScoreStatusParam param) {
        return courseFeign.doubtScore(param);
    }

    //已读
    @PutMapping("/score/knowScore")
    public R knowScore(@RequestBody SetScoreStatusParam param) {
        return courseFeign.knowScore(param);
    }

    @GetMapping("/nextTermProfession")
    public R queryStuNextTermProfessionPlan(StuSearchNextTermQuery query) {
        return courseFeign.queryStuNextTermProfessionPlan(query);
    }

    @GetMapping("/nextTermCommon")
    public R queryStuNextTermCommonPlan(StuSearchNextTermQuery query) {
        return courseFeign.queryStuNextTermCommonPlan(query);
    }

    //选课
    @PostMapping("/course/select")
    public R chooseStuCourse(@RequestBody ManipulateCourseParam param){
        return courseFeign.chooseStuCourse(param);
    }

    //退课
    @PostMapping("/course/cancel")
    public R dropStuCourse(@RequestBody ManipulateCourseParam param){
        return courseFeign.dropStuCourse(param);
    }
//


    //根据stuNos批量查询学生信息
    @PostMapping("/info")
    public R getStudentInfo(@RequestBody List<String> stuNos){
        List<StudentVo> result = studentService.getStudentInfo(stuNos);
        if (result.isEmpty()){
            return R.error();
        }
        return R.putData(result);
    }

    //通过姓名模糊查询学生
    @GetMapping("/name")
    public R getStusInfoByName(@RequestParam String key){
        List<StudentVo> studentList=studentService.getStudentsByName(key);
        if(studentList.size()>0){
            return R.ok().put("data",studentList);
        }
        return R.error("查询为空。");
    }


    //查看某年纪某专业学生名单
    @PostMapping("/department")
    public R getStudentsByDept(@RequestBody DepartmentYearParam param){
        List<StudentVo> studentList=studentService.getDepartmentStudents(param);
        if(studentList.size()>0){
            return R.ok().put("data",studentList);
        }
        return R.error("查询为空");
    }

    //添加一位学生
    @PostMapping
    public R addAStudent(@RequestBody StudentBo student){
        if (studentService.addStudent(student)) {
            return R.ok();
        }
        return R.error("添加学生失败");
    }

    @PutMapping
    public R modifyStudentInfo(@RequestBody StudentBo student) {
        if (studentService.modifyStudent(student)) {
            return R.ok();
        }
        return R.error("更新学生信息失败");
    }

    //删除学生
    @DeleteMapping("/delete/{stuNo}")
    public R dropStudentInfo(@PathVariable String stuNo){
        if(studentService.dropStudent(stuNo)){
            return R.ok("删除成功！");
        }
        return R.error("删除失败");
    }
}
