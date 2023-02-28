package com.ecnu.teacher.feign;

import com.ecnu.utils.R;
import com.ecnu.vo.param.SetScoreParam;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.TeacherSearchCourseQuery;
import com.ecnu.vo.query.TeacherSearchStudentQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("course-service")
public interface CourseFeign {

    @PostMapping("/course/teacher")
    public R getTeachCourses(@RequestBody TeacherSearchCourseQuery query);

    @PostMapping("/course/teacher/student")
    public R getClassStudents(@RequestBody TeacherSearchStudentQuery query);

    @PutMapping("/course/teacher/score")
    public R setStuScore(@RequestBody SetScoreParam param);

    @PutMapping("/course/teacher/score/batch")
    public R setStuScoreBatch(@RequestBody List<SetScoreParam> params);

    @PutMapping("/course/teacher/rejectAsk")
    public R rejectAsk(@RequestBody SetScoreStatusParam param);

}
