package com.school.noteappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "classroom")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 5)
    private String name;

    @OneToOne(mappedBy = "classRoom")
    private Teacher teacher;

    @OneToMany(mappedBy = "classRoomId")
    private List<Student> students;



}
