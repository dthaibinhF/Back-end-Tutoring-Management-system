DROP TABLE IF EXISTS account_authority;

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

DROP TABLE IF EXISTS school_year_grade;

DROP TABLE IF EXISTS grade;

DROP TABLE IF EXISTS school;

DROP TABLE IF EXISTS school_year;

DROP TABLE IF EXISTS teacher;

DROP TABLE IF EXISTS account_details;

CREATE TABLE `account`
(
    `id`                 INT PRIMARY KEY    NOT NULL AUTO_INCREMENT,
    `name`               NVARCHAR(50)       NOT NULL,
    `email`              VARCHAR(50)        NOT NULL,
    `mobile_number`      VARCHAR(10) UNIQUE NOT NULL,
    `pwd`                VARCHAR(200)       NOT NULL,
    `account_details_id` INT                NOT NULL,
    `created_at`         DATE               NOT NULL
);

CREATE TABLE `authority`
(
    `id`   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50)     NOT NULL COMMENT 'student, teacher,...'
);

CREATE TABLE `account_details`
(
    `id`      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `address` nvarchar(500)
);

CREATE TABLE `roll_call`
(
    `name`             varchar(50) NOT NULL,
    `student_id`       INT         NOT NULL,
    `class_id`         INT         NOT NULL COMMENT 'student''s main class',
    `at_date`          date        NOT NULL,
    `roll_call`        varchar(20) NOT NULL COMMENT 'attendace - absent - make up class (hoc bu)',
    `class_attendance` varchar(10) NOT NULL COMMENT 'write the class student study at the time roll call',
    PRIMARY KEY (`student_id`, `class_id`, `at_date`)
);

CREATE TABLE `student`
(
    `id`                 INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `account_details_id` INT             NOT NULL,
    `school_id`          INT             NOT NULL,
    `class_id`           INT             NOT NULL,
    `grade_id`           INT             NOT NULL,
    `start_learning_at`  date            NOT NULL,
    `stop_learning_at`   date            NOT NULL,
    `enable`             INT             NOT NULL COMMENT '1 - true, 0 - false'
);

CREATE TABLE `class`
(
    `id`          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`        varchar(50)     NOT NULL,
    `type`        varchar(10)     NOT NULL COMMENT 'VIP NORMAL',
    `grade`       INT             NOT NULL,
    `max_student` INT             NOT NULL COMMENT 'maxium number of student in class'
);

CREATE TABLE `school`
(
    `id`          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `school_name` nvarchar(50)    NOT NULL
);

CREATE TABLE `period_time`
(
    `id`           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`         varchar(50)     NOT NULL,
    `date_of_week` varchar(10)     NOT NULL COMMENT 'monday, tuesday,.... sunday',
    `start_at`     time            NOT NULL,
    `end_at`       time            NOT NULL
);

CREATE TABLE `grade`
(
    `id`    INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `grade` INT UNIQUE      NOT NULL COMMENT '10 11 12',
    INDEX `grade_index` (`id`)
) AUTO_INCREMENT = 10;

CREATE TABLE `school_year`
(
    `id`            INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `start_at`      date            NOT NULL,
    `end_at`        date            NOT NULL,
    `year_start_at` year            NOT NULL,
    `year_end_at`   year            NOT NULL,
    INDEX `school_year_index` (`id`)
);

CREATE TABLE `teacher`
(
    `id`                 INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `account_details_id` INT             NOT NULL
);

CREATE TABLE `timetable`
(
    `id`         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `at_date`    date            NOT NULL,
    `teacher_id` INT             NOT NULL,
    `student_id` INT             NOT NULL,
    `class_id`   INT             NOT NULL
);

CREATE TABLE `score`
(
    `id`         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `student_id` INT             NOT NULL,
    `name`       nvarchar(50)    NOT NULL,
    `score`      decimal(5, 2)   NOT NULL
);

