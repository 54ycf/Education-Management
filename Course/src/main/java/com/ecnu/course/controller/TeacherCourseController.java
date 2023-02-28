package com.ecnu.course.controller;

import com.ecnu.bo.CourseScoreBo;
import com.ecnu.course.service.TeacherCourseService;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.TeacherSearchStudentQuery;
import com.ecnu.vo.param.SetScoreParam;
import com.ecnu.vo.query.TeacherSearchCourseQuery;
import com.ecnu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/teacher")
public class TeacherCourseController {

    @Autowired
    TeacherCourseService teacherService;


    //查找课程
    @PostMapping
    public R getTeachCourses(@RequestBody TeacherSearchCourseQuery param){
        List<SecCourseVo> courses = teacherService.getTeacherCourses(param);
        if(courses.size()>0){
            return R.ok().put("data",courses);
        }
        return R.error("查询为空。");
    }

    //查找一门课程的学生包括成绩
    @PostMapping ("/student")
    public R getClassStudents(@RequestBody TeacherSearchStudentQuery query){
        List<CourseScoreBo> scores =teacherService.getClassScores(query);
        if(scores.size()>0){
            return R.ok().put("data", scores);
        }
        return R.error("查询为空。");
    }


    //驳回申请
    @PutMapping("/rejectAsk")
    public R rejectAsk(@RequestBody SetScoreStatusParam param) {
        if (teacherService.rejectAsk(param)) {
            return R.ok();
        }
        return R.error("修改状态失败");
    }

    //填写一名学生的平时成绩和期末成绩
    @PutMapping("/score")
    public R setStuScore(@RequestBody SetScoreParam param){
        teacherService.setScore(param);
        return R.ok();
    }


    @PutMapping("/score/batch")
    public R setStuScoreBatch(@RequestBody List<SetScoreParam> params) {
        teacherService.setScoreBatch(params);
        return R.ok();
    }
}
