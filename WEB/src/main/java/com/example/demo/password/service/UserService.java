package com.example.demo.password.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.password.beans.User;
import com.example.demo.password.repository.UserDAO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;

	public User selectOne(String userMail) {
		return dao.selectOne(userMail);
	}
}
