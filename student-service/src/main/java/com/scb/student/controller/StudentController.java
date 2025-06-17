package com.scb.student.controller;

import com.scb.student.entity.Student;
import com.scb.student.request.StudentRequest;
import com.scb.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<Student> saveStudents(@RequestBody StudentRequest studentRequest){
        Student student = studentService.addStudent(studentRequest);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> allStudents(){
        List<Student> studentList = studentService.allStudents();
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Student getStudentsById(@PathVariable("id") Integer id){
        Student student = studentService.getById(id);
        return student;
    }
}
