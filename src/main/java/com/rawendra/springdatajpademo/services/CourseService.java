package com.rawendra.springdatajpademo.services;

import com.rawendra.springdatajpademo.dto.CourseMaterialRequest;
import com.rawendra.springdatajpademo.dto.CourseMaterialResponse;
import com.rawendra.springdatajpademo.dto.CourseRequest;
import com.rawendra.springdatajpademo.dto.CourseResponse;
import com.rawendra.springdatajpademo.entities.CourseMaterial;
import org.springframework.stereotype.Service;




public interface CourseService {

    void addCourseDetails(CourseMaterialRequest courseMaterialRequest);

    void dosomething();


    public CourseMaterialResponse getCourseMaterialDetails(Long courseMaterialId);

    public CourseResponse getCourseDetails(Long courseId);

  public  void addCourseDetailsWithCourseRequest(CourseRequest courseRequest);
}
