package com.rawendra.springdatajpademo.dto;

import com.rawendra.springdatajpademo.entities.CourseMaterial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TeacherRequest {
  private String firstName;
  private String lastName;
  private List<CourseMaterialRequest> courseMaterials;
}
