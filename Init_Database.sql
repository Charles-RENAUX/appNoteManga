CREATE DATABASE IF NOT EXISTS `projet_JEE`;


USE `projet_JEE`;
--
-- Table structure for table 
--

DROP TABLE IF EXISTS `review`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    creationDate DATE DEFAULT CURDATE(),
    updateDate   DATE DEFAULT CURDATE(),
    name         VARCHAR(20)     NOT NULL,
    firstname    VARCHAR(20)     NOT NULL,
    adress       VARCHAR(100),
    pseudo       VARCHAR(20)     NOT NULL,
    password     VARCHAR(20)     NOT NULL,
    age          INT,
    adminn        BOOLEAN         NOT NULL
)ENGINE=MyISAM DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `manga`;
CREATE TABLE `manga`
(
    id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    creationDate DATE DEFAULT CURDATE(),
    updateDate   DATE DEFAULT CURDATE(),
    name         VARCHAR(100)    NOT NULL,
    resume VARCHAR(800),
    note         INT,
    image VARCHAR (200)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `review`
(
    id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    creationDate DATE DEFAULT CURDATE(),
    updateDate   DATE DEFAULT CURDATE(),
    review       VARCHAR(500),
    autor        VARCHAR(20),
    note         INT,
    authorId INT,
    idManga INT,
    CONSTRAINT FK_users FOREIGN KEY (authorId)
        REFERENCES users(id),
    CONSTRAINT FK_manga FOREIGN KEY (idManga)
        REFERENCES manga(id)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO users (name,firstname,pseudo,password,adminn) VALUES ('Compte', 'Admin','admin','admin', TRUE)