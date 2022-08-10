package com.matching.kb40.backend.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matching.kb40.backend.model.User;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
	SqlSessionTemplate SqlSessionTemplate;

    public User userTest() {
		int sampleData = SqlSessionTemplate.selectOne("user.userTest");
		User user = new User();
		user.setSampleData(sampleData);
		
//		logger.debug("User >>>>>>>" + user.toString());

		return user;
	}
}
