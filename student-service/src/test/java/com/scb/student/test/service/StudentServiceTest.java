package com.scb.student.test.service;

import com.scb.student.entity.Student;
import com.scb.student.repository.StudentRepository;
import com.scb.student.request.StudentRequest;
import com.scb.student.service.Impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.AssertionErrors;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentService;

    @Test
    public void TestCreateStudent(){
        Mockito.when(studentRepository.save(Mockito.any())).thenReturn(ExpectedStudent());

        Student actualStudent = studentService.addStudent(CreateStudentRequest());

        Assertions.assertNotNull(actualStudent);
        AssertionErrors.assertEquals("equal",ExpectedStudent().getId(),actualStudent.getId());
        AssertionErrors.assertEquals("equal",ExpectedStudent().getName(),actualStudent.getName());
        AssertionErrors.assertEquals("equal",ExpectedStudent().getEmail(),actualStudent.getEmail());
    }

    @Test
    public void TestAllStudents(){
        Mockito.when(studentRepository.findAll()).thenReturn(ExpectedAllStudents());

        List<Student> actualListStudent = studentService.allStudents();

        Assertions.assertNotNull(actualListStudent);
        AssertionErrors.assertEquals("equal",ExpectedAllStudents().size(),actualListStudent.size());
        assertIterableEquals(ExpectedAllStudents(),actualListStudent);
    }

    public StudentRequest CreateStudentRequest(){
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setName("Akash");
        studentRequest.setEmail("akash.a.das@capgemini.com");
        return studentRequest;
    }

    public List<Student> ExpectedAllStudents(){
        List<Student> expectedAllStudents = Arrays.asList(new Student(1,"test","test")
                ,new Student(2,"test","test"));
        return expectedAllStudents;
    }

    public Student ExpectedStudent(){
        return Student.builder()
                .id(1)
                .name("Akash")
                .email("akash.a.das@capgemini.com").build();
    }
}
