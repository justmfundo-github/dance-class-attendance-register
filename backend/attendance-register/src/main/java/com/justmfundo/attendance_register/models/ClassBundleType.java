package com.justmfundo.attendance_register.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClassBundleType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name; // e.g., Beginner Improver
  private int numberOfLessons;
  private int daysValid; //in days
  // private LocalDate beginDate;
  // private LocalDate expiryDate;
  private double price;
  
  public ClassBundleType(String name, int numberOfLessons, int daysValid, double price) {
    this.name = name;
    this.numberOfLessons = numberOfLessons;
    this.daysValid = daysValid;
    this.price = price;
  }

  
}
