package com.rawendra.springdatajpademo.repositories;

import com.rawendra.springdatajpademo.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
}
