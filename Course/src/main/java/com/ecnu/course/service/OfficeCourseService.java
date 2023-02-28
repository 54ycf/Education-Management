package com.ecnu.course.service;

import com.ecnu.bo.CourseBo;
import com.ecnu.course.entity.Course;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.utils.R;
import com.ecnu.vo.param.ScheduleCourseParam;
import com.ecnu.vo.query.CourseConditionQuery;

import java.util.List;

public interface OfficeCourseService {
    List<SecCourseVo> getPreviousCourses(CourseConditionQuery query);

    List<Course> getLaterCourses(CourseConditionQuery query);

    boolean addCourse(CourseBo course);

    boolean modifyCourse(CourseBo course);

    boolean deleteCourse(int courseId);

    boolean scheduleCourse(ScheduleCourseParam param);

    boolean updateScheduleCourse(ScheduleCourseParam param);

    List<SecCourseVo> getScheduled(CourseConditionQuery query);

    boolean deleteScheduledOne(int secCourseId);
}
