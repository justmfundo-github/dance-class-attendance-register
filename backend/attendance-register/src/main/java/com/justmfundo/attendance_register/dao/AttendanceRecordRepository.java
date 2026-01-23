package com.justmfundo.attendance_register.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.justmfundo.attendance_register.models.AttendanceRecord;
import com.justmfundo.attendance_register.models.DanceLesson;
import com.justmfundo.attendance_register.models.Student;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "attendanceRecord", path = "attendance-history")
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Long> {
  AttendanceRecord findByStudentAndDanceSession(Student student, DanceLesson danceSession);

  // List<AttendanceRecord> findByStudentId(Long id);

  List<AttendanceRecord> findByDanceSession(DanceLesson danceSession);

}
