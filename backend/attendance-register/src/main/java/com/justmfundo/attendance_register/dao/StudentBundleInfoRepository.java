package com.justmfundo.attendance_register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.justmfundo.attendance_register.models.StudentBundleInfo;

@CrossOrigin("http://localhost:4200")
public interface StudentBundleInfoRepository extends JpaRepository<StudentBundleInfo, Long> {
  
}
