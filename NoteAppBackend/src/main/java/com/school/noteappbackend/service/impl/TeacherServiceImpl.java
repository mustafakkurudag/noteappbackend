package com.school.noteappbackend.service.impl;

import com.school.noteappbackend.dto.StudentDTO;
import com.school.noteappbackend.dto.TeacherDTO;
import com.school.noteappbackend.model.Student;
import com.school.noteappbackend.model.Teacher;
import com.school.noteappbackend.repository.ClassRoomRepository;
import com.school.noteappbackend.repository.TeacherRepository;
import com.school.noteappbackend.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private ClassRoomServiceImpl classRoomService;
    private ModelMapper modelMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, ModelMapper modelMapper,
                              ClassRoomServiceImpl classRoomService) {
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
        this.classRoomService = classRoomService;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOS = new ArrayList<>();

        for (Teacher t : teachers) {
            teacherDTOS.add(mapToDto(t));
        }

        return teacherDTOS;
    }

    @Override
    public TeacherDTO mapToDto(Teacher teacher) {
        TeacherDTO teacherDTO = modelMapper.map(teacher, TeacherDTO.class);
        return teacherDTO;
    }

    @Override
    public List<StudentDTO> getStudentsByClassId(String sortType, Long id) {
        List<StudentDTO> studentDTOS = classRoomService.getStudents(id);
        if (!sortType.equals("default"))
            sortList(studentDTOS, sortType);
        return studentDTOS;
    }

    private void sortList(List<StudentDTO> studentDTOList, String sortType) {
        Comparator<StudentDTO> stdComparator = null;

        switch(sortType) {
            case "a-z":
                stdComparator = Comparator.comparing(StudentDTO::getName);
                break;
            case "z-a":
                stdComparator = Comparator.comparing(StudentDTO::getName).reversed();
                break;
            case "0-9-exam1":
                stdComparator = Comparator.comparing(StudentDTO::getExam1Note);
                break;
            case "9-0-exam1":
                stdComparator = Comparator.comparing(StudentDTO::getExam1Note).reversed();
                break;
            case "0-9-exam2":
                stdComparator = Comparator.comparing(StudentDTO::getExam2Note);
                break;
            case "9-0-exam2":
                stdComparator = Comparator.comparing(StudentDTO::getExam2Note).reversed();
                break;
            case "0-9-oralExam":
                stdComparator = Comparator.comparing(StudentDTO::getOralExamNote);
                break;
            case "9-0-oralExam":
                stdComparator = Comparator.comparing(StudentDTO::getOralExamNote).reversed();
                break;
            case "0-9-average":
                stdComparator = Comparator.comparing(StudentDTO::getAverage);
                break;
            case "9-0-average":
                stdComparator = Comparator.comparing(StudentDTO::getAverage).reversed();
                break;
            default:
                System.out.println("No need to compare!");
                break;
        }

        if(stdComparator != null) {
            studentDTOList.sort(stdComparator);
        }
    }
}
