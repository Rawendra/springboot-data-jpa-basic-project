package com.rawendra.springdatajpademo.dto;

import com.rawendra.springdatajpademo.entities.Course;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CourseMaterialRequest {
    private Long courseMaterialId;
    private String courseMaterialTopic;
    private String url;
    private CourseRequest courseRequest;

}
