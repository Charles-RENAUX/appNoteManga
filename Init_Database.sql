CREATE DATABASE 'projet_JEE'
CREATE USER user;
grant ALL PRIVILEGES on projet_JEE.* to user;
FLUSH PRIVILEGES;

USE 'projet_JEE';

--
-- Table structure for table 
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
{
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	creationDate DATE,
	updateDate DATE,
	name VARCHAR(20) NOT NULL,
	firstname VARCHAR(20) NOT NULL,
	adress VARCHAR(100) ,
	pseudo VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	age INT,
	admin BOOLEAN NOT NULL
}



DROP TABLE IF EXISTS `manga`;
CREATE TABLE `manga`
{
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	creationDate DATE,
	updateDate DATE,
	name VARCHAR(100) NOT NULL,
	edition VARCHAR(20),
	parutionDate DATE,
	note INT
	img VARCHAR(200)
}


DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`
{
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	creationDate DATE,
	updateDate DATE,
	review VARCHAR(500),
	autor VARCHAR(20),
	note INT,
	like INT,
	dislike INT
}


DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`
{
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	creationDate DATE,
	updateDate DATE,
	name VARCHAR(50) 
}


--- create user admin with right admin
INSERT INTO user VALUES (0,'Admin', 'Admin', '','admin','admin',0, TRUE)