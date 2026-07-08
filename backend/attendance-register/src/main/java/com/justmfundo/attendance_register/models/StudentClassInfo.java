package com.justmfundo.attendance_register.models;

import java.time.LocalDate;

import com.justmfundo.attendance_register.models.utility.ClassLevel;
import com.justmfundo.attendance_register.models.utility.ClassType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class StudentClassInfo {
  @Id
  @Column(name="student_id")
  private Long studentId;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;

  @Column(name="cellphone_number")
  private String cellphoneNumber;

  private LocalDate classDate;
  private ClassType classType; // e.g, Kizomba or salsa
  private ClassLevel classLevel;
}
