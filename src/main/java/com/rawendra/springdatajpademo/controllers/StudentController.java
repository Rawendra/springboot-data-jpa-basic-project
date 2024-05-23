package com.rawendra.springdatajpademo.controllers;


import com.rawendra.springdatajpademo.dto.StudentRequest;
import com.rawendra.springdatajpademo.dto.StudentResponse;
import com.rawendra.springdatajpademo.entities.StudentEntity;
import com.rawendra.springdatajpademo.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("")
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();

    }

    @PostMapping("")
    public void addStudent(@RequestBody StudentRequest studentRequest) {
        studentService.addStudent(studentRequest);
    }

    @GetMapping("/name/{name}")
    public List<StudentResponse> getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }
    @GetMapping("/id/{id}")
    public StudentResponse  findByStudentId(@PathVariable Long id) {
        return studentService.findByStudentId(id);
    }
}
