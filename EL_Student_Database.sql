CREATE DATABASE Java_EL;
USE Java_EL;
/*
	Tables with Attributes:
		* Student: Reg_no, name, Roll_number, email_id ~
        * Subject: student_id, S_Code, EL_Score, Quiz_Score, Midsem_Score, Endsem_Score, Assignment_Score, Lab_Work, Attendence ~
        * Subject_Code_Detail: subject_Code, Subject_Name ~
        * Parents(Weak Entity): Name, Phone, Relationship ~
	
    Foreign Key Setup
		* Subject student_id ---> Student id ~
        * Subject S_Code ---> Subject_Code_Detail subject_code ~
        * Parents student_id ---> Student id ~
	
    Insert Random Values
		* Student
        * Subject
        * Enrolled_in
        * Subject_Code_Detail
        * Parents
*/

-- STUDENT

CREATE TABLE Student(
id bigint CHECK(id >= 1000000000 and id <= 9999999999),
name varchar(25),
roll_number varchar(8),
email_id varchar(30) CHECK(email_id LIKE '%@%.%'),
PRIMARY KEY(id));

DESCRIBE Student;


-- SUBJECT
CREATE TABLE Subject(
S_code varchar(10),
student_id bigint,
El_Score int CHECK(El_Score >= 0 and El_Score <= 20),
Quiz_Score int CHECK(Quiz_Score >= 0 and Quiz_Score <= 10),
Lab_Work_Score int CHECK(Lab_Work_Score >= 0 and Lab_Work_Score <= 10),
Assignment_Score int CHECK(Assignment_Score >= 0 and Assignment_Score <= 10),
Midsem_Score int CHECK(Midsem_Score >= 0 and Midsem_Score <= 20),
Endsem_Score int CHECK(Endsem_Score >= 0 and Endsem_Score <= 30),
Attendence int CHECK(Attendence >= 0 and Attendence <= 100),
PRIMARY KEY(S_Code, student_id)
);

DESCRIBE Subject;


-- SUBJECT_CODE_DETAIL
CREATE TABLE Subject_Code_Detail(
subject_code varchar(10),
subject_name varchar(20),
PRIMARY KEY(Subject_Code)
);

DESCRIBE Subject_Code_Detail;


-- PARENTS
CREATE TABLE Parents(
student_id int,
name varchar(25),
phone_no char(10) ,
relationship varchar(20),
PRIMARY KEY(student_id, name)
);

DESCRIBE Parents;




-- FOREIGN KEY CONFIGURATION
ALTER TABLE Subject
ADD FOREIGN KEY(student_id) REFERENCES Student(id),
ADD FOREIGN KEY(s_code) REFERENCES Subject_Code_Detail(subject_code);


ALTER TABLE Parents
ADD FOREIGN KEY(student_id) REFERENCES Student(id);


 

-- INSERTING VALUES INTO TABLES
	-- STUDENT
INSERT INTO Student (id, name, roll_number, email_id) VALUES 
(2101020123, 'Rajesh Singh', 'CSE21678', 'rajesh.singh@gmail.com'),
(2101020789, 'Priya Sharma', 'RAI21456', 'priya.sharma@gmail.com'),
(2101020567, 'Neha Gupta', 'CWT21543', 'neha.gupta@gmail.com'),
(2101020890, 'Ankit Yadav', 'CIT21901', 'ankit.yadav@gmail.com'),
(2101020234, 'Saurabh Dubey', 'COE21876', 'saurabh.dubey@gmail.com'),
(2101020321, 'Kavita Singh', 'CSE21543', 'kavita.singh@gmail.com'),
(2101020445, 'Deepak Sharma', 'AID21234', 'deepak.sharma@gmail.com'),
(2101020654, 'Rahul Verma', 'RAI21908', 'rahul.verma@gmail.com'),
(2101020543, 'Priyanka Patel', 'CIT21679', 'priyanka.patel@gmail.com'),
(2101020356, 'Vikas Kumar', 'CWT21456', 'vikas.kumar@gmail.com'),
(2101020908, 'Anjali Gupta', 'COE21902', 'anjali.gupta@gmail.com'),
(2101020780, 'Nitin Singh', 'CSE21789', 'nitin.singh@gmail.com'),
(2101020678, 'Sneha Sharma', 'AID21789', 'sneha.sharma@gmail.com'),
(2101020124, 'Vivek Verma', 'CIT21567', 'vivek.verma@gmail.com'),
(2101020456, 'Rohit Dubey', 'COE21789', 'rohit.dubey@gmail.com'),
(2101020345, 'Ankit Singh', 'RAI21567', 'ankit.singh@gmail.com'),
(2101020901, 'Sandeep Yadav', 'CSE21456', 'sandeep.yadav@gmail.com'),
(2101020762, 'Anurag Raj', 'CIT21105', 'anuragraj25@gmail.com'),
(2101020765, 'Jon Snow', 'CIT21106', 'jonsnowgot@gmail.com'),
(2101020768, 'Barry Allen', 'CIT21108', 'barrytheflash@gmail.com');

SELECT * FROM Student where id = 2101020124;


	-- SUBJECT
