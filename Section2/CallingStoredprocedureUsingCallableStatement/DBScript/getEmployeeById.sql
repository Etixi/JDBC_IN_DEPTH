
CREATE TABLE `employee_table` (
  `employee_id` int(11) NOT NULL auto_increment,
  `employee_name` varchar(60) NOT NULL,
  `email` varchar(45) NOT NULL,
  `salary` double default NULL,
  `date_of_joining` datetime default NULL,
  `bonus` decimal(10,0) default NULL,
  PRIMARY KEY  (`employee_id`)
) ;



USE jdbcdb;
select * from employees;
-- Change the delimiter to something else
DELIMITER $$
-- Drop the procedure if it exists
DROP PROCEDURE IF EXISTS getEmployeeById;

-- Create the stored procedure
CREATE PROCEDURE `getEmployeeById`(IN empId INT)
BEGIN
    SELECT * FROM employee_table WHERE employee_id = empId;
END
$$

CALL getEmployeeById(3);