package com.school.noteappbackend.repository;

import com.school.noteappbackend.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM noteappdb.student s WHERE s.class_room_id = :id", nativeQuery = true)
    List<Student> getStudentsByClassId(Long id);

    @Transactional
    Student findStudentByTrId(String trId);

    @Transactional
    void deleteStudentByTrId(String trId);

}
