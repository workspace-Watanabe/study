package com.example.demo.login.domain.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.mybatis.UserMapper;
import com.example.demo.login.domain.service.RestService;

public class RestServiceMybatisImpl implements RestService{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public boolean insert(User user) {
		
		return false;
	}

	@Override
	public User selectOne(String userId) {
		
		return null;
	}

	@Override
	public List<User> selectMany() {
		
		return null;
	}

	@Override
	public boolean update(User user) {
		
		return false;
	}

	@Override
	public boolean delete(String userId) {
		
		return false;
	}
	
}
