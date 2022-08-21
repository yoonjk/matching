-- matching.tb_mydata definition

CREATE TABLE `tb_mydata` (
  `mydata_id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `assets` bigint DEFAULT NULL,
  `consume_ptn1` varchar(50) DEFAULT NULL,
  `consume_ptn2` varchar(50) DEFAULT NULL,
  `consume_ptn3` varchar(50) DEFAULT NULL,
  `invest_prop` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mydata_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- matching.tb_question definition

CREATE TABLE `tb_question` (
  `question_id` bigint NOT NULL AUTO_INCREMENT,
  `question_content` varchar(2000) DEFAULT NULL,
  `answer_content1` varchar(2000) DEFAULT NULL,
  `answer_content2` varchar(2000) DEFAULT NULL,
  `user_data_col_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;


-- matching.tb_user definition

CREATE TABLE `tb_user` (
  `user_id` varchar(50) NOT NULL,
  `mydata_id` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `mbti_mind` varchar(2) DEFAULT NULL,
  `mbti_recog` varchar(2) DEFAULT NULL,
  `mbti_judge` varchar(2) DEFAULT NULL,
  `mbti_tactics` varchar(2) DEFAULT NULL,
  `user_point` bigint DEFAULT NULL,
  `pet_prefer` varchar(2) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `agree_flag` varchar(2) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `profile_filename` varchar(255) DEFAULT NULL,
  `match_count` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `mydata_id` (`mydata_id`),
  CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`mydata_id`) REFERENCES `tb_mydata` (`mydata_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- matching.tb_match definition

CREATE TABLE `tb_match` (
  `match_id` bigint NOT NULL AUTO_INCREMENT,
  `sender` varchar(50) DEFAULT NULL,
  `receiver` varchar(50) DEFAULT NULL,
  `active_flag` varchar(2) DEFAULT NULL,
  `created_date` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`match_id`),
  KEY `sender` (`sender`),
  KEY `receiver` (`receiver`),
  CONSTRAINT `tb_match_ibfk_1` FOREIGN KEY (`sender`) REFERENCES `tb_user` (`user_id`),
  CONSTRAINT `tb_match_ibfk_2` FOREIGN KEY (`receiver`) REFERENCES `tb_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb3;


-- matching.tb_chat definition

CREATE TABLE `tb_chat` (
  `chat_id` bigint NOT NULL AUTO_INCREMENT,
  `match_id` bigint DEFAULT NULL,
  `user_id` varchar(50) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `read_flag` varchar(2) DEFAULT NULL,
  `created_date` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`chat_id`),
  KEY `match_id` (`match_id`),
  CONSTRAINT `tb_chat_ibfk_1` FOREIGN KEY (`match_id`) REFERENCES `tb_match` (`match_id`)
) ENGINE=InnoDB AUTO_INCREMENT=645 DEFAULT CHARSET=utf8mb3;
