package com.ecnu.student.feign;

import com.ecnu.utils.R;
import com.ecnu.vo.param.ManipulateCourseParam;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.StuSearchCourseQuery;
import com.ecnu.vo.query.StuSearchNextTermQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="course-service")
public interface CourseFeign {

    //查询某年某学期课程
    @PostMapping("/course/stu")
    public R getStuCourses(@RequestBody StuSearchCourseQuery query);

    //学生成绩查询
    @PostMapping("/course/stu/score")
    public R queryStuScore(@RequestBody StuSearchCourseQuery query);

    //质疑成绩状态
    @PutMapping("/course/stu/doubtScore")
    public R doubtScore(@RequestBody SetScoreStatusParam param);

    //已读
    @PutMapping("/course/stu/knowScore")
    public R knowScore(@RequestBody SetScoreStatusParam param);

    @PostMapping("/course/stu/profession")
    public R queryStuNextTermProfessionPlan(@RequestBody StuSearchNextTermQuery query);

    @PostMapping("/course/stu/common")
    public R queryStuNextTermCommonPlan(@RequestBody StuSearchNextTermQuery query);

    //学生选课
    @PostMapping("/course/stu/add")
    public R chooseStuCourse(@RequestBody ManipulateCourseParam param);

    //学生退课
    @DeleteMapping("/course/stu/cancel")
    public R dropStuCourse(@RequestBody ManipulateCourseParam param);


}
