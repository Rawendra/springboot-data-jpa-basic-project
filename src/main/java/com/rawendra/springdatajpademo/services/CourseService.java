package com.rawendra.springdatajpademo.services;

import com.rawendra.springdatajpademo.dto.CourseMaterialRequest;
import org.springframework.stereotype.Service;




public interface CourseService {

    void addCourseDetails(CourseMaterialRequest courseMaterialRequest);


}
