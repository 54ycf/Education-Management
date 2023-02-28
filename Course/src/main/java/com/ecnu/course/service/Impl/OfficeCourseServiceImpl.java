package com.ecnu.course.service.Impl;

import com.ecnu.bo.CourseBo;
import com.ecnu.course.entity.Course;
import com.ecnu.course.mapper.CourseMapper;
import com.ecnu.course.service.OfficeCourseService;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.vo.param.ScheduleCourseParam;
import com.ecnu.vo.query.CourseConditionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeCourseServiceImpl implements OfficeCourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<SecCourseVo> getPreviousCourses(CourseConditionQuery query) {
        return courseMapper.officeSearchPreviousCourse(query);
    }

    @Override
    public List<Course> getLaterCourses(CourseConditionQuery query) {
        return courseMapper.officeSearchLaterCourse(query);
    }

    @Override
    public boolean addCourse(CourseBo course) {
        return courseMapper.officeAddCourse(course) > 0;
    }

    @Override
    public boolean modifyCourse(CourseBo course) {
        return courseMapper.officeModifyCourse(course) >0;
    }

    @Override
    public boolean deleteCourse(int courseId) {
        return courseMapper.officeDeleteCourseById(courseId) > 0;
    }

    @Override
    public boolean scheduleCourse(ScheduleCourseParam param) {
        return courseMapper.addSecCourse(param) > 0;
    }

    @Override
    public boolean updateScheduleCourse(ScheduleCourseParam param) {
        return courseMapper.updateSecCourse(param) >0;
    }

    @Override
    public List<SecCourseVo> getScheduled(CourseConditionQuery query) {
        return courseMapper.searchScheduled(query);
    }

    @Override
    public boolean deleteScheduledOne(int secCourseId) {
        return courseMapper.deleteSecCourseById(secCourseId) > 0 ;
    }


}
