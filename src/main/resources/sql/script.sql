DROP TABLE IF EXISTS authority;

DROP TABLE IF EXISTS account;

DROP TABLE IF EXISTS period_time_class;

DROP TABLE IF EXISTS period_time;

DROP TABLE IF EXISTS roll_call;

DROP TABLE IF EXISTS salary;

DROP TABLE IF EXISTS score;

DROP TABLE IF EXISTS student_pay_fee;

DROP TABLE IF EXISTS student_fee;

DROP TABLE IF EXISTS timetable;

DROP TABLE IF EXISTS student;

DROP TABLE IF EXISTS class;

DROP TABLE IF EXISTS grade;

DROP TABLE IF EXISTS school;

DROP TABLE IF EXISTS school_year;

DROP TABLE IF EXISTS teacher;

DROP TABLE IF EXISTS account_details;

CREATE TABLE `account`
(
    `id`                 INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`               NVARCHAR(50)    NOT NULL,
    `email`              VARCHAR(50)     NOT NULL,
    `mobile_number`      VARCHAR(10)     NOT NULL,
    `pwd`                VARCHAR(200)    NOT NULL,
    `role`               VARCHAR(50)     NOT NULL COMMENT 'user - admin',
    `account_details_id` INT             NOT NULL,
    `created_at`         DATE            NOT NULL
);

CREATE TABLE `authority`
(
    `id`         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(50)     NOT NULL COMMENT 'student, teacher,...',
    `account_id` INT             NOT NULL
);

CREATE TABLE `account_details`
(
    `id`           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `account_type` VARCHAR(50)     NOT NULL
);

CREATE TABLE `roll_call`
(
    `name`             VARCHAR(50) NOT NULL,
    `student_id`       INT         NOT NULL,
    `class_id`         INT         NOT NULL COMMENT 'student''s main class',
    `at_date`          DATE        NOT NULL,
    `roll_call`        VARCHAR(20) NOT NULL COMMENT 'attendace - absent - make up class (hoc bu)',
    `class_attendance` VARCHAR(10) NOT NULL COMMENT 'write the class student study at the time roll call',
    PRIMARY KEY (`student_id`, `class_id`, `at_date`)
);

CREATE TABLE `student`
(
    `id`                 INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `account_details_id` INT             NOT NULL,
    `school_id`          INT             NOT NULL,
    `class_id`           INT             NOT NULL,
    `grade_id`           INT             NOT NULL,
    `start_learning_at`  DATE            NOT NULL,
    `stop_learning_at`   DATE            NOT NULL,
    `enable`             INT             NOT NULL COMMENT '1 - true, 0 - false'
);

CREATE TABLE `class`
(
    `id`          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(50)     NOT NULL,
    `type`        VARCHAR(10)     NOT NULL COMMENT 'VIP NORMAL',
    `grade`       INT             NOT NULL,
    `max_student` INT             NOT NULL COMMENT 'maxium number of student in class'
);

CREATE TABLE `school`
(
    `id`          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `school_name` NVARCHAR(50)    NOT NULL
);

CREATE TABLE `period_time`
(
    `id`           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`         VARCHAR(50)     NOT NULL,
    `date_of_week` VARCHAR(10)     NOT NULL COMMENT 'monday, tuesday,.... sunday',
    `start_at`     TIME            NOT NULL,
    `end_at`       TIME            NOT NULL
);

CREATE TABLE `grade`
(
    `id`             INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `grade`          INT             NOT NULL COMMENT '10 11 12',
    `school_year_id` INT             NOT NULL
);

CREATE TABLE `school_year`
(
    `id`            INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `start_at`      DATE            NOT NULL,
    `end_at`        DATE            NOT NULL,
    `year_start_at` YEAR            NOT NULL,
    `year_end_at`   YEAR            NOT NULL
);

CREATE TABLE `teacher`
(
    `id`                 INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `account_details_id` INT             NOT NULL
);

