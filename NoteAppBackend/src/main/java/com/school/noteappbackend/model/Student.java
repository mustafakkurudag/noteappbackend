package com.school.noteappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tr_id", length = 11, nullable = false, unique = true)
    private String trId;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @Column(name = "surname", length = 15, nullable = false)
    private String surname;

    @Column(name = "school_number", nullable = false, unique = true)
    private Integer schoolNumber;

    @Column(name = "class_room_id", nullable = false)
    private Long classRoomId;

    @Column(name = "exam1_note", nullable = false)
    private Double exam1Note;

    @Column(name = "exam2_note", nullable = false)
    private Double exam2Note;

    @Column(name = "oral_exam_note", nullable = false)
    private Double oralExamNote;

    @Column(name = "average", nullable = false)
    private Double average;

    @Column(name = "status")
    private Boolean status;

}
