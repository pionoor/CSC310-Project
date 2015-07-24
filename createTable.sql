
CREATE DATABASE `pionoor-310project`;
USE pionoor-310project;


CREATE TABLE FinancialPackage (

PackageID INT PRIMARY KEY,
TotalAwardAmount INT
);

CREATE TABLE Colleges (
Name CHAR(25) PRIMARY KEY,
NumFacultyMembers INT, 
NumStudents INT
);

CREATE TABLE Student(
UIN			INT PRIMARY KEY,
Major			VARCHAR(20),
Name			VARCHAR(25),
CompletedHRS	INT,
FinancialAidPackageID INT NOT NULL,
 FOREIGN KEY(FinancialAidPackageID) REFERENCES 
FinancialPackage(PackageID),
College CHAR(25) NOT NULL REFERENCES Colleges(Name) 
);


CREATE TABLE Employees (

Employement_ID INT PRIMARY KEY,
Salary DECIMAL(4,2),
Name CHAR(25),
Position CHAR(10),
StudentUIN INT NOT NULL,
FOREIGN KEY(StudentUIN)
 REFERENCES Student(UIN)
);


CREATE TABLE ProfesstionalSociety(
Societyname     VARCHAR(45) PRIMARY KEY,
Participants		INT,
ParentOrganization	VARCHAR(40),
College CHAR(25) NOT NULL REFERENCES Colleges(Name) 
);

CREATE TABLE ProfessionalSocietyMember(
HomeAddress		VARCHAR(30),
Position		VARCHAR(10),
MemberName		VARCHAR(20),
MemberSince		DATE,
PRIMARY KEY (HomeAddress, Position, MemberName),
Professionalsociety CHAR(25) NOT NULL REFERENCES ProfessionalSociety(Societyname)
);



