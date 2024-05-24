package com.rawendra.springdatajpademo.repositories;


import com.rawendra.springdatajpademo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course,Long> {
}
