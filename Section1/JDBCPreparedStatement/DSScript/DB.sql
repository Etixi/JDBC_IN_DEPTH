CREATE TABLE `employee_table` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(60) NOT NULL,
  `email` varchar(45) NOT NULL,
  `salary` double DEFAULT NULL,
  `date_of_joining` datetime DEFAULT NULL,
  `bonus` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
)

INSERT INTO employee_table(employee_name,email,salary,date_of_joining,bonus)
					VALUES('Paul','paul.cs2009@yahoo.com',60000.00,'2017-05-17',400.00);
DELETE FROM employee_table WHERE employee_id=2;
UPDATE employee_table SET email = 'martin.cs2017@yahoo.com' WHERE employee_id=1;