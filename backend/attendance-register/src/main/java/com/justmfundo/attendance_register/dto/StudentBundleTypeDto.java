package com.justmfundo.attendance_register.dto;

import com.justmfundo.attendance_register.models.ClassBundleType;
import com.justmfundo.attendance_register.models.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentBundleTypeDto {
  private Student student;
  private ClassBundleType classBundleType;
}
