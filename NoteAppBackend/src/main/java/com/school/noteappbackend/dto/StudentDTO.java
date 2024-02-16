package com.school.noteappbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String name;
    private String surname;
    private String trId;
    private Integer schoolNumber;
    private String className;
    private Double exam1Note;
    private Double exam2Note;
    private Double oralExamNote;
    private Double average;
    private String status;
}
