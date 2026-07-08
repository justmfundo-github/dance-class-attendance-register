package com.justmfundo.attendance_register.dto;

import lombok.Getter;

@Getter
public class StudentClassInfoDto {
  private Long student_id;
  private String cellphoneNumber;
  private String firstName;
  private String lastName;
  private Long kizombaTotal;
  private Long salsaTotal;


  public StudentClassInfoDto(Long student_id, String cellphoneNumber, String firstName, String lastName,
      Long kizombaTotal, Long salsaTotal) {
    this.student_id = student_id;
    this.cellphoneNumber = cellphoneNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.kizombaTotal = kizombaTotal;
    this.salsaTotal = salsaTotal;
  }

  
}
