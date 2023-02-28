package com.ecnu.office.feign;

import com.ecnu.bo.StudentBo;
import com.ecnu.office.entity.Student;
import com.ecnu.utils.R;
import com.ecnu.vo.param.DepartmentYearParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("student-service")
public interface StudentFeign {

    @PostMapping("/student/department")
    public R getStudentsByDept(@RequestBody DepartmentYearParam param);

    @PostMapping("/student")
    public R addAStudent(@RequestBody StudentBo student);

    @PutMapping("/student")
    public R modifyStudentInfo(@RequestBody StudentBo student);

    @PostMapping("student/info")
    public R getStudentInfo(@RequestBody List<String> stuNos);

    @GetMapping("student/name")
    public R getStusInfoByName(@RequestParam String key);

    //删除学生
    @DeleteMapping("/student/delete/{stuNo}")
    public R dropStudentInfo(@PathVariable String stuNo);
}
