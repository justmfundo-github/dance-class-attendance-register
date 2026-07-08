package com.justmfundo.attendance_register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justmfundo.attendance_register.dao.StudentInformationRepository;
import com.justmfundo.attendance_register.dto.StudentClassInfoDto;

@RestController
public class StudentInfoController {

  @Autowired
  private StudentInformationRepository studentInformationRepository;
  

  @CrossOrigin("http://localhost:4200")
  @GetMapping("/api/student-class-info")
  public List<StudentClassInfoDto> getStudentClassInfo() {
    List<StudentClassInfoDto> studentClassInfo = studentInformationRepository.findAllClassInfoDtos();
    for(StudentClassInfoDto studInfo : studentClassInfo){
      System.out.println(studInfo.getFirstName() + " : " + studInfo.getLastName());
    }
    return studentClassInfo;
  }

  // @CrossOrigin("http://localhost:4200")
  // @GetMapping("/api/student-bundle-info")
  // public List<StudentBundleInfo> getStudentBundleInfo() {
  //   List<StudentBundleInfo> studentClassInfo = studentInformationRepository.findAllClassInfos();
  //   for(StudentBundleInfo studInfo : studentClassInfo){
  //     System.out.println(studInfo.getFirstName() + " : " + studInfo.getLastName());
  //   }
  //   return studentClassInfo;
  // }
}
