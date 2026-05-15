package com.justmfundo.attendance_register.dto;

import com.justmfundo.attendance_register.models.DanceLesson;
import com.justmfundo.attendance_register.models.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLessonDto {
  private DanceLesson danceLesson;
  private Student student;
}
