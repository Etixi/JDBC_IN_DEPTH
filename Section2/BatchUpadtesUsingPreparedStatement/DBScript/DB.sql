CREATE TABLE `employee_table` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(60) NOT NULL,
  `email` varchar(45) NOT NULL,
  `salary` double DEFAULT NULL,
  `date_of_joining` datetime DEFAULT NULL,
  `bonus` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
)