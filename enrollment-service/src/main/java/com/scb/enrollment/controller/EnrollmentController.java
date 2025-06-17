package com.scb.enrollment.controller;

import com.scb.enrollment.Entities.Enrollment;
import com.scb.enrollment.Request.EnrollmentRequest;
import com.scb.enrollment.service.EnrollmentService;
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
    public ResponseEntity<Enrollment> saveEnrollment(@RequestBody EnrollmentRequest enrollmentRequest){
        Enrollment enrollment=enrollmentService.doEnrollment(enrollmentRequest);
        return  new ResponseEntity<Enrollment>(enrollment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getById(@PathVariable("id") Integer id){
        Enrollment enrollment = enrollmentService.getById(id);
        return new ResponseEntity<Enrollment>(enrollment,HttpStatus.OK);
    }
}
