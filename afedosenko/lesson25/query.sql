#SELECT Name, CountryCode, Population 
#FROM city
#WHERE CountryCode = 'UKR' AND Population < 100000
#SELECT Name, Population FROM city WHERE Name LIKE 'Ode%a';
#create database engineers
#
#CREATE TABLE engineer (
#id INT,
#name VARCHAR(30),
#salary DECIMAL,
#works_since TIMESTAMP
#);
#SELECT * FROM engineer;

#INSERT INTO engineer VALUES (1, 'John Doe', 100, 20120101);
#INSERT INTO engineer VALUES (2, 'Jane Roe', 100, 20120101);
#INSERT INTO engineer VALUES (6, 'John6 Doe6', 200, 20120101);
SELECT * FROM engineer;
SELECT * FROM engineer WHERE name LIKE 'J___ %';


