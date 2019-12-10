package com.example.demo.login.domain.repository.jdbc.UserDAOjdbcImpl;

import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.dto.User;

@Repository("UserDAOjdbcImpl2")
public class UserDAOjdbcImpl2 extends UserDAOjdbcImpl{

	@Override
	public User selectOne(String userId) {

		String sql = "SELECT * FROM m_user WHERE user_id=?";

		UserRowMapper map = new UserRowMapper();

		return jdbc.queryForObject(sql,map,userId);
	}
}
