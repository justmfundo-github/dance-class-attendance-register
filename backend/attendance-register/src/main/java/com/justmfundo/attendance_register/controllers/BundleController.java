package com.justmfundo.attendance_register.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.justmfundo.attendance_register.dao.ClassBundleTypeRepository;
import com.justmfundo.attendance_register.dao.StudentRepository;
import com.justmfundo.attendance_register.dto.StudentBundleDto;
import com.justmfundo.attendance_register.dto.StudentLessonDto;
import com.justmfundo.attendance_register.models.ClassBundle;
import com.justmfundo.attendance_register.models.ClassBundleType;
import com.justmfundo.attendance_register.models.Student;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BundleController {

  @Autowired
  private ClassBundleTypeRepository classBundleTypeRepository;

  @Autowired
  private StudentRepository studentRepository;
  
  @PostMapping("/api/new-bundle")
  public String createNewBundle(@RequestBody ClassBundleType classBundleType) {
      //create and save new bundle
      System.out.println(classBundleType.getName());
      classBundleTypeRepository.save(classBundleType);
      return "New Class Bundle Created Successfully";
  }

  @CrossOrigin("http://localhost:4200")
  @PostMapping("/api/assign-class-bundle")
  public Student assignClassBundle(@RequestBody StudentBundleDto newStudentBundle) {
    Student studentToBeAssignedBundle = newStudentBundle.getStudent();
    System.out.println(newStudentBundle);
    ClassBundleType bundletoBeAssigned = newStudentBundle.getClassBundleType();

    System.out.println(studentToBeAssignedBundle.getFirstName());
    System.out.println(bundletoBeAssigned.getName());     

    // find the student. i.e. check if student exists
    // find the bundle. i.e. check if bundle exists
    if(studentRepository.existsById(studentToBeAssignedBundle.getStudentId()) && classBundleTypeRepository.existsById(bundletoBeAssigned.getId())){
      // Create a new ClassBundle instance based on the ClassBundleType;
      ClassBundle classBundle = new ClassBundle(studentToBeAssignedBundle, bundletoBeAssigned, LocalDate.now(), LocalDate.now().plusDays(bundletoBeAssigned.getDaysValid()), bundletoBeAssigned.getDaysValid());
      System.out.println(classBundle);
      // Add new ClassBundle to student
    }

    return studentToBeAssignedBundle;
  }
  
}
