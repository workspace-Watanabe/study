DROP database IF EXISTS password;

CREATE DATABASE password;

use password;

CREATE TABLE user_password(
	id INT PRIMARY KEY,
	user_name VARCHAR(50),
	user_mail VARCHAR(50),
	password VARCHAR(50)
);


INSERT INTO user_password VALUES(1,'taiga','taiga@sample.com','password');