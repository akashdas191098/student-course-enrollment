package com.scb.course.service;

import com.scb.course.entity.Courses;
import com.scb.course.request.CourseRequest;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface CourseService {

    Courses addCourse(CourseRequest courseRequest);

    List<Courses> allCourses();

    Courses getById(Integer id);

}
