package com.justmfundo.attendance_register.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justmfundo.attendance_register.models.ClassBundle;

public interface ClassBundleRepository extends JpaRepository<ClassBundle, Long>{
  
}
