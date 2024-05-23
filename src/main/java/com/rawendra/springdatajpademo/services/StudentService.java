package com.rawendra.springdatajpademo.services;

import com.rawendra.springdatajpademo.dto.StudentRequest;
import com.rawendra.springdatajpademo.dto.StudentResponse;
import com.rawendra.springdatajpademo.entities.Guardian;
import com.rawendra.springdatajpademo.entities.StudentEntity;
import com.rawendra.springdatajpademo.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private StudentResponse studentEntityToResponse(StudentEntity studentEntity) {
        return StudentResponse.builder()
                .studentName(studentEntity.getStudentName())
                .emailId(studentEntity.getEmailId())
                .guardianEmailId(studentEntity.getGuardian().getEmail())
                .guardianName(studentEntity.getGuardian().getName())
                .guardianMobile(studentEntity.getGuardian().getMobile())
                .studentId(studentEntity.getStudentId())
                .build();
    }

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream().map(this::studentEntityToResponse).collect(Collectors.toList());
    }

    public void addStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = StudentEntity.builder().
                studentName(studentRequest.getStudentName())
                .emailId(studentRequest.getEmailId())
                .guardian(Guardian.builder()
                        .email(studentRequest.getGuardianEmailId())
                        .name(studentRequest.getGuardianName())
                        .mobile(studentRequest.getGuardianMobile()).build())
                .build();
        studentRepository.save(studentEntity);
    }

    public List<StudentResponse> getStudentByName(String name) {
        List<StudentEntity> studentEntities = studentRepository.findByStudentNameContaining(name);

        return studentEntities.stream().map(this::studentEntityToResponse).collect(Collectors.toList());


    }

    public StudentResponse findByStudentId(Long id){
        return studentEntityToResponse(studentRepository.findByStudentId(id));
    }
}
