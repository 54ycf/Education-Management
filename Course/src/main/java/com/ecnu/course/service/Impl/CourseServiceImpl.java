package com.ecnu.course.service.Impl;

import com.ecnu.course.vo.ScoreVo;
import com.ecnu.course.mapper.CourseMapper;
import com.ecnu.course.service.StuCourseService;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.vo.param.ManipulateCourseParam;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.StuSearchCourseQuery;
import com.ecnu.vo.query.StuSearchNextTermQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements StuCourseService {

    @Autowired
    CourseMapper mapper;

    @Override
    public List<SecCourseVo> getStuCourses(StuSearchCourseQuery query) {
        return mapper.searchStuCourse(query);
    }

    @Override
    public boolean chooseCourse(ManipulateCourseParam param) {
        return mapper.insertCourse(param) > 0;
    }

    @Override
    public boolean dropCourse(ManipulateCourseParam param) {
        return mapper.deleteCourse(param) > 0;
    }

    @Override
    public List<ScoreVo> queryScores(StuSearchCourseQuery query) {
        return mapper.searchScore(query);
    }

    @Override
    public List<SecCourseVo> getNextTermProfessionPlan(StuSearchNextTermQuery query) {
        return mapper.searchNextTermProfessionPlan(query);
    }

    @Override
    public List<SecCourseVo> getNextTermCommonPlan(StuSearchNextTermQuery query) {
        return mapper.searchNextTermCommonPlan(query);
    }

    @Override
    public boolean doubtScore(SetScoreStatusParam param) {
        if (mapper.getScoreStatus(param).equals("无问题")) {
            param.setScoreStatus("质疑");
            return mapper.setScoreStatus(param) > 0;
        }
        return false;
    }

    @Override
    public boolean knowScore(SetScoreStatusParam param) {
        if (mapper.getScoreStatus(param).equals("教师确认") || mapper.getScoreStatus(param).equals("教师驳回")) {
            param.setScoreStatus("终结");
            return mapper.setScoreStatus(param) > 0;
        }
        return false;
    }
}
