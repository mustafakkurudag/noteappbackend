package com.school.noteappbackend.service.impl;

import com.school.noteappbackend.dto.StudentDTO;
import com.school.noteappbackend.model.Student;
import com.school.noteappbackend.repository.ClassRoomRepository;
import com.school.noteappbackend.repository.StudentRepository;
import com.school.noteappbackend.service.StudentService;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
@NoArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO mapToDto(Student student) {
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        studentDTO.setClassName(classRoomRepository.getNameById(student.getClassRoomId()));
        studentDTO.setStatus(student.getStatus() ? "Geçti!" : "Kaldı!");
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for (Student s : students) {
            studentDTOS.add(mapToDto(s));
        }
        return studentDTOS;
    }

    @Override
    public StudentDTO addStudent(Student student) {
        student.setAverage(formatAverage(student));
        student.setStatus(assignStatus(student.getAverage()));
        return mapToDto(studentRepository.save(student));
    }

    @Override
    public StudentDTO getOneStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No student found for the given id!"));
        return mapToDto(student);
    }

    @Override
    public String deleteOneStudentById(Long id) {
        StudentDTO student = getOneStudentById(id);

        if (student != null) {
            studentRepository.deleteById(id);
            return "Student deleted";
        }

        return "No student found for the given id!";
    }

    @Override
    public Student findStudentByTrId(String trId) {
        Student student = studentRepository.findStudentByTrId(trId);

        if (student != null) {
            return student;
        }

        return null;
    }

    @Override
    public String deleteOneStudentByTrId(String trId) {
        Student student = findStudentByTrId(trId);
        if (student != null) {
            studentRepository.deleteStudentByTrId(trId);
            return "Student deleted!";
        }
        return "No student found for the given trId!";
    }

    private Boolean assignStatus(Double average) {
        if (average >= 50) {
            return true;
        } else {
            return false;
        }
    }

    private Double formatAverage(Student student) {
        Double average = (student.getExam1Note() + student.getExam2Note() + student.getOralExamNote()) / 3;
        return (double) Math.round(average);
    }
}
