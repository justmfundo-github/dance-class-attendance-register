package com.justmfundo.attendance_register;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.justmfundo.attendance_register.dao.AttendanceRecordRepository;
import com.justmfundo.attendance_register.dao.DanceLessonRepository;
import com.justmfundo.attendance_register.dao.StudentRepository;
import com.justmfundo.attendance_register.models.AttendanceRecord;
import com.justmfundo.attendance_register.models.ClassLevel;
import com.justmfundo.attendance_register.models.ClassType;
import com.justmfundo.attendance_register.models.DanceLesson;
import com.justmfundo.attendance_register.models.PaymentType;
import com.justmfundo.attendance_register.models.Student;

@SpringBootApplication
public class AttendanceRegisterApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AttendanceRegisterApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AttendanceRecordRepository attendanceRecordRepository;

	@Autowired
	private DanceLessonRepository danceLessonRepository;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Command Line Runner completed!");

		// List<DanceLesson> danceLessons = danceLessonRepository.findByClassDate(LocalDate.of(2025, Month.JANUARY, 19));
		// for(DanceLesson tempDanceLesson : danceLessons){
		// 	System.out.println("" + tempDanceLesson.getClassLevel() + "\t" + tempDanceLesson.getClassDate() + "\t" + tempDanceLesson.getClassTime());
		// }

		// Student student01 = new Student("Sipho", "Mkhize", "0823456789");
		// Student student02 = new Student("Naledi", "Botha", "0712345678");
		// Student student03 = new Student("Thabo", "Nkosi", "0839876543");
		// Student student04 = new Student("Ayesha", "Khan", "0844567890");
		// Student student05 = new Student("Daniel", "Van Wyk", "0721122334");
		// Student student06 = new Student("Lerato", "Molefe", "0819988776");
		// Student student07 = new Student("Steve", "Tanker", "0819988776");

		// DanceLesson danceSessionBeginner = new DanceLesson(LocalDate.of(2025, Month.JANUARY, 2), LocalTime.of(18, 30), ClassType.KIZOMBA,ClassLevel.BEGINNER);
		// DanceLesson danceSessionImprover = new DanceLesson(LocalDate.of(2025, Month.JANUARY, 2), LocalTime.of(19, 30), ClassType.KIZOMBA, ClassLevel.IMPROVER);
		// DanceLesson danceSessionIntermediate = new DanceLesson(LocalDate.of(2025, Month.JANUARY, 2), LocalTime.of(19, 30), ClassType.KIZOMBA, ClassLevel.INTERMEDIATE);
		// DanceLesson danceSessionAdvanced = new DanceLesson(LocalDate.of(2025, Month.JANUARY, 2), LocalTime.of(19, 30), ClassType.KIZOMBA, ClassLevel.ADVANCED);
		// DanceLesson danceSessionSalsaBeginner = new DanceLesson(LocalDate.of(2025, Month.JANUARY, 4), LocalTime.of(19, 00), ClassType.SALSA, ClassLevel.BEGINNER);
		// DanceLesson danceSessionSalsaOpen = new DanceLesson(LocalDate.of(2025, Month.JANUARY, 4), LocalTime.of(20, 00), ClassType.SALSA, ClassLevel.OPEN);

		// danceLessonRepository.saveAll(Arrays.asList(danceSessionBeginner, danceSessionImprover, danceSessionIntermediate, danceSessionAdvanced, danceSessionSalsaBeginner, danceSessionSalsaOpen));

		// studentRepository.saveAll(Arrays.asList(student01, student02, student03, student04, student05, student06, student07));
		

		// AttendanceRecord attendanceRecordKizombaBeginner = new AttendanceRecord(student01, danceSessionBeginner, true, PaymentType.CARD);
		// AttendanceRecord attendanceRecordKizombaImprover = new AttendanceRecord(student02, danceSessionImprover, true, PaymentType.BUNDLE);
		// AttendanceRecord attendanceRecordKizombaIntermediate = new AttendanceRecord(student03, danceSessionIntermediate, true, PaymentType.CASH);
		// AttendanceRecord attendanceRecordKizombaBeginnerTwo = new AttendanceRecord(student04, danceSessionBeginner, true, PaymentType.CARD);
		// AttendanceRecord attendanceRecordKizombaBeginnerThree = new AttendanceRecord(student05, danceSessionBeginner, true, PaymentType.BUNDLE);
		// AttendanceRecord attendanceRecordKizombaIntermediateTwo = new AttendanceRecord(student06, danceSessionIntermediate, true, PaymentType.CASH);
		// AttendanceRecord attendanceRecordKizombaAdvanced = new AttendanceRecord(student07, danceSessionAdvanced, true, PaymentType.CASH);

		// AttendanceRecord attendanceRecordSalsaBeginner = new AttendanceRecord(student01, danceSessionBeginner, true, PaymentType.CARD);
		// AttendanceRecord attendanceRecordSalsaBeginnerTwo = new AttendanceRecord(student02, danceSessionBeginner, true, PaymentType.BUNDLE);
		// AttendanceRecord attendanceRecordSalsaBeginnerThree = new AttendanceRecord(student03, danceSessionBeginner, true, PaymentType.CASH);
		// AttendanceRecord attendanceRecordSalsaOpen = new AttendanceRecord(student07, danceSessionSalsaOpen, true, PaymentType.FREE);
	
		// attendanceRecordRepository.saveAll(Arrays.asList(attendanceRecordKizombaBeginner, attendanceRecordKizombaBeginnerThree, attendanceRecordKizombaBeginnerTwo, attendanceRecordKizombaImprover, 
		// attendanceRecordKizombaIntermediate, attendanceRecordKizombaIntermediateTwo, attendanceRecordKizombaAdvanced, attendanceRecordSalsaBeginner, attendanceRecordSalsaBeginnerThree, attendanceRecordSalsaBeginnerTwo, attendanceRecordSalsaOpen));

		
	}

}
