package com.justmfundo.attendance_register.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.justmfundo.attendance_register.dto.StudentClassInfoDto;
import com.justmfundo.attendance_register.models.StudentClassInfo;

public interface StudentInformationRepository extends JpaRepository<StudentClassInfo, Long>{
  StudentClassInfo findByStudentId(Long studentId);

  // Uses exact database table names ('users') and column names ('created_at')
    @Query(value = "SELECT student_id, cellphone_number, first_name, last_name,\r\n" + //
            "    COUNT(CASE WHEN class_type = 0 THEN 1 END) AS KIZOMBA,\r\n" + //
            "    COUNT(CASE WHEN class_type = 1 THEN 1 END) AS SALSA\r\n" + //
            "FROM `student_class_info`\r\n" + //
            "GROUP BY student_id;", 
           nativeQuery = true)
    List<StudentClassInfoDto> findAllClassInfoDtos();
}
