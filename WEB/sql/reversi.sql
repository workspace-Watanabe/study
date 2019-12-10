DROP DATABASE IF EXISTS reversi;
CREATE DATABASE reversi;
USE reversi;

/*======リバーシテーブルを作る=====*/
CREATE TABLE reversi(
	id INT  AUTO_INCREMENT NOT NULL PRIMARY KEY,
	column_ INT,/* 列 */
	line INT,  /* 行 */
	status VARCHAR(50) /* 盤面の状態 */
);