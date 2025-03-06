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

INSERT INTO authority (name, account_id)
VALUES ('ROLE_ADMIN', 1);

INSERT INTO authority (name, account_id)
VALUES ('ROLE_ADMIN', 2);

INSERT INTO authority (name, account_id)
VALUES ('ROLE_STUDENT', 3);

INSERT INTO authority (name, account_id)
VALUES ('ROLE_TEACHER', 4);

INSERT INTO authority (name, account_id)
VALUES ('ROLE_TEACHER', 5);

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







