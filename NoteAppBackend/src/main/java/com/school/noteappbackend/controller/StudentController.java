package com.school.noteappbackend.controller;

import com.school.noteappbackend.dto.StudentDTO;
import com.school.noteappbackend.model.Student;
import com.school.noteappbackend.service.impl.StudentServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@NoArgsConstructor
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody Student student) {
        StudentDTO newStudent = studentService.addStudent(student);
        return ResponseEntity.ok().body(newStudent);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<StudentDTO> getOneStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(studentService.getOneStudentById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(studentService.deleteOneStudentById(id));
    }

    @DeleteMapping("/deletebytrid/{trId}")
    public ResponseEntity<String> deleteStudentByTrId(@PathVariable("trId") String trId) {
        return ResponseEntity.ok().body(studentService.deleteOneStudentByTrId(trId));
    }
}
