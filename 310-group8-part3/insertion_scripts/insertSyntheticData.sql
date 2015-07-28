LOAD DATA LOCAL INFILE './synthetic_data/FinancialPackage.txt'
INTO TABLE FinancialPackage COLUMNS TERMINATED BY '\t';

LOAD DATA LOCAL INFILE './synthetic_data/College.txt'
INTO TABLE College COLUMNS TERMINATED BY '\t';

LOAD DATA LOCAL INFILE './synthetic_data/Student.txt'
INTO TABLE Student COLUMNS TERMINATED BY '\t';

LOAD DATA LOCAL INFILE '/synthetic_data/Employee.txt'
INTO TABLE Employee COLUMNS TERMINATED BY '\t';

LOAD DATA LOCAL INFILE './synthetic_data/ProfessionalSociety.txt'
INTO TABLE ProfessionalSociety COLUMNS TERMINATED BY '\t';

LOAD DATA LOCAL INFILE './synthetic_data/ProfessionalSocietyMember.txt'
INTO TABLE ProfessionalSocietyMember COLUMNS TERMINATED BY '\t';

