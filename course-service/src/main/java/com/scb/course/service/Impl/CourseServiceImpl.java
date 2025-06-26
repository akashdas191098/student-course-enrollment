package com.scb.course.service.Impl;

import com.scb.course.constants.ApplicationConstants;
import com.scb.course.entity.Courses;
import com.scb.course.exception.APIException;
import com.scb.course.repository.CourseRepository;
import com.scb.course.request.CourseRequest;
import com.scb.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Courses addCourse(CourseRequest courseRequest) {
        Courses courses = buildCourse(courseRequest);
        Courses savedCourses = courseRepository.save(courses);
        return savedCourses;
    }

    private Courses buildCourse(CourseRequest courseRequest) {
        return Courses.builder()
                .title(courseRequest.getTitle())
                .description(courseRequest.getDescription())
                .duration(courseRequest.getDuration())
                //.studentId(courseRequest.getStudentId())
                .build();
    }

    @Override
    public List<Courses> allCourses() {

        return courseRepository.findAll();
    }

    @Override
    public Courses getById(Integer id) {
        Optional<Courses> findCourseById = courseRepository.findById(id);
        if(findCourseById.isEmpty()){
            throw new APIException(ApplicationConstants.COURSES_NOT_FOUND);
        }
        return  findCourseById.get();
    }
}
