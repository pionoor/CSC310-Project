insertSmallData.sql

INSERT INTO Employees (Employement_ID, Salary, Name, 
		Position, StudentUIN)
VALUES 
		(5046,9.00, 'Jim Dawson', 'Student Worker I', 22465),
		(2054,12.00, 'Steve Hickson', 'Student Worker III', 19475),
		(5422,9.00, 'Taylor Riggs', 'Student Worker I', 21084),
		(4387,11.00, 'Alice Bridges', 'Student Worker II', 20897),
		(1645,12.00, 'Cooper Wilson', 'Student Worker III', 20804);

INSERT INTO FinancialPackage (PackageID, TotalAwardAmount)
VALUES 
		(6445, 12000),
		(4684, 11546),
		(1946, 10600),
		(3379, 5430),
		(5061, 7480);

INSERT INTO Colleges(Name, NumFacultyMembers, NumStudents)
VALUES 
		('Dwight Look College of Engineering',793, 13947),
		('College of Liberal Arts', 780, 7669),
		('College of Science', 734,	3701),
		('Mays Business School', 264, 5914),
		('College of Agriculture & Life Science', 643, 7853);


INSERT INTO Student(UIN, Major, Name, CompletedHRS, 
		FinancialAidPackageID, College)
VALUES 
		(22465, 'Computer Science', Jim Dawson, 93, 12000.00, 'Dwight Look College of Engineering'),
		(19475, 'Anthropology',	'Steve Hickson', 62, 11546.00, 'College of Liberal Arts'),
		(21084, 'Mathematics', 'Taylor Riggs', 115, 10600.00, 'College of Science'),
		(20897, 'Accounting', 'Alice Bridges', 95, 5430.00, 'Mays Business School'),
		(20804, 'Biochemistry', 'Cooper Wilson', 35, 7480.00, 'College of Agriculture & Life Science');
		
INSERT INTO ProfessionalSociety(SocietyName, Participants, ParentOrganization, College)
VALUES ();

INSERT INTO ProfessionalSocietyMember(HomeAddress, Position, MemberName, MemberSince, ProfessionalSociety)
VALUES 
		('2213 Plum St', 'member', 'Taylor Riggs', 2013, ),
		('532 W Natal St', 'president', 'Alice Bridges', 2015, ),
		('3002 Larchmont', 'member', 'Cooper Wilson' 2014, ),
		('4027 N 3rd St', 'vice president', 'Marcus Aurelius', 2012, )
		('3570 S Las Vegas Blvd', 'secretary', 'Julius Ceasar', 2013, );