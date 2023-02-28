package com.ecnu.office.feign;

import com.ecnu.bo.TeacherBo;
import com.ecnu.utils.R;
import com.ecnu.vo.param.DepartmentYearParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("teacher-service")
public interface TeacherFeign {

    @PostMapping("/teacher/department")
    public R getTeachersByDept(@RequestBody DepartmentYearParam param);

    //添加老师
    @PostMapping("/teacher/add")
    public R addTeacher(@RequestBody TeacherBo teacher);

    //修改老师信息
    @PutMapping("/teacher/modify")
    public R modifyTeacherInfo(@RequestBody TeacherBo teacher);

    @GetMapping("/teacher/no")
    public R getTeacherInfoByNo(@RequestParam String teacherNo);

    @GetMapping("/teacher/name")
    public R getTeachersInfoByName(@RequestParam String key);

    @DeleteMapping("/teacher/delete/{teacherNo}")
    public R dropTeacherInfo(@PathVariable("teacherNo")String teacherNo);
}
