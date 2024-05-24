package com.rawendra.springdatajpademo.repositories;

import com.rawendra.springdatajpademo.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    public List<StudentEntity> findByStudentNameContaining(String name);

    public StudentEntity findByStudentId(Long id);

    //JPQL query
    @Query("select s from StudentEntity s where s.emailId =?1")
    public StudentEntity getStudentDetailsByEmailId(String emailId);

    @Query(value = "select s.student_name from tbl_student s where s.email_address =?1", nativeQuery = true)
    public List<StudentEntity> getGaurdianName(String email_address);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set student_name =?1 where email_address =?2",
            nativeQuery = true)
    public int updateStudentByEmailId(String firstname, String emailid);

}
