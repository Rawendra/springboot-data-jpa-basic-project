package com.rawendra.springdatajpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponse {  private Long teacherId;
  private String firstName;
  private String lastName;
  private List<CourseResponse> courses;

}