CREATE TABLE `timetable`
(
    `id`         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `at_date`    DATE            NOT NULL,
    `teacher_id` INT             NOT NULL,
    `student_id` INT             NOT NULL,
    `class_id`   INT             NOT NULL
);

CREATE TABLE `score`
(
    `id`         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `student_id` INT             NOT NULL,
    `name`       NVARCHAR(50)    NOT NULL,
    `score`      DECIMAL(5, 2)   NOT NULL
);

CREATE TABLE `salary`
(
    `id`          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `date_pay_at` DATE            NOT NULL,
    `salary`      DECIMAL(15, 4)  NOT NULL,
    `teacher_id`  INT             NOT NULL
);

CREATE TABLE `student_fee`
(
    `id`       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`     NVARCHAR(20)    NOT NULL,
    `fee`      DECIMAL(15, 4)  NOT NULL COMMENT 'so tien can dong',
    `start_at` DATE            NOT NULL COMMENT 'start term',
    `end_at`   DATE            NOT NULL COMMENT 'end term'
);

CREATE TABLE `student_pay_fee`
(
    `id`            INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `student_id`    INT             NOT NULL,
    `student_fee`   INT             NOT NULL,
    `already_pay`   DECIMAL(15, 4)  NOT NULL COMMENT 'so tien da dong',
    `remaining`     DECIMAL(15, 4)  NOT NULL COMMENT 'so tien con lai',
    `latest_pay_at` DATE            NOT NULL COMMENT 'ngay dong hoc phi'
);

ALTER TABLE `roll_call`
    COMMENT = 'luu tru diem danh';

ALTER TABLE `period_time`
    COMMENT = 'class period';

ALTER TABLE `timetable`
    COMMENT = 'thoi khoa bieu chung cho tung nhom trong tuan';

ALTER TABLE `account`
    ADD FOREIGN KEY (`account_details_id`) REFERENCES `account_details` (`id`);

ALTER TABLE `authority`
    ADD FOREIGN KEY (`account_id`) REFERENCES `account` (`id`);

ALTER TABLE `roll_call`
    ADD FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

ALTER TABLE `roll_call`
    ADD FOREIGN KEY (`class_id`) REFERENCES `class` (`id`);

ALTER TABLE `student`
    ADD FOREIGN KEY (`account_details_id`) REFERENCES `account_details` (`id`);

ALTER TABLE `student`
    ADD FOREIGN KEY (`school_id`) REFERENCES `school` (`id`);

ALTER TABLE `student`
    ADD FOREIGN KEY (`class_id`) REFERENCES `class` (`id`);

ALTER TABLE `student`
    ADD FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`);

CREATE TABLE `period_time_class`
(
    `period_time_id` INT,
    `class_id`       INT,
    PRIMARY KEY (`period_time_id`, `class_id`)
);

ALTER TABLE `period_time_class`
    ADD FOREIGN KEY (`period_time_id`) REFERENCES `period_time` (`id`);

ALTER TABLE `period_time_class`
    ADD FOREIGN KEY (`class_id`) REFERENCES `class` (`id`);


ALTER TABLE `class`
    ADD FOREIGN KEY (`grade`) REFERENCES `grade` (`id`);

ALTER TABLE `grade`
    ADD FOREIGN KEY (`school_year_id`) REFERENCES `school_year` (`id`);

ALTER TABLE `teacher`
    ADD FOREIGN KEY (`account_details_id`) REFERENCES `account_details` (`id`);

ALTER TABLE `timetable`
    ADD FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`);

ALTER TABLE `timetable`
    ADD FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

ALTER TABLE `timetable`
    ADD FOREIGN KEY (`class_id`) REFERENCES `class` (`id`);

ALTER TABLE `score`
    ADD FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

ALTER TABLE `salary`
    ADD FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`);

ALTER TABLE `student_pay_fee`
    ADD FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

ALTER TABLE `student_pay_fee`
    ADD FOREIGN KEY (`student_fee`) REFERENCES `student_fee` (`id`);
