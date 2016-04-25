CREATE DATABASE IF NOT EXISTS android_db;
USE android_db;

CREATE TABLE `users` (
  `user` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`user`,`password`),
  UNIQUE KEY `email` (`email`));

CREATE TABLE `friends` (
`user` varchar(255) NOT NULL,
`friend` varchar(255) NOT NULL,
`hunts_played` int(11) DEFAULT 0,
 `avg_hunt_score` double DEFAULT '0',
PRIMARY KEY (`user`,`friend`),
KEY `friend` (`friend`),
CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`user`) REFERENCES `users` (`user`) ON DELETE CASCADE,
CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`friend`) REFERENCES `users` (`user`) ON DELETE CASCADE);

CREATE TABLE `friend_request` (
`user` varchar(255) NOT NULL,
`request` varchar(255) NOT NULL,
PRIMARY KEY (`user`,`request`),
KEY `request` (`request`),
CONSTRAINT `friend_request_ibfk_1` FOREIGN KEY (`user`) REFERENCES `users` (`user`) ON DELETE CASCADE,
CONSTRAINT `friends_request_ibfk_2` FOREIGN KEY (`request`) REFERENCES `users` (`user`) ON DELETE CASCADE);

CREATE TABLE photos (
`user` varchar(255) not null,
`friend` varchar(255) not null,
`photo_location` varchar(255) not null,
`create_time` timestamp not null,
PRIMARY KEY (`user`,`friend`,`photo_location`),
CONSTRAINT `users_ibfk_1` foreign key (`user`) references users(`user`) on delete cascade,
CONSTRAINT `users_ibfk_2` foreign key (`friend`) references users(`user`) on delete cascade );

CREATE TABLE `current_hunts` (
  `sender` varchar(255) NOT NULL DEFAULT '',
  `rater` varchar(255) NOT NULL DEFAULT '',
  `rating` float DEFAULT '-1',
  `topic` varchar(255) NOT NULL,
  `photo_sent` tinyint(1) NOT NULL DEFAULT '0',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sender`,`rater`),
  KEY `friend` (`rater`),
  CONSTRAINT `current_hunts_ibfk_1` FOREIGN KEY (`sender`) REFERENCES `users` (`user`) ON DELETE CASCADE,
  CONSTRAINT `current_hunts_ibfk_2` FOREIGN KEY (`rater`) REFERENCES `users` (`user`) ON DELETE CASCADE
