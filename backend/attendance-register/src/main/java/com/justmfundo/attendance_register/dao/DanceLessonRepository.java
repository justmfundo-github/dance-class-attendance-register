package com.justmfundo.attendance_register.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.justmfundo.attendance_register.models.ClassLevel;
import com.justmfundo.attendance_register.models.ClassType;
import com.justmfundo.attendance_register.models.DanceLesson;

@CrossOrigin("http://localhost:4200")
public interface DanceLessonRepository extends JpaRepository<DanceLesson, Long>{
  List<DanceLesson> findByClassDate(LocalDate classDate);
  
  DanceLesson findByClassDateAndClassTimeAndClassTypeAndClassLevel(LocalDate classDate, LocalTime classTime, ClassType ClassType, ClassLevel classLevel);
}
