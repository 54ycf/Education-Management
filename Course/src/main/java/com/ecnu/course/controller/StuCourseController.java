package com.ecnu.course.controller;

import com.ecnu.course.vo.ScoreVo;
import com.ecnu.course.service.StuCourseService;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.vo.param.ManipulateCourseParam;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.StuSearchCourseQuery;
import com.ecnu.utils.R;
import com.ecnu.vo.query.StuSearchNextTermQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/stu")
public class StuCourseController {

    @Autowired
    StuCourseService stuCourseService;

    //查找学生的某学期某学期课程
    @PostMapping
    public R getStuCourses(@RequestBody StuSearchCourseQuery query){
        List<SecCourseVo> courses= stuCourseService.getStuCourses(query);
        if(courses.size()>0){
            return R.ok().put("data",courses);
        }
        return R.error("学生课表查询为空。");
    }

    //学生成绩查询
    @PostMapping("/score")
    public R queryStuScore(@RequestBody StuSearchCourseQuery query){
        List<ScoreVo> scoreList =stuCourseService.queryScores(query);
        if(scoreList.size()>0){
            return R.ok().put("data", scoreList);
        }
        return R.error("成绩查询为空。");
    }

    //质疑成绩状态
    @PutMapping("/doubtScore")
    public R doubtScore(@RequestBody SetScoreStatusParam param){
        if (stuCourseService.doubtScore(param)) {
            return R.ok();
        }
        return R.error("已经是最终成绩");
    }

    //已读
    @PutMapping("/knowScore")
    public R knowScore(@RequestBody SetScoreStatusParam param) {
        if (stuCourseService.knowScore(param)) {
            return R.ok();
        }
        return R.error("已读失败");
    }



    //
    @PostMapping("/profession")
    public R queryStuNextTermProfessionPlan(@RequestBody StuSearchNextTermQuery query){
        List<SecCourseVo> result = stuCourseService.getNextTermProfessionPlan(query);
        return R.putData(result);
    }

    @PostMapping("/common")
    public R queryStuNextTermCommonPlan(@RequestBody StuSearchNextTermQuery query){
        List<SecCourseVo> result = stuCourseService.getNextTermCommonPlan(query);
        return R.putData(result);
    }

    //学生选课
    @PostMapping("/add")
    public R chooseStuCourse(@RequestBody ManipulateCourseParam param){
        if(stuCourseService.chooseCourse(param)){
            return R.ok("选课成功！");
        }
        return R.error("选课失败。");
    }

    //学生退课
    @DeleteMapping("/cancel")
    public R dropStuCourse(@RequestBody ManipulateCourseParam param){
        if(stuCourseService.dropCourse(param)){
            return R.ok("退课成功！");
        }
        return R.error("退课失败。");
    }


}
