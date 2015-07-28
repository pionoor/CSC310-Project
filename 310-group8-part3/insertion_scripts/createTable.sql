--using ambago-db1;

CREATE TABLE FinancialPackage (

PackageID INT PRIMARY KEY,
TotalAwardAmount INT
);

CREATE TABLE College (
Name CHAR(50) PRIMARY KEY,
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
College CHAR(50) NOT NULL REFERENCES Colleges(Name) 
);

CREATE TABLE Employee (
Employement_ID INT PRIMARY KEY,
Salary DECIMAL(4,2),
Name CHAR(25),
Position CHAR(20),
StudentUIN INT NOT NULL,
FOREIGN KEY(StudentUIN)
 REFERENCES Student(UIN)
);

CREATE TABLE ProfessionalSociety(
Societyname     VARCHAR(45) PRIMARY KEY,
Participants		INT,
ParentOrganization	VARCHAR(50),
College CHAR(50) NOT NULL REFERENCES Colleges(Name) 
);

CREATE TABLE ProfessionalSocietyMember(
HomeAddress		VARCHAR(25),
Position		VARCHAR(20),
MemberName		VARCHAR(25),
MemberSince		DATE,
PRIMARY KEY (HomeAddress, Position, MemberName),
ProfessionalSociety CHAR(20) NOT NULL REFERENCES ProfessionalSociety(Societyname)
);



