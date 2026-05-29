package com.justmfundo.attendance_register.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="class_bundle_type")
@Getter
@Setter
public class ClassBundleType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="bundle_type_id")
  private Long id;

  private String name; // e.g., Beginner Improver
  private int numberOfLessons;
  private int daysValid; //in days
  // private LocalDate beginDate;
  // private LocalDate expiryDate;
  private double price;

  @JsonIgnore
  @OneToMany(mappedBy = "classBundleType", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ClassBundle> classBundles = new HashSet<>();

  // Standard constructors, getters, and setters
  // Add utility methods for managing the relationship
  public void addclassBundle(ClassBundle classBundle) {
      classBundles.add(classBundle);
      // classBundle.setStudent(this);
  }
  
  public ClassBundleType(String name, int numberOfLessons, int daysValid, double price) {
    this.name = name;
    this.numberOfLessons = numberOfLessons;
    this.daysValid = daysValid;
    this.price = price;
  }

  public ClassBundleType(){}
}
