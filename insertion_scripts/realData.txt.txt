

INSERT INTO FinancialPackage (PackageID, TotalAwardAmount)
VALUES 
		(6445, 12000),
		(4684, 11546),
		(1946, 10600),
		(3379, 5430),
		(5061, 7480);
		
INSERT INTO College(Name, NumFacultyMembers, NumStudents)
VALUES 
		('Dwight Look College of Engineering',793, 13947),
		('College of Liberal Arts', 780, 7669),
		('College of Science', 734,	3701),
		('Mays Business School', 264, 5914),
		('College of Agriculture & Life Science', 643, 7853);		

INSERT INTO Student(UIN, Major, Name, CompletedHRS, 
		FinancialAidPackageID, College)
VALUES 
		(22465, 'Computer Science', 'Jim Dawson', 93, 6445, 'Dwight Look College of Engineering'),
		(19475, 'Anthropology',	'Steve Hickson', 62, 4684, 'College of Liberal Arts'),
		(21084, 'Mathematics', 'Taylor Riggs', 115, 1946, 'College of Science'),
		(20897, 'Accounting', 'Alice Bridges', 95, 3379, 'Mays Business School'),
		(20804, 'Biochemistry', 'Cooper Wilson', 35, 5061, 'College of Agriculture & Life Science');		
		
INSERT INTO Employee (Employement_ID, Salary, Name, 
		Position, StudentUIN)
VALUES 
		(5046,9.00, 'Jim Dawson', 'Student Worker I', 22465),
		(2054,12.00, 'Steve Hickson', 'Student Worker III', 19475),
		(5422,9.00, 'Taylor Riggs', 'Student Worker I', 21084),
		(4387,11.00, 'Alice Bridges', 'Student Worker II', 20897),
		(1645,12.00, 'Cooper Wilson', 'Student Worker III', 20804);

INSERT INTO ProfessionalSociety(SocietyName, Participants, ParentOrganization, College)
VALUES 
		('Texas A&M Computing Society', 41, 'IEEE', 'Dwight Look College of Engineering'),
		('Alpha Pi Mu', 54, 'American Mathematical Society', 'College of Science'),
		('Sigma Beta Sigma', 33, 'Texas Society of CPA', 'Mays Business School'),
		('Beta Kappa Phi', 54, 'Association of Future Veteranarians', 'College of Agriculture & Life Science'),
		('Sigma Alpha Pi', 6, 'The National Society of Leadership and Success', 'College of Liberal Arts');

INSERT INTO ProfessionalSocietyMember(HomeAddress, Position, MemberName, MemberSince, ProfessionalSociety)
VALUES 
		('2213 Plum St', 'member', 'Taylor Riggs', '2013-04-20', 'Alpha Pi Mu'),
		('532 W Natal St', 'president', 'Alice Bridges', '2015-03-15', 'Sigma Beta Sigma' ),
		('3002 Larchmont', 'member', 'Cooper Wilson', '3014-01-10', 'Beta Kappa Phi'),
		('4027 N 3rd St', 'vice president', 'Marcus Aurelius', '2012-10-23', 'Sigma Alpha Pi'),
		('3570 S Las Vegas Blvd', 'secretary', 'Julius Ceasar', '2013-10-30', 'Sigma Alpha Pi');
		
		