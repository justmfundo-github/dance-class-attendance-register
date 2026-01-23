package com.justmfundo.attendance_register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.justmfundo.attendance_register.models.Student;

@CrossOrigin("http://localhost:4200")
public interface StudentRepository extends JpaRepository<Student, Long>{
  Student findByFirstName(String firstName);

  Boolean existsByFirstName(String firstName);

}
