DROP DATABASE  IF EXISTS `spring_security`;

CREATE DATABASE  IF NOT EXISTS `spring_security`;
USE `spring_security`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `username` varchar(50) NOT NULL,
                         `password` char(68) NOT NULL,
                         `enabled` tinyint(1) NOT NULL,
                         PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.bcryptcalculator.com/encode
--
-- Default passwords here are: text123
--

INSERT INTO `users`
VALUES
('john','{bcrypt}$2a$10$DB4bD4zIY.73rT.jvG4ws.MXqOXz3iQ6JV9kK9xCeTFEalnjmpexO',1),
('mary','{bcrypt}$2a$10$wqJrChxp0T.PjPfcTG.qROBS6MKOcfnJsKGNtmeF7lc5Q0i6td4pS',1),
('susan','{bcrypt}$2a$10$k8E0PlY9QCppaT5Jgdyu9.bDIFcOoZMz6mi/5/4Dzkpoikfj7tCtO',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
                               `username` varchar(50) NOT NULL,
                               `authority` varchar(50) NOT NULL,
                               UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
                               CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');
