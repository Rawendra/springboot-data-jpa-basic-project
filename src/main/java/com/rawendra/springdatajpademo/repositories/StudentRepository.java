package com.rawendra.springdatajpademo.repositories;

import com.rawendra.springdatajpademo.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    public List<StudentEntity> findByStudentNameContaining(String name);
    public StudentEntity findByStudentId(Long id);

}
