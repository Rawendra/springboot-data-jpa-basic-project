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
@Table(name = "tbl_teachers")
public class TeacherEntity {

  @Id
  @SequenceGenerator(name = "teacherSequenceGenerator",
          sequenceName = "teacherSequenceGenerator", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherSequenceGenerator")
  private Long teacherId;
  private String firstName;
  private String lastName;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")// name = "teacher_id" will be put in table,referencedColumnName = "teacherId") from this entity
  private List<Course> courses;

}
