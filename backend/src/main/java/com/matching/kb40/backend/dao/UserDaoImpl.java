package com.matching.kb40.backend.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matching.kb40.backend.model.User;

import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao{
	String ns = "user.";

    @Autowired
	SqlSessionTemplate SqlSessionTemplate;

    public User userTest() throws SQLException {
		int sampleData = SqlSessionTemplate.selectOne(ns.concat("userTest"));
		User user = new User();
		user.setSampleData(sampleData);

		return user;
	}
}
