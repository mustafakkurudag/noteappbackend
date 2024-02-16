package com.school.noteappbackend.service.impl;

import com.school.noteappbackend.dto.StudentDTO;
import com.school.noteappbackend.model.Student;
import com.school.noteappbackend.repository.ClassRoomRepository;
import com.school.noteappbackend.repository.StudentRepository;
import com.school.noteappbackend.service.ClassRoomService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private StudentRepository studentRepository;
    private StudentServiceImpl studentService;

    public ClassRoomServiceImpl(StudentRepository studentRepository, StudentServiceImpl studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @Override
    public List<StudentDTO> getStudents(Long id) {
        List<Student> students = studentRepository.getStudentsByClassId(id);
        List<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student s : students) {
            studentDTOS.add(studentService.mapToDto(s));
        }

        return studentDTOS;
    }
}
