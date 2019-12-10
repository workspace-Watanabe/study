package com.example.demo.password.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.password.beans.User;

@Repository
public class Jdbc implements UserDAO{

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public User selectOne(String userMail) throws DataAccessException {

		final String SQL = "SELECT * FROM user_password WHERE user_mail=?";

		Map<String,Object> map = jdbc.queryForMap(SQL,userMail);

		User user = new User();

		user.setId((Integer)map.get("id"));
		user.setUserName((String)map.get("user_name"));
		user.setPassword((String)map.get("password"));
		user.setUserMail((String)map.get("user_mail"));
		return user;
	}
}
