package com.justmfundo.attendance_register.dto;

import com.justmfundo.attendance_register.models.AttendanceRecord;
import com.justmfundo.attendance_register.models.ClassBundle;
import com.justmfundo.attendance_register.models.Student;

public class StudentInformationDto {
  private Student student;
  private AttendanceRecord attendanceRecord;
  private ClassBundle studentClassBundle;
}
