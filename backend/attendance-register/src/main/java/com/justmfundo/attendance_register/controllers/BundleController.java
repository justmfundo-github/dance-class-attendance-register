package com.justmfundo.attendance_register.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.justmfundo.attendance_register.dao.ClassBundleRepository;
import com.justmfundo.attendance_register.dao.ClassBundleTypeRepository;
import com.justmfundo.attendance_register.dao.StudentRepository;
import com.justmfundo.attendance_register.dto.StudentBundleTypeDto;
import com.justmfundo.attendance_register.dto.StudentLessonDto;
import com.justmfundo.attendance_register.models.ClassBundle;
import com.justmfundo.attendance_register.models.ClassBundleType;
import com.justmfundo.attendance_register.models.Student;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BundleController {

  @Autowired
  private ClassBundleTypeRepository classBundleTypeRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private ClassBundleRepository classBundleInstanceRepository;
  
  @CrossOrigin("http://localhost:4200")
  @PostMapping("/api/new-bundle")
  public String createNewBundle(@RequestBody ClassBundleType classBundleType) {
      //create and save new bundle
      System.out.println(classBundleType.getName());
      classBundleTypeRepository.save(classBundleType);
      return "New Class Bundle Created Successfully";
  }

  @CrossOrigin("http://localhost:4200")
  @PutMapping("/api/assign-class-bundle")
  public Student assignClassBundle(@RequestBody StudentBundleTypeDto newStudentBundle) {
    System.out.println("Assigning the dto work successfully..........******************");
    Student studentToBeAssignedBundle = newStudentBundle.getStudent();
    ClassBundleType classBundleTypeToAssign = newStudentBundle.getClassBundleType();
    System.out.println("Processing the addition of a class bundle to a student");
    System.out.println(studentToBeAssignedBundle.getFirstName() + "   ID: " + studentToBeAssignedBundle.getStudentId());
    System.out.println(classBundleTypeToAssign.getName() + "   ID: " + classBundleTypeToAssign.getId());

    // find the student. i.e. check if student exists
    // find the bundle. i.e. check if bundle exists
    if(studentRepository.existsById(studentToBeAssignedBundle.getStudentId()) && classBundleTypeRepository.existsById(classBundleTypeToAssign.getId())){
      // Create a new ClassBundle instance based on the ClassBundleType and save class bundle to the database
      ClassBundle classBundle = new ClassBundle(studentToBeAssignedBundle, classBundleTypeToAssign, LocalDate.now(), LocalDate.now().plusDays(classBundleTypeToAssign.getDaysValid()), classBundleTypeToAssign.getDaysValid());
      System.out.println("Student and ClassBundleType both exist!!");
      //Save the new class bundle NB: In this case the bundle instance saves the id of the student. I.e. ClassBundle manages the relationship 
      classBundleInstanceRepository.save(classBundle);
    }

    return studentToBeAssignedBundle;
  }
  
}
