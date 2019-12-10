package com.example.demo.login.domain.repository.jdbc.UserDAOjdbcImpl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.dto.User;

@Repository("UserDAOjdbcImpl3")
public class UserDAOjdbcImpl3 extends UserDAOjdbcImpl{

	@Override
	public User selectOne(String userId) {

		String sql = "SELECT * FROM m_user WHERE user_id=?";

		RowMapper<User> map = new	BeanPropertyRowMapper<User>(User.class);

		return jdbc.queryForObject(sql,map,userId);
	}
}
