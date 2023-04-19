DROP TABLE IF EXISTS  users;

CREATE TABLE  users(
userid INT PRIMARY KEY AUTO_INCREMENT,
username varchar(50),
password varchar(100)
);

DROP TABLE IF EXISTS themes;
CREATE TABLE themes(
 themeid INT PRIMARY KEY AUTO_INCREMENT,
 theme varchar(100)
);


DROP TABLE IF EXISTS events;
CREATE TABLE events(
eventid INT PRIMARY KEY AUTO_INCREMENT,
themeid INT,
time DATETIME,
title varchar(100),
content varchar(500),
url varchar(500),
foreign key  (themeid) references themes(themeid)
);


insert into users(username, password) VALUES ('sjtu','123456');