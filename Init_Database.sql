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
    pseudo       VARCHAR(20)     NOT NULL,
    password     VARCHAR(20)     NOT NULL,
    adminn        BOOLEAN         NOT NULL DEFAULT FALSE
)ENGINE=MyISAM DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `manga`;
CREATE TABLE `manga`
(
    id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    creationDate DATE DEFAULT CURDATE(),
    updateDate   DATE DEFAULT CURDATE(),
    name         VARCHAR(100)    NOT NULL,
    resume VARCHAR(800),
    note         INT DEFAULT 0,
    image VARCHAR (200)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `review`
(
    id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    creationDate DATE DEFAULT CURDATE(),
    updateDate   DATE DEFAULT CURDATE(),
    text       VARCHAR(500),
    note         FLOAT DEFAULT 0.0,
    authorId INT,
    idManga INT,
    CONSTRAINT FK_users FOREIGN KEY (authorId)
        REFERENCES users(id),
    CONSTRAINT FK_manga FOREIGN KEY (idManga)
        REFERENCES manga(id)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
