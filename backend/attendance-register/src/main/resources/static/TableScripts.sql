-- Create schema (if it doesn't already exist)
CREATE SCHEMA IF NOT EXISTS dance_attendance_register
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE dance_attendance_register;

-- Create student table
CREATE TABLE student (
    student_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    cellphone_number VARCHAR(20) NOT NULL
);


USE dance_attendance_register;

-- Create attendance_record table
CREATE TABLE attendance_record (
    attendance_record_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,

    student_id INT UNSIGNED NOT NULL,
    class_date DATE NOT NULL,

    payment_type ENUM('BUNDLE', 'CASH', 'CARD') NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_attendance_student
        FOREIGN KEY (student_id)
        REFERENCES student(student_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    INDEX idx_attendance_student (student_id),
    INDEX idx_attendance_class_date (class_date)
); 

-- Create dance_lesson table
CREATE TABLE dance_lesson (
    id INT AUTO_INCREMENT PRIMARY KEY,
    class_level VARCHAR(50),
    class_date DATE,
    class_time TIME
)


INSERT INTO student (first_name, last_name, cellphone_number) VALUES
('Sipho', 'Mkhize', '0823456789'),
('Naledi', 'Botha', '0712345678'),
('Thabo', 'Nkosi', '0839876543'),
('Ayesha', 'Khan', '0844567890'),
('Daniel', 'Van Wyk', '0721122334'),
('Lerato', 'Molefe', '0819988776');


INSERT INTO attendance_record (student_id, class_date, payment_type) VALUES
-- Sipho
(1, '2026-01-05', 'BUNDLE'),   -- Monday
(1, '2026-01-07', 'BUNDLE'),   -- Wednesday

-- Naledi
(2, '2026-01-05', 'CARD'),     -- Monday
(2, '2026-01-12', 'CARD'),     -- Monday

-- Thabo
(3, '2026-01-07', 'CASH'),     -- Wednesday
(3, '2026-01-14', 'CASH'),     -- Wednesday

-- Ayesha
(4, '2026-01-05', 'BUNDLE'),   -- Monday
(4, '2026-01-07', 'BUNDLE'),   -- Wednesday

-- Daniel
(5, '2026-01-12', 'CARD'),     -- Monday
(5, '2026-01-14', 'CASH'),     -- Wednesday

-- Lerato
(6, '2026-01-05', 'BUNDLE'),   -- Monday
(6, '2026-01-14', 'BUNDLE');   -- Wednesday



INSERT INTO dance_lesson (id, class_level, class_time) VALUES
-- Week of Jan 12, 2026
(1, 0, '2026-01-12','18:30:00'),
(2, 1, '2026-01-12','19:30:00'),
(3, 2, '2026-01-12','19:30:00'),
(4, 3, '2026-01-14','19:00:00'),
(5, 4, '2026-01-14','20:00:00'),

(6, 'Beginner',     '2026-01-19 18:30:00'),
(7, 'Intermediate', '2026-01-19 19:30:00'),
(8, 'Advanced',     '2026-01-19 19:30:00'),
(9, 'Beginner',     '2026-01-21 19:00:00'),
(10,'Open',         '2026-01-21 20:00:00'),

(11,'Beginner',     '2026-01-26 18:30:00'),
(12,'Intermediate', '2026-01-26 19:30:00'),
(13,'Advanced',     '2026-01-26 19:30:00'),
(14,'Beginner',     '2026-01-28 19:00:00'),
(15,'Open',         '2026-01-28 20:00:00'),

-- February
(16,'Beginner',     '2026-02-02 18:30:00'),
(17,'Intermediate', '2026-02-02 19:30:00'),
(18,'Advanced',     '2026-02-02 19:30:00'),
(19,'Beginner',     '2026-02-04 19:00:00'),
(20,'Open',         '2026-02-04 20:00:00'),

(21,'Beginner',     '2026-02-09 18:30:00'),
(22,'Intermediate', '2026-02-09 19:30:00'),
(23,'Advanced',     '2026-02-09 19:30:00'),
(24,'Beginner',     '2026-02-11 19:00:00'),
(25,'Open',         '2026-02-11 20:00:00'),

(26,'Beginner',     '2026-02-16 18:30:00'),
(27,'Intermediate', '2026-02-16 19:30:00'),
(28,'Advanced',     '2026-02-16 19:30:00'),
(29,'Beginner',     '2026-02-18 19:00:00'),
(30,'Open',         '2026-02-18 20:00:00'),

(31,'Beginner',     '2026-02-23 18:30:00'),
(32,'Intermediate', '2026-02-23 19:30:00'),
(33,'Advanced',     '2026-02-23 19:30:00'),
(34,'Beginner',     '2026-02-25 19:00:00'),
(35,'Open',         '2026-02-25 20:00:00'),

-- ... same pattern continues every Monday & Wednesday ...

(251,'Beginner',     '2026-12-21 18:30:00'),
(252,'Intermediate', '2026-12-21 19:30:00'),
(253,'Advanced',     '2026-12-21 19:30:00'),
(254,'Beginner',     '2026-12-23 19:00:00'),
(255,'Open',         '2026-12-23 20:00:00'),

(256,'Beginner',     '2026-12-28 18:30:00'),
(257,'Intermediate', '2026-12-28 19:30:00'),
(258,'Advanced',     '2026-12-28 19:30:00'),
(259,'Beginner',     '2026-12-30 19:00:00'),
(260,'Open',         '2026-12-30 20:00:00');
