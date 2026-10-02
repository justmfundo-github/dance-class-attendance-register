package com.justmfundo.attendance_register.models;

import com.justmfundo.attendance_register.models.utility.PaymentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
  AttendanceRecord is created when a student is attached/added to a dance lesson/session. I.e. An attendance record cannot exist if a class didn't happen. 
  Also, a student cannot be associated with an attendance record if they didn't come to class. 
  To have an occurrance of an AttendanceRecord, you need to have created a class/lession/session, then add a student to that session. This then creates a 
  record of attendance. 
*/

@Entity
@Table(name="attendance_record")
@Getter
@Setter
public class AttendanceRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="attendance_record_id")
  private Long id; 
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id")
  private Student student; // Many records link to one student

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "session_id")
  private DanceLesson danceSession; // Many records link to one session

  // private boolean present;
  private PaymentType paymentType;

  public AttendanceRecord(Student student, DanceLesson danceSesson){ //PaymentType paymentType
    this.student = student;
    this.danceSession = danceSesson;
    // this.present = present;
    // this.paymentType = paymentType;
  }

  public AttendanceRecord(){}

}
