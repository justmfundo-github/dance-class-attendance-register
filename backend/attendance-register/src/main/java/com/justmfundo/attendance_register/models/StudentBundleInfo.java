package com.justmfundo.attendance_register.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name="student_bundle_info")
@Getter
public class StudentBundleInfo {
  @Id
  private Long studentId;
  private LocalDate activationDate;
  private LocalDate expirationDate;
  private Long lessonsRemaining;
  private Long daysValid;
  private String name;
  private Long numberOfLessons;

  // public StudentBundleInfo(Long studentId, LocalDate activationDate, LocalDate expirationDate, Long lessonsRemaining,
  //     Long daysValid, String name, Long numberOfLessons) {
  //   this.studentId = studentId;
  //   this.activationDate = activationDate;
  //   this.expirationDate = expirationDate;
  //   this.lessonsRemaining = lessonsRemaining;
  //   this.daysValid = daysValid;
  //   this.name = name;
  //   this.numberOfLessons = numberOfLessons;
  // }
  
  
}
