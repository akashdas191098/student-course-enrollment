package com.scb.student.service.Impl;

import com.scb.student.constants.ApplicationConstants;
import com.scb.student.entity.Student;
import com.scb.student.exception.APIException;
import com.scb.student.repository.StudentRepository;
import com.scb.student.request.StudentRequest;
import com.scb.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(StudentRequest studentRequest) {
        Student student = buildCourse(studentRequest);
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    private Student buildCourse(StudentRequest studentRequest) {
        return Student.builder()
                .name(studentRequest.getName())
                .email(studentRequest.getEmail()).build();
    }

    @Override
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new APIException(ApplicationConstants.STUDENT_NOT_FOUND);
        }
        return student.get();
    }
}
