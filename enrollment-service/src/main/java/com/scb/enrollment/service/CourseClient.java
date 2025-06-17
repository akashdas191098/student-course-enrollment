package com.scb.enrollment.service;

import com.scb.enrollment.Entities.Courses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080/courses",value = "Course-Client")
@FeignClient(name = "COURSE-SERVICE")
public interface CourseClient {

    @GetMapping("courses/{id}")
    public Courses getCourseById(@PathVariable("id") Integer id);
}
