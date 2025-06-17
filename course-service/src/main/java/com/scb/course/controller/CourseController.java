package com.scb.course.controller;

import com.scb.course.entity.Courses;
import com.scb.course.request.CourseRequest;
import com.scb.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public ResponseEntity<Courses> saveCourse(@RequestBody CourseRequest courseRequest){
        Courses courses = courseService.addCourse(courseRequest);
        return new ResponseEntity<Courses>(courses, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Courses>> allCourse(){
        List<Courses> coursesList = courseService.allCourses();
        return new ResponseEntity<List<Courses>>(coursesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Courses getCourseById(@PathVariable("id") Integer id){
        //Courses courses = courseService.getById(id);
        Courses courses = courseService.getById(id);
        return courses;
    }
}
