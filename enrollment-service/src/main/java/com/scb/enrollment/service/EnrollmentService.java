package com.scb.enrollment.service;

import com.scb.enrollment.Entities.Enrollment;
import com.scb.enrollment.Request.EnrollmentRequest;

public interface EnrollmentService {

    Enrollment doEnrollment(EnrollmentRequest enrollmentRequest);

    Enrollment getById(Integer id);
}
