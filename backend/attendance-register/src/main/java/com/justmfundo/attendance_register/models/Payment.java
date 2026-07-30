package com.justmfundo.attendance_register.models;

import com.justmfundo.attendance_register.models.utility.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private PaymentType paymentType;
  private double Amount;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "dance_lesson_id")
  private DanceLesson danceLesson;

  public Payment(PaymentType paymentType, double amount, Student student, DanceLesson danceLesson) {
    this.paymentType = paymentType;
    Amount = amount;
    this.student = student;
    this.danceLesson = danceLesson;
  }

  
}