INSERT INTO Subject (S_code, student_id, El_Score, Quiz_Score, Lab_Work_Score, Assignment_Score, Midsem_Score, Endsem_Score, Attendence) VALUES 
('CSE23306A', 2101020123, 18, 8, 9, 9, 17, 27, 95),
('CSE23306A', 2101020789, 15, 7, 8, 8, 16, 24, 87),
('CSE23306A', 2101020567, 20, 9, 10, 10, 20, 30, 94),
('CSE23306A', 2101020890, 17, 8, 8, 9, 16, 25, 89),
('CSE23306A', 2101020234, 19, 9, 9, 10, 18, 27, 92),
('CSE23306B', 2101020321, 16, 7, 7, 8, 15, 23, 83),
('CSE23306B', 2101020445, 18, 8, 8, 9, 16, 26, 85),
('CSE23306B', 2101020654, 19, 9, 9, 10, 18, 28, 91),
('CSE23306B', 2101020543, 17, 8, 7, 8, 15, 24, 84),
('CSE23306B', 2101020356, 20, 10, 10, 10, 19, 29, 96),
('CSE23307', 2101020908, 19, 8, 8, 9, 18, 27, 88),
('CSE23307', 2101020780, 18, 8, 7, 8, 16, 26, 83),
('CSE23307', 2101020678, 17, 7, 7, 8, 15, 23, 82),
('CSE23307', 2101020124, 16, 6, 7, 7, 14, 22, 81),
('CSE23307', 2101020456, 15, 6, 6, 7, 13, 21, 80),
('CSE23308', 2101020345, 18, 7, 8, 8, 16, 25, 86),
('CSE23308', 2101020901, 19, 8, 9, 9, 18, 28, 90),
('CSE23308', 2101020762, 20, 10, 10, 9, 19, 30, 95),
('CSE23308', 2101020765, 16, 6, 6, 7, 14, 22, 80),
('CSE23309', 2101020768, 20, 10, 10, 10, 20, 30, 100);

SELECT * FROM Subject;


	-- SUBJECT_CODE_DETAIL
INSERT INTO Subject_Code_Detail (subject_code, subject_name) VALUES
('CSE23306', 'DBE'),
('CSE23307', 'DAA'),
('CSE23308', 'CO'),
('CSE23309', 'OOP'),
('UGE21101', 'LBES');

SELECT * FROM Subject_Code_Detail;


	-- PARENTS
INSERT INTO Parents (student_id, name, phone_no, relationship) VALUES
(2101020123, 'Anita Sharma', '9876543210', 'Mother'), 
(2101020123, 'Sunil Sharma', '9876543211', 'Father'),
(2101020789, 'Meera Gupta', '9876543212', 'Mother'),
(2101020789, 'Rakesh Gupta', '9876543213', 'Father'),
(2101020567, 'Kavita Singh', '9876543214', 'Mother'),
(2101020567, 'Rajiv Singh', '9876543215', 'Father'),
(2101020234, 'Asha Patel', '9876543218', 'Mother'),
(2101020234, 'Ramesh Patel', '9876543219', 'Father'),
(2101020321, 'Neha Sinha', '9876543220', 'Mother'),
(2101020321, 'Alok Sinha', '9876543221', 'Father'),
(2101020654, 'Vidya Gupta', '9876543224', 'Mother'),
(2101020654, 'Rahul Gupta', '9876543225', 'Father'),
(2101020543, 'Preeti Sharma', '9876543226', 'Mother'),
(2101020543, 'Amit Sharma', '9876543227', 'Father'),
(2101020356, 'Nalini Verma', '9876543228', 'Mother'),
(2101020356, 'Pradeep Verma', '9876543229', 'Father'),
(2101020908, 'Radha Singh', '9876543230', 'Mother'),
(2101020908, 'Amit Singh', '9876543231', 'Father'),
(2101020780, 'Madhu Gupta', '9876543232', 'Mother'),
(2101020780, 'Manish Gupta', '9876543233', 'Father'),
(2101020678, 'Kiran Sharma', '9876543234', 'Mother'),
(2101020678, 'Vikram Sharma', '9876543235', 'Father'),
(2101020124, 'Deepika Singh', '9876543236', 'Mother'),
(2101020124, 'Vijay Singh', '9876543237', 'Father'),
(2101020456, 'Sangeeta Jain', '9876543238', 'Mother'),
(2101020456, 'Rajesh Jain', '9876543239', 'Father'),
(2101020345, 'Ankit Kumar', '9898989898', 'Father'),
(2101020345, 'Rita Kumari', '9797979797', 'Mother'),
(2101020901, 'Suresh Singh', '9899889898', 'Father'),
(2101020901, 'Rashmi Singh', '9799979797', 'Mother'),
(2101020762, 'Mukesh Kumar', '9835533111', 'Father'),
(2101020762, 'Gayatri Devi', '9934181721', 'Mother'),
(2101020765, 'Ramesh Kumar', '9797969696', 'Father'),
(2101020765, 'Pooja Devi', '9898989899', 'Mother'),
(2101020768, 'Amit Sharma', '9897989898', 'Father'),
(2101020768, 'Shalini Sharma', '9797979798', 'Mother'),
(2101020890, 'Alok Kumar', '9898987989', 'Father'),
(2101020890, 'Kamini Kumari', '9798989798', 'Mother'),
(2101020445, 'Manoj Sharma', '9797978999', 'Father'),
(2101020445, 'Mamta Sharma', '9898989798', 'Mother');

SELECT * FROM Parents;



-- SOME JOIN QUERRIES
SELECT 
	Student.id, Student.name,
    Subject.S_code, Subject.midsem_score, Subject.endsem_score,
    Subject_Code_Detail.subject_name
FROM
	Student
INNER JOIN
	Subject
ON 
	Subject.student_id = Student.id
INNER JOIN
	Subject_Code_Detail
ON
	Subject.S_Code = Subject_Code_Detail.subject_code
WHERE
	Student.name = 'Anurag Raj';

