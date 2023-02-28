package com.ecnu.course.service.Impl;

import com.ecnu.bo.CourseScoreBo;
import com.ecnu.course.mapper.CourseMapper;
import com.ecnu.course.service.TeacherCourseService;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.TeacherSearchStudentQuery;
import com.ecnu.vo.param.SetScoreParam;
import com.ecnu.vo.query.TeacherSearchCourseQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {

    @Autowired
    CourseMapper mapper;

    @Override
    public List<SecCourseVo> getTeacherCourses(TeacherSearchCourseQuery query) {
        return mapper.selectTeacherCourse(query);
    }

    @Override
    public List<CourseScoreBo> getClassScores(TeacherSearchStudentQuery query) {
        return mapper.getClassScores(query);
    }

    @Override
    @Transactional
    public void setScore(SetScoreParam param) {
        SetScoreStatusParam tem = new SetScoreStatusParam();
        BeanUtils.copyProperties(param, tem);
        tem.setScoreStatus("教师确认");
        mapper.setScoreStatus(tem);
        mapper.updateScore(param);
    }


    @Override
    public boolean rejectAsk(SetScoreStatusParam param) {
        param.setScoreStatus("教师驳回");
        return mapper.setScoreStatus(param) > 0;
    }

    @Override
    public void setScoreBatch(List<SetScoreParam> params) {
        params.forEach(param -> {mapper.updateScore(param);});
    }
}
