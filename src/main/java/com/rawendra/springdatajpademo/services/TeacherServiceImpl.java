package com.rawendra.springdatajpademo.services;


import com.rawendra.springdatajpademo.dto.CourseMaterialRequest;
import com.rawendra.springdatajpademo.dto.CourseRequest;
import com.rawendra.springdatajpademo.dto.TeacherRequest;
import com.rawendra.springdatajpademo.entities.Course;
import com.rawendra.springdatajpademo.entities.CourseMaterial;
import com.rawendra.springdatajpademo.entities.TeacherEntity;
import com.rawendra.springdatajpademo.repositories.CourseMaterialRepository;
import com.rawendra.springdatajpademo.repositories.CustomRepository;
import com.rawendra.springdatajpademo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

  @Autowired
  private TeacherRepository teacherRepository;

  @Autowired
  private CourseMaterialRepository courseMaterialRepository;
  @Autowired
  private CourseService courseService;



  @Override
  public void addTeacher(TeacherRequest teacherRequest) {

    List<Course> courseList = new ArrayList<>();

    teacherRequest.getCourseMaterials().forEach(courseMaterialRequest ->    {
      CourseRequest courseRequest = courseMaterialRequest.getCourseRequest();

      Course courseEntity = Course.builder().title(courseRequest.getTitle())
              .credit(courseRequest.getCredit())
              .build();
      courseList.add(courseEntity);
      CourseMaterial courseMaterialEntity = CourseMaterial.builder()
              .courseMaterialId(courseMaterialRequest.getCourseMaterialId())
              .courseMaterialTopic(courseMaterialRequest.getCourseMaterialTopic())
              .url(courseMaterialRequest.getUrl())
              .course(courseEntity)

              .build();

      courseMaterialRepository.save(courseMaterialEntity);
    });







    TeacherEntity teacherEntity = TeacherEntity.builder().
            firstName(teacherRequest.getFirstName())
            .lastName(teacherRequest.getLastName())
            .courses(courseList)
            .build();

      teacherRepository.save(teacherEntity);

  }
}
