/* データベース: item_manager_db */
DROP DATABASE IF EXISTS item_manager_db;
CREATE DATABASE item_manager_db CHARACTER SET utf8 COLLATE utf8_general_ci;

/* ユーザを作成 */
DROP USER IF EXISTS itemU;
CREATE USER itemU IDENTIFIED BY 'itemP';

/* 権限付与 */
GRANT ALL PRIVILEGES ON item_manager_db.* TO 'itemU';

/* DBの選択*/
USE item_manager_db;

/* ユーザマスタテーブル作成*/
CREATE TABLE m_user (
  user_id VARCHAR(24),
  password varchar(32) NOT NULL,
  PRIMARY KEY(user_id)
);

/* メーカーテーブル作成 */
CREATE TABLE m_maker (
    maker_code CHAR(5) not NULL,
    maker_name VARCHAR(24) not NULL UNIQUE,
    
    PRIMARY KEY(maker_code)
);

/* 商品マスタテーブル作成 */
CREATE TABLE m_item (
    item_id INT not NULL AUTO_INCREMENT,
    item_name VARCHAR(24) not NULL,
    maker_code CHAR(5) not NULL,
    price INT not NULL,
    insert_datetime TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP,
    update_datetime TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    PRIMARY KEY(item_id),
    
    FOREIGN KEY (maker_code)
      REFERENCES m_maker(maker_code)
);

/* 在庫トランザクションテーブル作成 */
CREATE TABLE t_stock (
    stock_id INT not NULL AUTO_INCREMENT,
    item_id INT not NULL,
    arrival INT not NULL,
    shipping INT not NULL,
    stock INT not NULL,
    insert_datetime TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP,
    update_datetime TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    PRIMARY KEY(stock_id),
    
    FOREIGN KEY (item_id)
      REFERENCES m_item(item_id)
);

/* ユーザマスタINSERT */
INSERT INTO m_user
  VALUES('user', 'password');

/* メーカーマスタINSERT*/
INSERT INTO m_maker
VALUES
('M0000', 'No manufacturer'),
('M0001', 'TOYOTA'),
('M0002', 'HONDA'),
('M0003', 'NISSAN');

/* 商品マスタINSERT*/
INSERT INTO m_item (item_name, maker_code, price, insert_datetime, update_datetime)
VALUES
('ALPHARD', 'M0001', 600, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('NBOX', 'M0002', 1000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('NOTE', 'M0003', 800, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('PRIUS', 'M0001', 1400, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('TEST', 'M0000', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

/* 在庫トランザクションINSERT*/
INSERT INTO t_stock (item_id, arrival, shipping, stock, insert_datetime, update_datetime) 
VALUES
(1, 1000, 0, 1000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

COMMIT;
