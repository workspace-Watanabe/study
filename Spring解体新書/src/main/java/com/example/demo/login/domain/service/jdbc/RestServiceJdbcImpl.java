package com.example.demo.login.domain.service.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDAO;
import com.example.demo.login.domain.service.RestService;

@Transactional
@Service
public class RestServiceJdbcImpl implements RestService{

	@Autowired
	@Qualifier("UserDaoJdbcImpl")
	UserDAO dao;

	@Override
	public boolean insert(User user) {
		int result = dao.insertOne(user);

		return (result == 0)? false : true;
	}

	@Override
	public User selectOne(String userId) {

		return dao.selectOne(userId);
	}

	@Override
	public List<User> selectMany() {

		return dao.selectMany();
	}

	@Override
	public boolean update(User user) {

		int result = dao.updateOne(user);
		return (result == 0)? false : true;
	}

	@Override
	public boolean delete(String userId) {

		return (dao.deleteOne(userId) == 0)? false : true;
	}

}
