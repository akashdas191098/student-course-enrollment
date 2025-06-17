package com.scb.student.service;

import com.scb.student.entity.Student;
import com.scb.student.request.StudentRequest;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentRequest studentRequest);

    List<Student> allStudents();

    Student getById(Integer id);
}
