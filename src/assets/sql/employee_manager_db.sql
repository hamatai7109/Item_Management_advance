/* データベース: employee_manager_db */
DROP DATABASE IF EXISTS employee_manager_db;
CREATE DATABASE employee_manager_db CHARACTER SET utf8 COLLATE utf8_general_ci;


/* ユーザを作成 */
DROP USER IF EXISTS demoUser;
CREATE USER demoUser IDENTIFIED BY 'demoPass';


/* 権限付与 */
GRANT ALL PRIVILEGES ON employee_manager_db.* TO 'demoUser';


/* DBの選択*/
USE employee_manager_db;


/* ユーザマスタテーブル作成*/
CREATE TABLE m_user (
  user_id VARCHAR(24),
  password varchar(32) NOT NULL,
  PRIMARY KEY(user_id)
);

/* 部署マスタテーブル作成 */
CREATE TABLE m_section (
	section_code CHAR(4),
	section_name VARCHAR(24) not NULL UNIQUE,
	PRIMARY KEY(section_code)
);


/* 経験言語マスタテーブル作成 */
CREATE TABLE m_language (
	language_code CHAR(4),
	language_name VARCHAR(32) not NULL UNIQUE,
	PRIMARY KEY(language_code)
);


/* 従業員マスタテーブル作成 */
CREATE TABLE m_employee (
	employee_id INT not NULL AUTO_INCREMENT,
	l_name VARCHAR(20) not NULL,
	f_name VARCHAR(20) not NULL,
	gender CHAR(1) not NULL,
	birthday DATE,
	phone_number VARCHAR(13) not NULL,
	section_code CHAR(4) not NULL,
	language_code CHAR(4) not NULL,
	hire_date DATE,
	update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	
	PRIMARY KEY(employee_id),
	
	FOREIGN KEY (section_code)
      REFERENCES m_section(section_code),

	FOREIGN KEY (language_code)
      REFERENCES m_language(language_code)
);


/* ユーザマスタINSERT */
INSERT INTO m_user
  VALUES('user', 'password');


/* 部署マスタINSERT*/
INSERT INTO m_section
VALUES
('S000', 'independent'),
('S001', 'human_resources'),
('S002', 'system_development'),
('S003', 'sales'),
('S004', 'education');


/* 経験言語マスタINSERT*/
INSERT INTO m_language
VALUES
('L000', 'No language'),
('L001', 'PHP'),
('L002', 'Java'),
('L003', 'Javascript'),
('L004', 'Python'),
('L005', 'SQL');


/* 従業員マスタINSERT*/
INSERT INTO m_employee
VALUES
(0, 'yamada', 'taro', 'm', '19910105', '9011297222', 'S000', 'L000', '20220401', CURRENT_TIMESTAMP),
(0, 'kubo', 'takefusa', 'm', '19920305', '9011112018', 'S001', 'L001', '20220501', CURRENT_TIMESTAMP),
(0, 'doan', 'ritsu', 'm', '19940108', '9011122342', 'S002', 'L002', '20220601', CURRENT_TIMESTAMP),
(0, 'tomiyasu', 'takehiro', 'm', '19950405', '9013562222', 'S003', 'L003', '20220701', CURRENT_TIMESTAMP),
(0, 'minamino', 'takumi', 'm', '19981205', '9011190172', 'S004', 'L004', '20220801', CURRENT_TIMESTAMP),
(0, 'sawa', 'homare', 'f', '19930425', '9035642222', 'S001', 'L005', '20220901', CURRENT_TIMESTAMP),
(0, 'kawasumi', 'nahomi', 'f', '19960815', '9011667222', 'S002', 'L001', '20221001', CURRENT_TIMESTAMP),
(0, 'maruyama', 'karina', 'f', '19940112', '9011987652', 'S003', 'L000', '20221101', CURRENT_TIMESTAMP),
(0, 'mitoma', 'kaoru', 'm', '19931005', '9011256722', 'S004', 'L002', '20221201', CURRENT_TIMESTAMP),
(0, 'hasegawa', 'yui', 'f', '20000905', '9011987142', 'S000', 'L003', '20230401', CURRENT_TIMESTAMP),
(0, 'moriyasu', 'hajime', 'm', '19810122', '9011124561', 'S001', 'L004', '20230501', CURRENT_TIMESTAMP),
(0, 'hamano', 'taishi', 'm', '19980515', '9011542784', 'S002', 'L005', '20230601', CURRENT_TIMESTAMP);


COMMIT;
