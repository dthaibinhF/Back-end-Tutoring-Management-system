CREATE TABLE `account`
(
    `id`            INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`          NVARCHAR(50)     NOT NULL,
    `email`         VARCHAR(50)     NOT NULL,
    `mobile_number` VARCHAR(10)     NOT NULL,
    `pwd`           VARCHAR(200)    NOT NULL,
    `role`          VARCHAR(50)     NOT NULL COMMENT 'user - admin',
    `created_at`    DATE            NOT NULL
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
    `account_type` VARCHAR(50)     NOT NULL,
    `account_id`   INT             NOT NULL
);

CREATE TABLE `roll_call`
(
    `name`             NVARCHAR(50) NOT NULL,
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
    `time`        INT             NOT NULL,
    `max_student` INT             NOT NULL COMMENT 'maxium number of student in class'
);

CREATE TABLE `school`
(
    `id`          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `school_name` NVARCHAR(50)     NOT NULL
);

CREATE TABLE `class_time`
(
    `id`       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(50)     NOT NULL,
    `start_at` TIME            NOT NULL,
    `end_at`   TIME            NOT NULL
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
    `name`       VARCHAR(50)     NOT NULL,
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
    `id`  INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `fee` DECIMAL(15, 4)  NOT NULL COMMENT 'so tien can dong'
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

ALTER TABLE `class_time`
    COMMENT = 'class period';

ALTER TABLE `timetable`
    COMMENT = 'thoi khoa bieu chung cho tung nhom trong tuan';

ALTER TABLE `authority`
    ADD FOREIGN KEY (`account_id`) REFERENCES `account` (`id`);

ALTER TABLE `account_details`
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

ALTER TABLE `class`
    ADD FOREIGN KEY (`grade`) REFERENCES `grade` (`id`);

ALTER TABLE `class`
    ADD FOREIGN KEY (`time`) REFERENCES `class_time` (`id`);

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

################################################################################################
########Account#########
INSERT INTO account (name, email, mobile_number, pwd, role, created_at)
VALUES ('Đặng Thái Bình', 'dthaibinh03@gmail.com', '0939464077', '{noop}Dthaibinh@1234', 'ADMIN', '2025-02-10');

INSERT INTO account (name, email, mobile_number, pwd, role, created_at)
VALUES ('Trần Phi Nhựt', 'nhut@gmail.com', '0927921129',
        '{bcrypt}$2a$12$KBdErJidVwMvzqN/mlQQVurMueux6oaT0t1KXQkfFTn98QYDVP6Jm', 'ADMIN', '2025-02-20'); #Phinhut@1234

INSERT INTO account (name, email, mobile_number, pwd, role, created_at)
VALUES ('Phan Tấn Phát', 'phat@gmail.com', '0123456789',
        '{bcrypt}$2a$12$aWEDx6JpvXScPRVk7cTxkeKh4e5qxQsk91wGtS.KVS2/L0/AcU.B2', 'USER', '2025-02-20'); #Tanphat@1234

INSERT INTO account (name, email, mobile_number, pwd, role, created_at)
VALUES ('Nguyễn Thị Kim Ngân', 'ngan@gmail.com', '0986502071',
        '{bcrypt}$2a$12$eir.ES3Ff2le/E90HME22e1WVdQZvScxEJpUe7TuGCyyPjISeW92G', 'USER', '2025-02-20'); #Kimngan@1234

INSERT INTO account_details (account_type, account_id)
VALUES ('ADMIN', 1);

INSERT INTO account_details (account_type, account_id)
VALUES ('ADMIN', 2);

INSERT INTO account_details (account_type, account_id)
VALUES ('STUDENT', 3);

INSERT INTO account_details (account_type, account_id)
VALUES ('TEACHER', 4);

INSERT INTO authority (name, account_id)
VALUES ('ROLE_ADMIN', 1);

INSERT INTO authority (name, account_id)
VALUES ('ROLE_ADMIN', 2);

INSERT INTO authority (name, account_id)
VALUES ('ROLE_STUDENT', 3);

INSERT INTO authority (name, account_id)
VALUES ('ROLE_TEACHER', 4);

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
INSERT INTO grade (grade, school_year_id)
VALUES (10, 1);

INSERT INTO grade (grade, school_year_id)
VALUES (11, 1);

INSERT INTO grade (grade, school_year_id)
VALUES (12, 1);
##############################################################

#############class_time############
INSERT INTO class_time (name, start_at, end_at)
VALUES ('ca 1', '07:20:00', '09:00:00');

INSERT INTO class_time (name, start_at, end_at)
VALUES ('ca 2', '09:20:00', '11:00:00');

INSERT INTO class_time (name, start_at, end_at)
VALUES ('ca 3', '13:20:00', '15:00:00');

INSERT INTO class_time (name, start_at, end_at)
VALUES ('ca 4', '15:20:00', '17:00:00');

INSERT INTO class_time (name, start_at, end_at)
VALUES ('ca 5', '17:20:00', '19:00:00');

INSERT INTO class_time (name, start_at, end_at)
VALUES ('ca 6', '19:20:00', '21:00:00');
##############################################################
#############class############
INSERT INTO class (name, type, grade, time, max_student)
VALUES ('12N1', 'NORMAL', 3, 1, 50);




