package com.rawendra.springdatajpademo.services;

import com.rawendra.springdatajpademo.dto.CourseMaterialRequest;
import com.rawendra.springdatajpademo.dto.CourseMaterialResponse;
import com.rawendra.springdatajpademo.entities.CourseMaterial;
import org.springframework.stereotype.Service;




public interface CourseService {

    void addCourseDetails(CourseMaterialRequest courseMaterialRequest);


    public CourseMaterialResponse getCourseMaterialDetails(Long courseMaterialId);
}