CREATE TABLE `salary`
(
    `id`          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `date_pay_at` date            NOT NULL,
    `salary`      decimal(15, 4)  NOT NULL,
    `teacher_id`  INT             NOT NULL
);

CREATE TABLE `student_fee`
(
    `id`       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`     nvarchar(20)    NOT NULL,
    `fee`      decimal(15, 4)  NOT NULL COMMENT 'so tien can dong',
    `start_at` date            NOT NULL COMMENT 'start term',
    `end_at`   date            NOT NULL COMMENT 'end term'
);

CREATE TABLE `student_pay_fee`
(
    `id`            INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `student_id`    INT             NOT NULL,
    `student_fee`   INT             NOT NULL,
    `already_pay`   decimal(15, 4)  NOT NULL COMMENT 'so tien da dong',
    `remaining`     decimal(15, 4)  NOT NULL COMMENT 'so tien con lai',
    `latest_pay_at` date            NOT NULL COMMENT 'ngay dong hoc phi'
);

ALTER TABLE `roll_call`
    COMMENT = 'luu tru diem danh';

ALTER TABLE `period_time`
    COMMENT = 'class period';

ALTER TABLE `timetable`
    COMMENT = 'thoi khoa bieu chung cho tung nhom trong tuan';

ALTER TABLE `account`
    ADD FOREIGN KEY (`account_details_id`) REFERENCES `account_details` (`id`);

CREATE TABLE `account_authority`
(
    `account_id`   INT,
    `authority_id` INT,
    PRIMARY KEY (`account_id`, `authority_id`)
);

ALTER TABLE `account_authority`
    ADD FOREIGN KEY (`account_id`) REFERENCES `account` (`id`);

ALTER TABLE `account_authority`
    ADD FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`);


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

CREATE TABLE `school_year_grade`
(
    `school_year_id` INT,
    `grade_id`       INT,
    PRIMARY KEY (`school_year_id`, `grade_id`)
);

ALTER TABLE `school_year_grade`
    ADD FOREIGN KEY (`school_year_id`) REFERENCES `school_year` (`id`);

