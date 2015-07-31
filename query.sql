/* Theta Join */
SELECT Student.name, FinancialPackage.TotalAwardAmount AS 'Financial Aid',
Employee.salary
FROM Student, Employee, FinancialPackage
WHERE Student.name = Employee.name AND Salary >= 11.00
AND Student.FinancialAidPackageID = FinancialPackage.PackageID;

SELECT Student.Name AS 'Employed' 
FROM Student, ProfessionalSocietyMember,  Employee 
WHERE Student.name = ProfessionalSocietyMember.membername 
AND Student.name = Employee.name;

/*General Query*/
SELECT UIN, Name AS 'Seniors' 
FROM Student 
WHERE CompletedHRS >=90 AND CompletedHRS <= 120;

SELECT NumStudents AS '# ENG & SCI Students' 
FROM College 
WHERE Name LIKE 'Dwight Look%' OR Name LIKE '%Science';

SELECT MemberName AS 'New Members'  
FROM ProfessionalSocietyMember 
WHERE Position = 'member' AND MemberSince >= '2013';

/* Union */
SELECT name
FROM Student 
UNION 
SELECT MemberName
FROM ProfessionalSocietyMember; 

/* Group By */
SELECT Position, salary
FROM Employee 
GROUP BY salary;

/*Order By */
SELECT name, CompletedHRS
FROM Student
WHERE CompletedHRS > 90 ORDER BY CompletedHRS ASC;

/*Distinct */
SELECT DISTINCT position
FROM Employee
WHERE position LIKE 's%';

/* Aggregate */
SELECT ROUND(AVG(salary), 2) AS 'AVG Salary' 
FROM Employee
WHERE name LIKE 't%';
