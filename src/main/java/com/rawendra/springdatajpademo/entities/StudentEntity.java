package com.rawendra.springdatajpademo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_student", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email_address"))
public class StudentEntity {

    @Id
    @SequenceGenerator(name="student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    private String studentName;
    @Column(name="email_address", nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;

    @ManyToMany
    @JoinTable(name = "student_course_map",
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId")

    )
    private List<Course> courses;






}
