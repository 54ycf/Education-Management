package com.ecnu.office.feign;

import com.ecnu.bo.CourseBo;
import com.ecnu.utils.R;
import com.ecnu.vo.param.ScheduleCourseParam;
import com.ecnu.vo.query.CourseConditionQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("course-service")
public interface CourseFeign {

    @PostMapping("/course/office/previous")
    public R officeGetPreviousCourse(@RequestBody CourseConditionQuery query);

    @PostMapping("/course/office/later")
    public R officeGetLaterCourse(@RequestBody CourseConditionQuery query);

    @PostMapping("/course/office/add")
    public R officeAddCourse(@RequestBody CourseBo course);

    @PutMapping("/course/office/modify")
    public R officeModifyCourse(@RequestBody CourseBo course);

    @DeleteMapping("/course/office/delete/{courseId}")
    public R deleteCourseById(@PathVariable("courseId") int courseId);

    @PostMapping("/course/office/schedule")
    public R scheduleCourse(@RequestBody ScheduleCourseParam param);

    @PutMapping("/course/office/schedule")
    public R updateScheduledCourse(@RequestBody ScheduleCourseParam param);

    @PostMapping("/course/office/haveScheduled")
    public R haveScheduled(@RequestBody CourseConditionQuery query);

    @DeleteMapping("/course/office/haveScheduled/delete/{secCourseId}")
    public R deleteScheduledOne(@PathVariable("secCourseId") int secCourseId);
}
