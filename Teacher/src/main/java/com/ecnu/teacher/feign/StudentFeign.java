package com.ecnu.teacher.feign;

import com.ecnu.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("student-service")
public interface StudentFeign {

    @PostMapping("student/info")
    public R getStudentInfo(@RequestBody List<String> stuNos);
}
