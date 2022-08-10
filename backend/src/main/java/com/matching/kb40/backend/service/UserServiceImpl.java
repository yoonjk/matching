package com.matching.kb40.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matching.kb40.backend.model.User;
import com.matching.kb40.backend.dao.UserDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
	private UserDaoImpl userRepository;

    /**
	 * 유저 샘플
	 * @param 
	 * @result User
	 */
    public User userTest() {
        User user = new User();
		return userRepository.userTest();
	}
}
