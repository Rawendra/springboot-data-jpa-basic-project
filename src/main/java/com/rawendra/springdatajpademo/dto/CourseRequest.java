package com.rawendra.springdatajpademo.dto;

import com.rawendra.springdatajpademo.entities.CourseMaterial;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private Long courseId;
    private String title;
    private Integer credit;
    private CourseMaterialRequest courseMaterial;

}
