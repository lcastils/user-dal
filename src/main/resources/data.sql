DROP TABLE IF EXISTS phones;
DROP TABLE IF EXISTS user_data;
CREATE TABLE user_data (
  id  BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  token VARCHAR(255) NOT NULL,
  creation_date DATETIME NOT NULL,
  update_date DATETIME,
  last_login DATETIME,
  is_active TINYINT NOT NULL
);

CREATE TABLE phones (
  id  BIGINT AUTO_INCREMENT  PRIMARY KEY,
  number   BIGINT (9) NOT NULL,
  citycode  BIGINT(1) NOT NULL,
  contrycode  BIGINT(2) NOT NULL,
  user_id  BIGINT 
);

ALTER TABLE phones 
ADD FOREIGN KEY (user_id) REFERENCES user_data(id);
 
INSERT INTO user_data (name, email, password,token,creation_date,update_date,last_login,is_active) VALUES
  ('Juan Rodriguez', 'juan@rodriguez.cl', 'XSu1Vb5J','testToken',  CURRENT_TIMESTAMP(),null,CURRENT_TIMESTAMP(),1);
  
  insert into phones (number,citycode,contrycode,user_id) values (12314,1,12,1);
  insert into phones (number,citycode,contrycode,user_id) values (11111,1,12,1);
