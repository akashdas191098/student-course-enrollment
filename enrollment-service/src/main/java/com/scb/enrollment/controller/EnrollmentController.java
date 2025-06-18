package com.scb.enrollment.controller;

import com.scb.enrollment.Entities.Enrollment;
import com.scb.enrollment.Request.EnrollmentRequest;
import com.scb.enrollment.service.EnrollmentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/")
    @CircuitBreaker(name = "enrollment-circuit-breaker", fallbackMethod = "EnrollmentFallback")
    public ResponseEntity<Enrollment> saveEnrollment(@RequestBody EnrollmentRequest enrollmentRequest){
        Enrollment enrollment=enrollmentService.doEnrollment(enrollmentRequest);
        return  new ResponseEntity<Enrollment>(enrollment, HttpStatus.CREATED);
    }

    public ResponseEntity<Enrollment> EnrollmentFallback(EnrollmentRequest enrollmentRequest, Exception exception){
        Enrollment enrollment = Enrollment.builder()
                .courses(000)
                .student(000)
                .status("This enrollment is created dummy because some service is down").build();
        return new ResponseEntity<Enrollment>(enrollment,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getById(@PathVariable("id") Integer id){
        Enrollment enrollment = enrollmentService.getById(id);
        return new ResponseEntity<Enrollment>(enrollment,HttpStatus.OK);
    }
}
