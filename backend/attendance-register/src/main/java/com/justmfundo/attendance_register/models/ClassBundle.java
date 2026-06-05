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
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="class_bundle")
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
  private Student student; 

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bundle_type_id")
  private ClassBundleType classBundleType; 

  public ClassBundle(Student student, ClassBundleType classBundleType, LocalDate activationDate, LocalDate expirationDate, int lessonsRemaining ) {
    this.student = student;
    this.classBundleType = classBundleType;
    this.activationDate = activationDate;
    this.expirationDate = expirationDate;
    this.lessonsRemaining = lessonsRemaining;
    // this.status = status;
    
  }

  // Helper method to decrement credit
    public void useLesson() {
        if (this.lessonsRemaining > 0 && this.status == Status.ACTIVE) {
            this.lessonsRemaining--;
            if (this.lessonsRemaining == 0) {
                this.status = Status.EXPIRED;
            }
        } else {
            throw new IllegalStateException("No lessons remaining or bundle is inactive.");
        }
    }

    // The status is calculated on the fly
    public Status getBundleStatus() {
        if (LocalDate.now().isBefore(this.expirationDate)) {
            return Status.ACTIVE;
        } else {
            return Status.EXPIRED;
        }
    }

  
}
