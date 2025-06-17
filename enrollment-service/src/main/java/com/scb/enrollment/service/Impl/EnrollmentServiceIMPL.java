package com.scb.enrollment.service.Impl;

import com.scb.enrollment.Entities.Courses;
import com.scb.enrollment.Entities.Enrollment;
import com.scb.enrollment.Entities.Student;
import com.scb.enrollment.Repositories.EnrollRepository;
import com.scb.enrollment.Request.EnrollmentRequest;
import com.scb.enrollment.constants.ApplicationConstants;
import com.scb.enrollment.exception.APIException;
import com.scb.enrollment.exception.InvalidException;
import com.scb.enrollment.service.CourseClient;
import com.scb.enrollment.service.EnrollmentService;
import com.scb.enrollment.service.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService {

    @Autowired
    private EnrollRepository enrollRepository;

    @Autowired
    private CourseClient courseClient;

    @Autowired
    private StudentClient studentClient;

    @Override
    public Enrollment doEnrollment(EnrollmentRequest enrollmentRequest) {
        Courses courses = courseClient.getCourseById(enrollmentRequest.getCourseId());
        Student student = studentClient.getStudentsById(enrollmentRequest.getStudentId());
        Enrollment enrollment = new Enrollment();
        enrollment.setCourses(courses.getId());
        enrollment.setStudent(student.getId());
        enrollment.setStatus(ApplicationConstants.ENROLLED);

        Enrollment savedEnrollment = enrollRepository.save(enrollment);
        return savedEnrollment;
    }

    @Override
    public Enrollment getById(Integer id) {
        if(id<1){
            throw new InvalidException(ApplicationConstants.INVALID_ENROLLMENT_ID);
        }
        Optional<Enrollment> enrollment = enrollRepository.findById(id);
        if(enrollment.isEmpty()){
            throw new APIException(ApplicationConstants.ENROLLMENT_NOT_FOUND);
        }
        return enrollment.get();
    }
}
