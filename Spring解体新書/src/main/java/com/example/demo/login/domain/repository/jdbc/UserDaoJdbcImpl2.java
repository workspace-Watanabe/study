package com.example.demo.login.domain.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;

@Repository("UserDaoJdbcImpl2")
public class UserDaoJdbcImpl2 extends UserDaoJdbcImpl{

	@Autowired
	private JdbcTemplate jdbc;

	/**
	 * ユーザーを1件取得
	 *
	 */
	@Override
	public User selectOne(String userId) {
		final String SQL = "SELECT * FROM m_user WHERE user_id=?";

			//rowMapperの生成
		UserRowMapper row = new UserRowMapper();

			//SQLの実効
		return jdbc.queryForObject(SQL, row,userId);
	}
}
