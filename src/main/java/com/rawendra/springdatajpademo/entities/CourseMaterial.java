package com.rawendra.springdatajpademo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "courseMaterialSequenceGenerator",
            sequenceName = "courseMaterialSequenceGenerator", allocationSize = 1)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,
            generator = "courseMaterialSequenceGenerator")
    private Long courseMaterialId;
    private String courseMaterialTopic;
    private String url;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course course;

}
