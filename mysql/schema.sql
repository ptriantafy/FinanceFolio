-- SQLBook: Code
DROP SCHEMA IF EXISTS FinanceFolio;
CREATE SCHEMA FinanceFolio;
USE FinanceFolio;

CREATE TABLE user (
  user_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  register_date DATETIME DEFAULT now(),
  PRIMARY KEY  (user_id),
  CONSTRAINT `unq_user_name` UNIQUE(username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE member(
  member_id SMALLINT UNSIGNED NOT NULL,
  category TINYINT UNSIGNED NOT NULL,
  income DECIMAL(10,2),
  house_area SMALLINT UNSIGNED,
  residents TINYINT UNSIGNED,
  premium_user BOOLEAN DEFAULT FALSE NOT NULL,
  PRIMARY KEY (member_id),
  CONSTRAINT `fk_user_member_id` FOREIGN KEY (member_id) REFERENCES user (user_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE expert(
  expert_id SMALLINT UNSIGNED NOT NULL,
  average_rating TINYINT UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (expert_id),
  CONSTRAINT `fk_user_expert_id` FOREIGN KEY (expert_id) REFERENCES user (user_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE review(
  review_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  author_id SMALLINT UNSIGNED NOT NULL,
  rating TINYINT UNSIGNED NOT NULL DEFAULT 1,
  review_date DATE NOT NULL,
  PRIMARY KEY(review_id),
  CONSTRAINT `fk_member_author_id` FOREIGN KEY (author_id) REFERENCES member (member_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE points(
 member_id SMALLINT UNSIGNED NOT NULL,
 amount TINYINT NOT NULL DEFAULT 0,
 date DATE NOT NULL,
 CONSTRAINT `fk_member_point_id` FOREIGN KEY (member_id) REFERENCES member (member_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE achievements(
 achievement_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
 description VARCHAR(45),
 reward TINYINT NOT NULL DEFAULT 0,
 type ENUM('SET', 'ADD', 'SAVE', 'REV', 'ANS', 'QUE'),
 amount TINYINT NOT NULL,
 PRIMARY KEY(achievement_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE unlocked_achievements(
 achievement_id SMALLINT UNSIGNED NOT NULL,
 member_id SMALLINT UNSIGNED NOT NULL,
 CONSTRAINT `fk_member_unAch_id` FOREIGN KEY (member_id) REFERENCES member (member_id) ON DELETE RESTRICT ON UPDATE CASCADE,
 CONSTRAINT `fk_ach_unAch_id` FOREIGN KEY (achievement_id) REFERENCES achievements (achievement_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE goals(
 goal_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
 owner_id SMALLINT UNSIGNED NOT NULL,
 name VARCHAR(45),
 state ENUM('ACTIVE', 'INACTIVE') NOT NULL,
 shared BOOLEAN NOT NULL DEFAULT FALSE,
 PRIMARY KEY(goal_id),
 CONSTRAINT `fk_member_goal_id` FOREIGN KEY (owner_id) REFERENCES member (member_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE expense(
  expense_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  description VARCHAR(255) NOT NULL,
  addition_date DATE,
  cost DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (expense_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE subscription(
  subscription_id SMALLINT UNSIGNED NOT NULL,
  -- next_billing_date  DATE DEFAULT DATE_ADD(CURDATE(), INTERVAL 1 MONTH), curdate() can't be default
  CONSTRAINT `fk_expense_sub_id` FOREIGN KEY (subscription_id) REFERENCES expense (expense_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE miscellaneous(
  misc_id SMALLINT UNSIGNED NOT NULL,
  misc_exp_name VARCHAR (45) NOT NULL,
  cost DECIMAL(10,2)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE bill(
  bill_id SMALLINT UNSIGNED NOT NULL,
  owed DECIMAL(10,2),
  -- dateFrom DATE DEFAULT CURDATE() curdate() can't be default
  -- dateTo DATE DEFAULT ADDDATE(CURDATE(), INTERVAL 1 MONTH), curdate() can't be default
  CONSTRAINT `fk_expense_bill_id` FOREIGN KEY (bill_id) REFERENCES expense (expense_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 

CREATE TABLE bill_water(
  bill_id SMALLINT UNSIGNED NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE bill_power(
  bill_id SMALLINT UNSIGNED NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE bill_telephone(
  bill_telephone_id SMALLINT UNSIGNED NOT NULL 
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;