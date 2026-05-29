package com.justmfundo.attendance_register.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.justmfundo.attendance_register.dao.ClassBundleTypeRepository;
import com.justmfundo.attendance_register.dto.StudentBundleDto;
import com.justmfundo.attendance_register.dto.StudentLessonDto;
import com.justmfundo.attendance_register.models.ClassBundleType;
import com.justmfundo.attendance_register.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BundleController {

  @Autowired
  private ClassBundleTypeRepository classBundleTypeRepository;
  
  @PostMapping("/api/new-bundle")
  public String createNewBundle(@RequestBody ClassBundleType classBundleType) {
      //create and save new bundle
      System.out.println(classBundleType.getName());
      classBundleTypeRepository.save(classBundleType);
      return "New Class Bundle Created Successfully";
  }

  @CrossOrigin("http://localhost:4200")
  @PostMapping("/api/assign-class-bundle")
  public Student createOrUpdateStudent(@RequestBody StudentBundleDto newStudentBundle) {
    Student studentToBeAssignedBundle = newStudentBundle.getStudent();
    ClassBundleType bundletoBeAssigned = newStudentBundle.getClassBundleType();

    // find the student. i.e. check if student exists

    // find the bundle. i.e. check if bundle exists

    // Create a new ClassBundle instance based on the ClassBundleType;

    // Add new ClassBundle to student

    return studentToBeAssignedBundle;
  }
  
}
