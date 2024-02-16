package com.school.noteappbackend.service;

import com.school.noteappbackend.dto.StudentDTO;
import com.school.noteappbackend.dto.TeacherDTO;
import com.school.noteappbackend.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAllTeachers();
    TeacherDTO mapToDto(Teacher teacher);
    List<StudentDTO> getStudentsByClassId(String sortType, Long id);
}
