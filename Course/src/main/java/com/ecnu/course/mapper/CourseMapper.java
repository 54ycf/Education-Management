package com.ecnu.course.mapper;

import com.ecnu.bo.CourseBo;
import com.ecnu.course.entity.Course;
import com.ecnu.course.vo.ScoreVo;
import com.ecnu.bo.CourseScoreBo;
import com.ecnu.course.vo.SecCourseVo;
import com.ecnu.vo.param.ScheduleCourseParam;
import com.ecnu.vo.param.SetScoreStatusParam;
import com.ecnu.vo.query.*;
import com.ecnu.vo.param.SetScoreParam;
import com.ecnu.vo.param.ManipulateCourseParam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    List<SecCourseVo> searchStuCourse(StuSearchCourseQuery param);

    //查询下学期专业课
    List<SecCourseVo> searchNextTermProfessionPlan(StuSearchNextTermQuery query);

    //查询下学期公共课
    List<SecCourseVo> searchNextTermCommonPlan(StuSearchNextTermQuery query);

    //选课
    @Insert("insert into score(sec_course_id,stu_no) values (#{secCourseId},#{stuNo})")
    int insertCourse(ManipulateCourseParam param);

    //退课
    @Delete("delete from score where sec_course_id=#{secCourseId} and stu_no=#{stuNo}")
    int deleteCourse(ManipulateCourseParam param);

    //学生查看成绩
    List<ScoreVo> searchScore(StuSearchCourseQuery query);




    //老师查看某一学期所有课程
    List<SecCourseVo> selectTeacherCourse(TeacherSearchCourseQuery query);

    //老师查看某一课程所有学生和成绩
    List<CourseScoreBo> getClassScores(TeacherSearchStudentQuery query);

    //教师更新成绩
    int updateScore(SetScoreParam param);



    //教务查询之前修过的课程
    List<SecCourseVo> officeSearchPreviousCourse(CourseConditionQuery query);

    //教务查看未修计划
    List<Course> officeSearchLaterCourse(CourseConditionQuery query);

    //教务添加一门课程
    @Insert("insert into course(name,type,department,teacher,title,credit,teacher_no,big_type) values (#{name},#{type},#{department},#{teacher},#{title},#{credit},#{teacherNo},#{bigType}) ")
    int officeAddCourse(CourseBo course);

    //教务修改一门课程
    @Update("update course set name=#{name},type=#{type},department=#{department},teacher=#{teacher},title=#{title},credit=#{credit},teacher_no=#{teacherNo},big_type=#{bigType} where course_id=#{courseId}")
    int officeModifyCourse(CourseBo course);

    @Delete("delete from course where course_id = #{courseId}")
    int officeDeleteCourseById(int courseId);

    @Insert("insert into sec_course(years,semester,course_id,`day`,`order`,classroom,grade_year,limit_num) values(#{years},#{semester},#{courseId},#{day},#{order},#{classroom},#{gradeYear},#{limitNum})")
    int addSecCourse(ScheduleCourseParam param);

    @Update("update sec_course set years=#{years},semester=#{semester},course_id=#{courseId},`day`=#{day},`order`=#{order},classroom=#{classroom},grade_year=#{gradeYear},limit_num=#{limitNum} where sec_course_id=#{secCourseId}")
    int updateSecCourse(ScheduleCourseParam param);

    @Update("update score set score_status=#{scoreStatus} where sec_course_id=#{secCourseId} and stu_no=#{stuNo}")
    int setScoreStatus(SetScoreStatusParam param);

    @Select("select score_status from score where sec_course_id=#{secCourseId} and stu_no=#{stuNo}")
    String getScoreStatus(SetScoreStatusParam param);

    List<SecCourseVo> searchScheduled(CourseConditionQuery query);

    @Delete("delete from sec_course where sec_course_id=#{secCourseId}")
    int deleteSecCourseById(int secCourseId);
}
