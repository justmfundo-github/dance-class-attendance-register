package com.justmfundo.attendance_register.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="student")
@Getter
@Setter
public class Student{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="student_id")
  private Long studentId;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;

  @Column(name="cellphone_number")
  private String cellphoneNumber;

  @JsonIgnore
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ClassBundle> classBundles = new HashSet<>();

  // Standard constructors, getters, and setters
  // Add utility methods for managing the relationship
  public void addclassBundle(ClassBundle classBundle) {
      classBundles.add(classBundle);
      classBundle.setStudent(this);
  }

  @JsonIgnore
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<AttendanceRecord> attendanceRecords = new HashSet<>();

  // Standard constructors, getters, and setters
  // Add utility methods for managing the relationship
  public void addAttendanceRecord(AttendanceRecord record) {
      attendanceRecords.add(record);
      record.setStudent(this);
  }

  public Student(String firstName, String lastName, String cellphoneNumber){
    this.firstName = firstName;
    this.lastName = lastName;
    this.cellphoneNumber = cellphoneNumber;
  }

  public Student(){}
}