ALTER TABLE `school_year_grade`
    ADD FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`);


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


########Account#########
INSERT INTO account_details (address)
VALUES ('Cần Thơ, Việt Nam');

INSERT INTO account_details (address)
VALUES ('Hồ Chí Minh, Việt Nam');

INSERT INTO account_details (address)
VALUES ('Tiền Giang, Việt Nam');

INSERT INTO account_details (address)
VALUES ('Cái Bè, Việt Nam');

INSERT INTO account_details (address)
VALUES ('Hậu Giang, Việt Nam');


########################student account########################
INSERT INTO account (name, email, mobile_number, pwd, created_at, account_details_id)
VALUES ('Đặng Thái Bình', 'dthaibinh03@gmail.com', '0939464077', '{noop}Dthaibinh@1234',
        '2025-02-10', 1);

INSERT INTO account (name, email, mobile_number, pwd, created_at, account_details_id)
VALUES ('Trần Phi Nhựt', 'nhut@gmail.com', '0927921129',
        '{bcrypt}$2a$12$KBdErJidVwMvzqN/mlQQVurMueux6oaT0t1KXQkfFTn98QYDVP6Jm', '2025-02-20', 2); #Phinhut@1234

INSERT INTO account (name, email, mobile_number, pwd, created_at, account_details_id)
VALUES ('Phan Tấn Phát', 'phat@gmail.com', '0123456789',
        '{bcrypt}$2a$12$aWEDx6JpvXScPRVk7cTxkeKh4e5qxQsk91wGtS.KVS2/L0/AcU.B2',
        '2025-02-20', 3); #Tanphat@1234

INSERT INTO account (name, email, mobile_number, pwd, created_at, account_details_id)
VALUES ('Bùi Gia Mỹ', 'my@gmail.com', '0987654321',
        '{bcrypt}$2a$12$HRPpgmQ2SuIbf1HfJEMXGeSlmHQ7SgucyVTJSpZXJXYT6PMFlJJES',
        '2025-02-20', 4);
#Kimngan@1234

########################teacher account########################
INSERT INTO account (name, email, mobile_number, pwd, created_at, account_details_id)
VALUES ('Nguyễn Hoàng Trung', 'trung@gmail.com', '0333098311',
        '{bcrypt}$2a$12$HRPpgmQ2SuIbf1HfJEMXGeSlmHQ7SgucyVTJSpZXJXYT6PMFlJJES',
        '2025-02-21', 5); #Kimngan@1234

INSERT INTO authority (name)
VALUES ('ROLE_ADMIN');

INSERT INTO authority (name)
VALUES ('ROLE_MANAGER');

INSERT INTO authority (name)
VALUES ('ROLE_TEACHER');

INSERT INTO authority (name)
VALUES ('ROLE_STUDENT');

INSERT INTO account_authority(account_id, authority_id)
VALUES (1, 1);
INSERT INTO account_authority(account_id, authority_id)
VALUES (2, 1);
INSERT INTO account_authority(account_id, authority_id)
VALUES (3, 4);
INSERT INTO account_authority(account_id, authority_id)
VALUES (4, 4);
INSERT INTO account_authority(account_id, authority_id)
VALUES (5, 3);


#####################################
########School#########
INSERT INTO school (school_name)
VALUES ('Truong THPT Châu Văn Liêm');

INSERT INTO school (school_name)
VALUES ('Truong THPT Thực Hành Sư Phạm');

INSERT INTO school (school_name)
VALUES ('Truong THPT Phan Ngọc Hiển');

INSERT INTO school (school_name)
VALUES ('Truong THPT Nguyễn Việt Hồng');

INSERT INTO school (school_name)
VALUES ('Truong THPT Nguyễn Việt Dũng');


INSERT INTO school (school_name)
VALUES ('Truong THPT An Khánh');

INSERT INTO school (school_name)
VALUES ('Truong THPT Bình Minh');

INSERT INTO school (school_name)
VALUES ('Truong THPT Nguyễn Bỉnh Khiêm');


INSERT INTO school (school_name)
VALUES ('Truong THPT Tầm Vu');
##############################################################
#############school_year############
INSERT INTO school_year (start_at, end_at, year_start_at, year_end_at)
VALUES ('2024-09-05', '2025-05-31', '2024', '2025');
##############################################################

#############grade############
INSERT INTO grade (grade)
VALUES (10);

INSERT INTO grade (grade)
VALUES (11);

INSERT INTO grade (grade)
VALUES (12);

############school_year_grade############
INSERT INTO school_year_grade (grade_id, school_year_id)
VALUES (10, 1);

INSERT INTO school_year_grade (grade_id, school_year_id)
VALUES (11, 1);
INSERT INTO school_year_grade (grade_id, school_year_id)
VALUES (12, 1);

##############################################################

#############period_time############
INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('monday-1', 'monday', '07:20:00', '09:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('monday-2', 'monday', '09:20:00', '11:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('monday-3', 'monday', '13:20:00', '15:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('monday-4', 'monday', '15:20:00', '17:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('monday-5', 'monday', '17:20:00', '19:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('monday-6', 'monday', '19:20:00', '21:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('tuesday-1', 'tuesday', '07:20:00', '09:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('tuesday-2', 'tuesday', '09:20:00', '11:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('tuesday-3', 'tuesday', '13:20:00', '15:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('tuesday-4', 'tuesday', '15:20:00', '17:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('tuesday-5', 'tuesday', '17:20:00', '19:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('tuesday-6', 'tuesday', '19:20:00', '21:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('wednesday-1', 'wednesday', '07:20:00', '09:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('wednesday-2', 'wednesday', '09:20:00', '11:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('wednesday-3', 'wednesday', '13:20:00', '15:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('wednesday-4', 'wednesday', '15:20:00', '17:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('wednesday-5', 'wednesday', '17:20:00', '19:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('wednesday-6', 'wednesday', '19:20:00', '21:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('thursday-1', 'thursday', '07:20:00', '09:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('thursday-2', 'thursday', '09:20:00', '11:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('thursday-3', 'thursday', '13:20:00', '15:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('thursday-4', 'thursday', '15:20:00', '17:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('thursday-5', 'thursday', '17:20:00', '19:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('thursday-6', 'thursday', '19:20:00', '21:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('friday-1', 'friday', '07:20:00', '09:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('friday-2', 'friday', '09:20:00', '11:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('friday-3', 'friday', '13:20:00', '15:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('friday-4', 'friday', '15:20:00', '17:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('friday-5', 'friday', '17:20:00', '19:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('friday-6', 'friday', '19:20:00', '21:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('saturday-1', 'saturday', '07:20:00', '09:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('saturday-2', 'saturday', '09:20:00', '11:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('saturday-3', 'saturday', '13:20:00', '15:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('saturday-4', 'saturday', '15:20:00', '17:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('saturday-5', 'saturday', '17:20:00', '19:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('saturday-6', 'saturday', '19:20:00', '21:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('sunday-1', 'sunday', '07:20:00', '09:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('sunday-2', 'sunday', '09:20:00', '11:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('sunday-3', 'sunday', '13:20:00', '15:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('sunday-4', 'sunday', '15:20:00', '17:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('sunday-5', 'sunday', '17:20:00', '19:00:00');

INSERT INTO period_time (name, date_of_week, start_at, end_at)
VALUES ('sunday-6', 'sunday', '19:20:00', '21:00:00');

##############################################################
#############class############
INSERT INTO class (name, type, grade, max_student)
VALUES ('12N1', 'NORMAL', 12, 50);

INSERT INTO class (name, type, grade, max_student)
VALUES ('12N2', 'NORMAL', 12, 50);

INSERT INTO class (name, type, grade, max_student)
VALUES ('12N3', 'NORMAL', 12, 50);

INSERT INTO class (name, type, grade, max_student)
VALUES ('12NC1', 'NORMAL', 12, 50);

INSERT INTO class (name, type, grade, max_student)
VALUES ('12NC2', 'NORMAL', 12, 50);

INSERT INTO class (name, type, grade, max_student)
VALUES ('12V1', 'NORMAL', 12, 50);

##############################################################
#############period_time_class############

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (1, 5);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (1, 17);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (1, 29);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (2, 6);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (2, 18);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (2, 30);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (3, 12);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (3, 24);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (3, 36);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (4, 16);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (4, 28);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (4, 40);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (5, 11);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (5, 23);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (5, 35);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (6, 5);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (6, 17);

INSERT INTO period_time_class (class_id, period_time_id)
VALUES (6, 29);

############################################################
#############student_fee############

INSERT INTO student_fee (name, fee, start_at, end_at)
VALUES ('lớp 12 Học kỳ 2', 1800000, '2025-01-01', '2025-04-30');

INSERT INTO student_fee (name, fee, start_at, end_at)
VALUES ('lớp 11 Học kỳ 2', 2000000, '2025-01-01', '2025-04-30');

INSERT INTO student_fee (name, fee, start_at, end_at)
VALUES ('lớp 10 Học kỳ 2', 2000000, '2025-01-01', '2025-04-30');

############################################################
#############student############

INSERT INTO student (account_details_id, school_id,
                     class_id, grade_id, start_learning_at,
                     stop_learning_at, enable)
VALUES (3, 6, 1, 12, '2025-01-01', '2025-04-30', 1);

INSERT INTO student (account_details_id, school_id,
                     class_id, grade_id, start_learning_at,
                     stop_learning_at, enable)
VALUES (4, 2, 4, 12, '2025-01-01', '2025-04-30', 1);

############################################################
#############score############

INSERT INTO score (student_id, name, score)
VALUES (1, 'KT xếp lớp', 7);

INSERT INTO score (student_id, name, score)
VALUES (2, 'KT xếp lớp', 9.5);

############################################################







