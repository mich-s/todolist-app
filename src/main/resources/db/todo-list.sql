DROP SCHEMA IF EXISTS `todolist-app`;

CREATE SCHEMA `todolist-app`;

use `todolist-app`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` boolean NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$04$ZYWFzqBCMPVD8sh7WicVD.6RjXZETen/DDdVBSTnks0FXWruNkYj2',true),
('meg','{bcrypt}$2a$04$LAUKoUyiMaPGtKYk/.5AFOKrKpVD9gBdpwY7rxwRk0VnEwnEf3fDW',true);



DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` 
VALUES 
('john','ROLE_USER'),
('john','ROLE_ADMIN'),
('meg','ROLE_USER');



DROP TABLE IF EXISTS `lists`;

CREATE TABLE `lists` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `user_username` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_USER_USERNAME_idx` (`user_username`),
  
  CONSTRAINT `FK_USER_USERNAME` 
  FOREIGN KEY (`user_username`) 
  REFERENCES `users` (`username`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `lists` 
VALUES 
(1,'house','meg'),
(2,'work','meg'),
(3,'social & family','meg'),
(4,'groceries','meg');

DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task` varchar(150) DEFAULT NULL,
  `done` tinyint(4) NOT NULL DEFAULT '0',
  `list_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_LIST_ID_idx` (`list_id`),
  
  CONSTRAINT `FK_LIST_ID` 
  FOREIGN KEY (`list_id`) 
  REFERENCES `lists` (`id`) 
  
  ON DELETE CASCADE 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `tasks` 
VALUES 
(1,'buy paper towels',1,1),
(2,'buy cat food at pet store',0,1),
(3,'water the plants',0,1),
(4,'pick up dry cleaning',1,1),
(5,'cook a dinner',0,1),
(6,'prepare to the presentation',0,2),
(7,'schedule a meeting',0,2),
(8,'reply to morning emails',0,2),
(9,'bake a cake for mother\'s day ',0,3),
(10,'call Susan',1,3),
(11,'order the book for Sean',0,3),
(12,'buy flowers for Mom',0,3),
(13,'call Diane about playdate',0,3),
(14,'milk',1,4),
(15,'cheese',1,4),
(16,'bread',1,4),
(17,'eggs',0,4),
(18,'wine',0,4),
(19,'pasta',1,4),
(20,'olives',0,4),
(21,'tomato',1,4),
(22,'bananas',0,4),
(23,'strawberries',0,4),
(24,'butter',1,4);

SET FOREIGN_KEY_CHECKS = 1;
