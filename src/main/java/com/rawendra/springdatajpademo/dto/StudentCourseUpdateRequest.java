package com.rawendra.springdatajpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseUpdateRequest {

  private Long studentId;
  private List<Long> courseIds;
}
