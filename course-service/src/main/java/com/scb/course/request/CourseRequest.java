package com.scb.course.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private String title;
    private String description;
    private String duration;
    //private Long studentId;
}
