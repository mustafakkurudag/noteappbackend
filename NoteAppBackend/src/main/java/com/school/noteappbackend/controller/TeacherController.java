package com.school.noteappbackend.controller;

import com.school.noteappbackend.dto.StudentDTO;
import com.school.noteappbackend.dto.TeacherDTO;
import com.school.noteappbackend.service.impl.TeacherServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin("http://localhost:3000")
public class TeacherController {

    private TeacherServiceImpl teacherService;

    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        return ResponseEntity.ok().body(teacherService.getAllTeachers());
    }

    @GetMapping("/students/{classId}")
    public ResponseEntity<List<StudentDTO>> getClassStudents(@RequestParam(value = "sortType", defaultValue = "default", required = false) String sortType, @PathVariable("classId") Long id) {
        return ResponseEntity.ok().body(teacherService.getStudentsByClassId(sortType, id));
    }
}
