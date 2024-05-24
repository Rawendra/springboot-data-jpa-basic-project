package com.rawendra.springdatajpademo.controllers;

import com.rawendra.springdatajpademo.dto.CourseMaterialRequest;
import com.rawendra.springdatajpademo.dto.CourseMaterialResponse;
import com.rawendra.springdatajpademo.entities.CourseMaterial;
import com.rawendra.springdatajpademo.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping()
    public void addCourse(@RequestBody CourseMaterialRequest courseMaterialRequest){

        courseService.addCourseDetails(courseMaterialRequest);

    }

    @GetMapping(value = "/{courseMaterialId}")
    public CourseMaterialResponse getCourseMaterialDetails(@PathVariable Long courseMaterialId){
        return courseService.getCourseMaterialDetails(courseMaterialId);
    }
}
