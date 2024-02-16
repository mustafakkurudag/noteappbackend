package com.school.noteappbackend.dto;

import com.school.noteappbackend.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoomDTO {

    private String name;
    private List<Student> students;
}
