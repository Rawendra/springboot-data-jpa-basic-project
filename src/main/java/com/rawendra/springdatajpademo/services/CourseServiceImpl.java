package com.rawendra.springdatajpademo.services;

import com.rawendra.springdatajpademo.dto.CourseMaterialRequest;
import com.rawendra.springdatajpademo.dto.CourseRequest;
import com.rawendra.springdatajpademo.entities.Course;
import com.rawendra.springdatajpademo.entities.CourseMaterial;
import com.rawendra.springdatajpademo.repositories.CourseMaterialRepository;
import com.rawendra.springdatajpademo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Override
    public void addCourseDetails(CourseMaterialRequest courseMaterialRequest) {

        CourseRequest courseRequest = courseMaterialRequest.getCourseRequest();

        Course courseEntity = Course.builder().title(courseRequest.getTitle())
                .credit(courseRequest.getCredit())
                .build();

        CourseMaterial courseMaterialEntity = CourseMaterial.builder()
                .courseMaterialId(courseMaterialRequest.getCourseMaterialId())
                .courseMaterialTopic(courseMaterialRequest.getCourseMaterialTopic())
                .url(courseMaterialRequest.getUrl())
                .course(courseEntity)
                .build();
        courseMaterialRepository.save(courseMaterialEntity);

    }
}
