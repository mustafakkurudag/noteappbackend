package com.school.noteappbackend.service;

import com.school.noteappbackend.dto.StudentDTO;
import com.school.noteappbackend.model.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO addStudent(Student student);
    StudentDTO getOneStudentById(Long id);
    String deleteOneStudentById(Long id);
    Student findStudentByTrId(String trId);
    String deleteOneStudentByTrId(String trId);
    StudentDTO mapToDto(Student student);
}
