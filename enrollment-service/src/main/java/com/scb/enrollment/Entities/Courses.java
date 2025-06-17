package com.scb.enrollment.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Courses {

    private Integer id;
    private String title;
    private String description;
    private String duration;
    //private Long studentId;
}