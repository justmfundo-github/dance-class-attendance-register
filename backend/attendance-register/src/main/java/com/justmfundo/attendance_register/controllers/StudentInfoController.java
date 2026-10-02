package com.justmfundo.attendance_register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.justmfundo.attendance_register.dao.AttendanceRecordRepository;
import com.justmfundo.attendance_register.dao.DanceLessonRepository;
import com.justmfundo.attendance_register.dao.StudentInformationRepository;
import com.justmfundo.attendance_register.dto.StudentClassInfoDto;
import com.justmfundo.attendance_register.models.AttendanceRecord;
import com.justmfundo.attendance_register.models.ClassBundleType;
import com.justmfundo.attendance_register.models.DanceLesson;

@RestController
public class StudentInfoController {

  @Autowired
  private StudentInformationRepository studentInformationRepository;

  @Autowired 
  private DanceLessonRepository danceLessonRepository;
  
  @Autowired 
  private AttendanceRecordRepository attendanceRecordRepository;
  

  @CrossOrigin("http://localhost:4200")
  @GetMapping("/api/student-class-info")
  public List<StudentClassInfoDto> getStudentClassInfo() {
    List<StudentClassInfoDto> studentClassInfo = studentInformationRepository.findAllClassInfoDtos();
    for(StudentClassInfoDto studInfo : studentClassInfo){
      System.out.println(studInfo.getFirstName() + " : " + studInfo.getLastName());
    }
    return studentClassInfo;
  }

  @CrossOrigin("http://localhost:4200")
  @GetMapping("/api/attendance-record/{id}")
  public List<AttendanceRecord> getAttendanceRecords(@PathVariable Long id) {
    DanceLesson danceLesson = danceLessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dance Lesson not found! "));
    List<AttendanceRecord> attendanceRecords = attendanceRecordRepository.findByDanceSession(danceLesson);
    // for(StudentClassInfoDto studInfo : studentClassInfo){
    //   System.out.println(studInfo.getFirstName() + " : " + studInfo.getLastName());
    // }
    return attendanceRecords;
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
