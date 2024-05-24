package com.rawendra.springdatajpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterialResponse {
    private Long courseMaterialId;
    private String courseMaterialTopic;
    private String url;
    private CourseResponse courseRequest;
}
