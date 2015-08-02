--update.sql

/* Update and Deletion Commands*/
UPDATE Student
SET Major = 'Computer Engineering'
WHERE Major = 'Computer Science';

UPDATE College
SET NumStudents = 25000
WHERE Name = 'Dwight Look College of Engineering';

DELETE FROM Employee
WHERE Employment_ID < 2000 AND Employment_ID > 1000;

DELETE FROM ProfessionalSocietyMember
WHERE Position = 'member';

INSERT INTO FinancialPackage
VALUES(1234,7000); 

INSERT INTO Student
VALUES(55555, 'Electrical Engineering','Nikola Tesla', 12, 1234, 'Dwight Look College of Engineering'); 

