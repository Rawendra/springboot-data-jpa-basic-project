package com.rawendra.springdatajpademo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @SequenceGenerator(name = "courseMaterialSequenceGenerator",
            sequenceName = "courseMaterialSequenceGenerator", allocationSize = 1)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,
            generator = "courseMaterialSequenceGenerator")
    private Long courseId;
    private String title;
    private Integer credit;


}
