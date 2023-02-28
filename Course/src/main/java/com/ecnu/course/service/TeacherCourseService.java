package com.ecnu.course.service;

import com.ecnu.bo.CourseScoreBo;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.TeacherSearchStudentQuery;
import com.ecnu.vo.param.SetScoreParam;
import com.ecnu.vo.query.TeacherSearchCourseQuery;

import java.util.List;

public interface TeacherCourseService {

    List<SecCourseVo> getTeacherCourses(TeacherSearchCourseQuery query);

    List<CourseScoreBo> getClassScores(TeacherSearchStudentQuery query);

    void setScore(SetScoreParam setScoreParam);

    boolean rejectAsk(SetScoreStatusParam param);

    void setScoreBatch(List<SetScoreParam> params);
}
