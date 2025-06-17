package com.scb.enrollment.service;

import com.scb.enrollment.Entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8081/students",value = "Student-Client")
@FeignClient(name = "STUDENT-SERVICE")
public interface StudentClient {

    @GetMapping("students/{id}")
    public Student getStudentsById(@PathVariable("id") Integer id);
}
