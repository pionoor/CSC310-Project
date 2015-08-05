
SELECT ROUND(AVG(CompletedHRS),0) AS 'Average Completed HRS'
FROM Student;

SELECT Name AS 'Employed Seniors'
FROM Employee
WHERE Employee.name IN (SELECT Name 
FROM Student 
WHERE CompletedHRS >=90 AND CompletedHRS <= 120);
			
			
