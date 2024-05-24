package com.rawendra.springdatajpademo.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "courseMaterialSequenceGenerator",
            sequenceName = "courseMaterialSequenceGenerator", allocationSize = 1)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,
            generator = "courseMaterialSequenceGenerator")
    private Long courseMaterialId;
    private String courseMaterialTopic;
    private String url;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course course;

}
