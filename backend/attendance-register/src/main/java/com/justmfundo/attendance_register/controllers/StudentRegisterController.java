package com.justmfundo.attendance_register.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.justmfundo.attendance_register.dao.AttendanceRecordRepository;
import com.justmfundo.attendance_register.dao.DanceLessonRepository;
import com.justmfundo.attendance_register.dao.StudentRepository;
import com.justmfundo.attendance_register.models.AttendanceRecord;
import com.justmfundo.attendance_register.models.ClassLevel;
import com.justmfundo.attendance_register.models.DanceLesson;
import com.justmfundo.attendance_register.models.PaymentType;
import com.justmfundo.attendance_register.models.Student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentRegisterController {
  @Autowired
  private DanceLessonRepository danceLessonRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private AttendanceRecordRepository attendanceRecordRepository;
  
  @GetMapping("/api/lessons")
  public List<DanceLesson> getDanceLessons() {
    List<DanceLesson> danceLessonList = danceLessonRepository.findByClassDate(LocalDate.of(2025, Month.JANUARY, 19));
    // System.out.println( "Number of Total dance lessons on the day: " + danceList.size());

    // for(DanceLesson tempDanceLesson : danceList){
    //   System.out.println(tempDanceLesson.getClassDate() + ":\t" + tempDanceLesson.getClassLevel());
    //   int studentsPerLesson = tempDanceLesson.getAttendanceRecords().size();
    //   System.out.println("Number of students: \t" + studentsPerLesson );
    //   for(AttendanceRecord tempRecord : tempDanceLesson.getAttendanceRecords() ){
    //     System.out.println(tempRecord.getStudent().getFirstName());
    //   }
    // }

    return danceLessonList;
  }

  @CrossOrigin("http://localhost:4200")
  @GetMapping("/api/lessons/{id}")
  public List<Student> getDanceLessonStudentList(@PathVariable Long id) {
    List<Student> students = new ArrayList<Student>(); 
    //start by getting the dance session
    DanceLesson danceLesson = danceLessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dance Lesson not found! "));

    // then use the dance session to retrieve a list of attendanceRecords
    List<AttendanceRecord> attendanceRecordList = attendanceRecordRepository.findByDanceSession(danceLesson);

    // then use the list of attendance records to retrieve a list of students
    for(AttendanceRecord tempAttendanceRecord : attendanceRecordList){
      System.out.println(tempAttendanceRecord.getStudent());
      students.add(tempAttendanceRecord.getStudent());
    }
    return students;
  }

  @CrossOrigin("http://localhost:4200")
  @PostMapping("/api/create-lesson")
  public DanceLesson createLesson(@RequestBody DanceLesson newDanceLesson) {
      System.out.println("" + newDanceLesson.getClassDate() + "\t" + newDanceLesson.getClassTime() + "\t" + newDanceLesson.getClassLevel());
      DanceLesson tempDanceLesson = new DanceLesson(newDanceLesson.getClassDate(), newDanceLesson.getClassTime(), newDanceLesson.getClassType(),newDanceLesson.getClassLevel());
      DanceLesson createdDanceLesson = danceLessonRepository.save(tempDanceLesson);
      
      System.out.println("Testing: " + createdDanceLesson.getClassDate() + " : " + createdDanceLesson.getClassType());
      // return ResponseEntity.ok(createdDanceLesson+"");
      return createdDanceLesson;
      //return ResponseEntity.ok("User created successfully for: " + newDanceLesson.getClassDate() + "\t" + newDanceLesson.getClassTime() + "\t" + newDanceLesson.getClassLevel());
  }

  @PostMapping("/api/create-update-student")
  public ResponseEntity<String> createOrUpdateStudent(@RequestBody Student newStudent) {
      System.out.println("" + newStudent.toString());
      Student currStudent;
      // first retrieve a dance lesson. I.e  retrieve today's current dance lesson
      // DanceLesson currentDanceLesson = danceLessonRepository.findByClassDateAndClassTimeAndClassLevel(LocalDate.of(2026,01,21), LocalTime.of(18,30,00), ClassLevel.BEGINNER);
      DanceLesson currentDanceLesson = danceLessonRepository.findByClassDateAndClassTimeAndClassLevel(LocalDate.of(2026,01,21), LocalTime.of(18,30,00), ClassLevel.BEGINNER);
      
      // then save the new student if the student doesn't alreay exist
      Student existingStudent = studentRepository.findByFirstName(newStudent.getFirstName());
      if(existingStudent == null){
        currStudent = studentRepository.save(newStudent); // you should now have a studentId for currentStudent
        return ResponseEntity.ok("Dance Lesson created successfully : " + newStudent.toString());
      }else{
        currStudent = existingStudent;
      }

      // now check the attendance record for instances of the studentId and the current dance lesson
      
      AttendanceRecord existingAttendanceRecord = attendanceRecordRepository.findByStudentAndDanceSession(currStudent, currentDanceLesson);
      
      // if no record exists, then we can go ahead and create one
      AttendanceRecord newAttendanceRecord;
      if(existingAttendanceRecord == null){
        newAttendanceRecord = attendanceRecordRepository.save(new AttendanceRecord(newStudent, currentDanceLesson, true, PaymentType.CARD));
        // finally save or update the student with the new attendance record
        currStudent.addAttendanceRecord(newAttendanceRecord);
        return ResponseEntity.ok("Student saved successfully");
      }

      return ResponseEntity.status(HttpStatus.CONFLICT).body("Student already Exists" + existingStudent); // Or 400 Bad Request
       
      
  }
  
}
