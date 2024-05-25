package com.rawendra.springdatajpademo.services;

import com.rawendra.springdatajpademo.dto.CourseMaterialRequest;
import com.rawendra.springdatajpademo.dto.CourseMaterialResponse;
import com.rawendra.springdatajpademo.dto.CourseRequest;
import com.rawendra.springdatajpademo.dto.CourseResponse;
import com.rawendra.springdatajpademo.entities.Course;
import com.rawendra.springdatajpademo.entities.CourseMaterial;
import com.rawendra.springdatajpademo.repositories.CourseMaterialRepository;
import com.rawendra.springdatajpademo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

  @Override
  public CourseMaterialResponse getCourseMaterialDetails(Long courseMaterialId) {
    Optional<CourseMaterial> courseMaterialOptional = courseMaterialRepository.findById(courseMaterialId);
    CourseMaterialResponse courseMaterialResponse = null;
    if (courseMaterialOptional.isPresent()) {
      System.out.println(courseMaterialOptional.get());
      Course course = courseMaterialOptional.get().getCourse();

      CourseResponse courseResponse = null;
      if (course != null) {
        courseResponse = CourseResponse.builder().
                courseId(course.getCourseId())
                .credit(course.getCredit())
                .title(course.getTitle())
                .build();
      }
      courseMaterialResponse = CourseMaterialResponse.builder().
              courseMaterialTopic(courseMaterialOptional.get().getCourseMaterialTopic())
              .course(courseResponse).
              courseMaterialId(courseMaterialOptional.get().getCourseMaterialId())
              .build();
    }

    return courseMaterialResponse;
  }

  @Override
  public CourseResponse getCourseDetails(Long courseId) {

    CourseResponse response = null;
    Optional<Course> courseOptional = courseRepository.findById(courseId);

    if (courseOptional.isPresent()) {

      CourseMaterial courseMaterial = courseOptional.get().getCourseMaterial();
      CourseMaterialResponse courseMaterialResponse = CourseMaterialResponse.builder().
              courseMaterialTopic(courseMaterial.getCourseMaterialTopic()).
              courseMaterialId(courseMaterial.getCourseMaterialId())
              .url(courseMaterial.getUrl()).
              build();

      response = CourseResponse.builder()
              .title(courseOptional.get().getTitle())
              .courseId(courseOptional.get().getCourseId()).credit(courseOptional.get().getCredit())
              .courseMaterialResponse(courseMaterialResponse)
              .build();
    }
    return response;
  }

  @Override
  public void addCourseDetailsWithCourseRequest(CourseRequest courseRequest) {



    Course course = Course.builder().
            credit(courseRequest.getCredit()).title(courseRequest.getTitle())
            .build();
    CourseMaterial courseMaterial = CourseMaterial.builder().
            courseMaterialTopic(courseRequest.getCourseMaterial().getCourseMaterialTopic())
            .url(courseRequest.getCourseMaterial().getUrl())
            .course(course)
            .build();
    //courseRepository.save(course);
      courseMaterialRepository.save(courseMaterial);
    ;
  }
}
