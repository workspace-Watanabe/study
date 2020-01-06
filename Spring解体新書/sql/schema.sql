CREATE database IF NOT EXISTS employee_schema;
USE employee_schema;

/* 従業員テーブル */
CREATE TABLE IF NOT EXISTS employee(
	employee_id INT PRIMARY KEY,
	employee_name VARCHAR(50),
	age INT
);

/* ユーザーマスタ */
CREATE TABLE IF NOT EXISTS m_user(
	user_id VARCHAR(50) PRIMARY KEY,
	password VARCHAR(100),
	user_name VARCHAR(50),
	birthday DATE,
	age INT,
	marriage BOOLEAN,
	role VARCHAR(50)
);

/* 従業員テーブルのデータ */
INSERT IGNORE INTO employee(employee_id, employee_name, age)
VALUES(1,'山田太郎', 30);

/* ユーザーマスタのデータ(アドミン権限) */
INSERT IGNORE INTO m_user (user_id, password, user_name, birthday, age, marriage, role)
VALUES('yamada@gmail.com', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '山田太郎', '1990-01-01', 28, false, 'ROLE_ADMIN');
/* ユーザーマスタのデータ(一般権限) */
INSERT IGNORE INTO m_user(user_id, password, user_name, birthday, age, marriage, role)
VALUES('tamura@gmail.com', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '田村達也', '1998-11-11', 31, false, 'ROLE_GENERAL')