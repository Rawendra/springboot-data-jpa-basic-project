package com.rawendra.springdatajpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private Long studentId;
    private String studentName;
    private String emailId;
    private String guardianName;
    private String guardianEmailId;
    private String guardianMobile;
}
