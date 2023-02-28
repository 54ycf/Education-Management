package com.ecnu.course.controller;

import com.ecnu.bo.CourseBo;
import com.ecnu.course.entity.Course;
import com.ecnu.course.service.OfficeCourseService;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.utils.R;
import com.ecnu.vo.param.ScheduleCourseParam;
import com.ecnu.vo.query.CourseConditionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/office")
public class OfficeCourseController {

    @Autowired
    OfficeCourseService officeCourseService;

    //根据条件查询之前课程
    @PostMapping("/previous")
    public R officeGetPreviousCourse(@RequestBody CourseConditionQuery query){
        List<SecCourseVo> courseList=officeCourseService.getPreviousCourses(query);
        if(courseList.size()>0){
            return R.putData(courseList);
        }
        return R.error("查询为空。");
    }

    //查询未修课程
    @PostMapping("/later")
    public R officeGetLaterCourse(@RequestBody CourseConditionQuery query) {
        List<Course> result = officeCourseService.getLaterCourses(query);
        if (result.isEmpty()) {
            return R.error("查询失败");
        }
        return R.putData(result);
    }

    @PostMapping("/add")
    public R officeAddCourse(@RequestBody CourseBo course) {
        if (officeCourseService.addCourse(course)) {
            return R.ok();
        }
        return R.error("添加课程失败");
    }

    @PutMapping("/modify")
    public R officeModifyCourse(@RequestBody CourseBo course) {
        if (officeCourseService.modifyCourse(course)) {
            return R.ok();
        }
        return R.error("修改课程失败");
    }

    @DeleteMapping("/delete/{courseId}")
    public R deleteCourseById(@PathVariable("courseId") int courseId) {
        if (officeCourseService.deleteCourse(courseId)) {
            return R.ok();
        }
        return R.error("删除课程池失败");
    }

    @PostMapping("/schedule")
    public R scheduleCourse(@RequestBody ScheduleCourseParam param) {
        if (officeCourseService.scheduleCourse(param)){
            return R.ok();
        }
        return R.error("安排课程失败");
    }

    @PutMapping("/schedule")
    public R updateScheduledCourse(@RequestBody ScheduleCourseParam param) {
        if (officeCourseService.updateScheduleCourse(param)){
            return R.ok();
        }
        return R.error("安排课程失败");
    }

    //获取已经安排好的课程
    @PostMapping("/haveScheduled")
    public R haveScheduled(@RequestBody CourseConditionQuery query) {
        return R.putData(officeCourseService.getScheduled(query));
    }

    @DeleteMapping("/haveScheduled/delete/{secCourseId}")
    public R deleteScheduledOne(@PathVariable("secCourseId") int secCourseId) {
        if (officeCourseService.deleteScheduledOne(secCourseId)) {
            return R.ok();
        }
        return R.error("安排的课程删除失败");
    }
}
