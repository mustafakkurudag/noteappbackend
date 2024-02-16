package com.school.noteappbackend.repository;

import com.school.noteappbackend.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    @Query(value = "SELECT c.name FROM noteappdb.classroom c WHERE c.id = :id", nativeQuery = true)
    String getNameById(Long id);
}
