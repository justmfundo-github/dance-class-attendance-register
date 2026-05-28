package com.justmfundo.attendance_register.models;

import java.time.LocalDate;

import com.justmfundo.attendance_register.models.utility.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClassBundle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate activationDate;
  private LocalDate expirationDate;
  private int lessonsRemaining;
  private Status status;
  
    @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id")
  private Student student; // Many records link to one student

  public ClassBundle(Student student, LocalDate activationDate, LocalDate expirationDate, int lessonsRemaining, Status status ) {
    this.student = student;
    this.activationDate = activationDate;
    this.expirationDate = expirationDate;
    this.lessonsRemaining = lessonsRemaining;
    this.status = status;
    
  }

  
}
