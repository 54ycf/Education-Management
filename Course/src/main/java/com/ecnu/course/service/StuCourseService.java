package com.ecnu.course.service;

import com.ecnu.course.vo.ScoreVo;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.vo.param.ManipulateCourseParam;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.StuSearchCourseQuery;
import com.ecnu.vo.query.StuSearchNextTermQuery;

import java.util.List;

public interface StuCourseService {

    List<SecCourseVo> getStuCourses(StuSearchCourseQuery query);

    boolean chooseCourse(ManipulateCourseParam selectCourseParam);

    boolean dropCourse(ManipulateCourseParam selectCourseParam);

    List<ScoreVo> queryScores(StuSearchCourseQuery query);

    List<SecCourseVo> getNextTermProfessionPlan(StuSearchNextTermQuery query);

    List<SecCourseVo> getNextTermCommonPlan(StuSearchNextTermQuery query);

    boolean doubtScore(SetScoreStatusParam param);

    boolean knowScore(SetScoreStatusParam param);
}
