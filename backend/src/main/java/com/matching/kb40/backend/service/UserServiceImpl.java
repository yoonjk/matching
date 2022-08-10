package com.matching.kb40.backend.service;

import com.matching.kb40.backend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matching.kb40.backend.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
	private UserDao userDao;

    /**
	 * 유저 샘플
	 * @param 
	 * @result User
	 */
    public User userTest() throws Exception{
        User user = new User();
		return userDao.userTest();
	}
}
