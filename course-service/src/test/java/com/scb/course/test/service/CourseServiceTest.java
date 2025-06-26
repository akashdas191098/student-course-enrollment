package com.scb.course.test.service;

import com.scb.course.entity.Courses;
import com.scb.course.repository.CourseRepository;
import com.scb.course.request.CourseRequest;
import com.scb.course.service.Impl.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @InjectMocks
    CourseServiceImpl courseService;

    @Mock
    CourseRepository courseRepository;

    @Test
    public void addCourseTest(){
        when(courseRepository.save(Mockito.any())).thenReturn(expectedCourse());
        Courses actualCourses = courseService.addCourse(createCourseRequest());
        assertNotNull("equal",actualCourses);
        assertEquals("equal",expectedCourse().getId(),actualCourses.getId());
        assertEquals("equal",expectedCourse().getTitle(),actualCourses.getTitle());
        assertEquals("equal",expectedCourse().getDuration(),actualCourses.getDuration());
        assertEquals("equal",expectedCourse().getDescription(),actualCourses.getDescription());

    }

    @Test
    public void getByIdTest(){
        when(courseRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(expectedCourse()));
        Courses actualCourse = courseService.getById(Mockito.anyInt());
        assertNotNull("equal",actualCourse);
        assertEquals("equal",expectedCourse().getId(),actualCourse.getId());
        assertEquals("equal",expectedCourse().getTitle(),actualCourse.getTitle());
        assertEquals("equal",expectedCourse().getDuration(),actualCourse.getDuration());
        assertEquals("equal",expectedCourse().getDescription(),actualCourse.getDescription());

    }

    @Test
    public void getAllCoursesTest(){
        when(courseRepository.findAll()).thenReturn(expectedListCourses());

        List<Courses> actualCourses = courseService.allCourses();

        assertNotNull("equal",actualCourses);
        assertEquals("equal",expectedListCourses().size(),actualCourses.size());
        assertIterableEquals(expectedListCourses(),actualCourses);
    }

    public List<Courses> expectedListCourses(){
        List<Courses> expectedCourses = Arrays.asList(new Courses(1,"test","test","test")
        ,new Courses(2,"test","test","test"));
        return expectedCourses;
    }

    public CourseRequest createCourseRequest(){
        CourseRequest courseRequest = new CourseRequest();
        courseRequest.setTitle("XYZ");
        courseRequest.setDuration("XYZ");
        courseRequest.setDescription("XYZ");
        return courseRequest;
    }

    public Courses expectedCourse(){
        return Courses.builder().id(1).title("xyz")
                .description("XYZ")
                .duration("XYZ").build();

    }
}
