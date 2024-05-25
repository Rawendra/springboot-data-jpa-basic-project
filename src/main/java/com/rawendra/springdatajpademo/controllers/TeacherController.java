package com.rawendra.springdatajpademo.controllers;

import com.rawendra.springdatajpademo.dto.TeacherRequest;
import com.rawendra.springdatajpademo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {


  @Autowired
  private TeacherService teacherService;


  @PostMapping("")
  public void addTeacher(@RequestBody TeacherRequest teacherRequest) {
      teacherService.addTeacher(teacherRequest);
  }
}
