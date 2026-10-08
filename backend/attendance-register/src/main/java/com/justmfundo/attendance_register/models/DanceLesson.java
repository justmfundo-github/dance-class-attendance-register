package com.justmfundo.attendance_register.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justmfundo.attendance_register.models.utility.ClassLevel;
import com.justmfundo.attendance_register.models.utility.ClassType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DanceLesson {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate classDate;
  private LocalTime classTime; // e.g., date and time of the session
  private ClassType classType; // e.g, Kizomba or salsa
  private ClassLevel classLevel;

  private double pricePerPerson;
  private double promotionalPricePerPerson; // for when we offer specials like 2 for R200 while individuals pay R120
  

  @OneToMany(mappedBy = "danceSession", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private Set<AttendanceRecord> attendanceRecords = new HashSet<>();

  @OneToMany(mappedBy = "danceLesson")
  private List<Payment> payments;

  // Standard constructors, getters, and setters
    // Add utility methods for managing the relationship
    public void addAttendanceRecord(AttendanceRecord record) {
        attendanceRecords.add(record);
        record.setDanceSession(this);
    }

    public DanceLesson(LocalDate classDate, LocalTime classTime, ClassType classType,  ClassLevel classLevel, double pricePerPerson, double promotionalPricePerPerson){
      this.classDate = classDate;
      this.classTime = classTime;
      this.classLevel = classLevel;
      this.classType = classType;
      this.pricePerPerson = pricePerPerson;
      this.promotionalPricePerPerson = promotionalPricePerPerson;

    }

    public DanceLesson(){}
}
