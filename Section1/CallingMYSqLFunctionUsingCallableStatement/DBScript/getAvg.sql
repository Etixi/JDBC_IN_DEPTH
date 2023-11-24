
CREATE TABLE `employee_table` (
  `employee_id` int(11) NOT NULL auto_increment,
  `employee_name` varchar(60) NOT NULL,
  `email` varchar(45) NOT NULL,
  `salary` double default NULL,
  `date_of_joining` datetime default NULL,
  `bonus` decimal(10,0) default NULL,
  PRIMARY KEY  (`employee_id`)
) ;


-- Change the delimiter to something else
DELIMITER $$

USE `jdbcdb`$$

-- Drop the function if it exists
DROP FUNCTION IF EXISTS `getAvg`$$

-- Create the function with DETERMINISTIC and READS SQL DATA attributes
CREATE FUNCTION `getAvg` (n1 INT, n2 INT)
RETURNS INTEGER
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE avgNum INTEGER;
    SET avgNum = (n1 + n2) / 2;
    RETURN avgNum;
END$$

-- Reset the delimiter back to semicolon
DELIMITER ;
