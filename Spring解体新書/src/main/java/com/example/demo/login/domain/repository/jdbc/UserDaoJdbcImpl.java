package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDAO;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDAO{

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	PasswordEncoder passwordEncoder;


	/**
	 * テーブルの中身を全権取得してカウント
	 */
	@Override
	public int count() throws DataAccessException {
		final String SQL =  "SELECT COUNT(*) FROM m_user";
		int count = jdbc.queryForObject(SQL,Integer.class);
		return count;
	}

	/**
	 * データを一件挿入
	 */
	@Override
	public int insertOne(User user) throws DataAccessException {

		String password = passwordEncoder.encode(user.getPassword());

		int rowNumber = jdbc.update("INSERT INTO m_user("
				+ "user_id,"
				+ "password,"
				+ "user_name,"
				+ "birthday,"
				+ "age,"
				+ "marriage,"
				+ "role) "
				+ "VALUES(?,?,?,?,?,?,?)"
				,user.getUserId()
				,password
				,user.getUserName()
				,user.getBirthday()
				,user.getAge()
				,user.isMarriage()
				,user.getRole());

		return rowNumber;
	}


	/**
	 * m_userテーブルのデータを1件取得
	 */
	@Override
	public User selectOne(String userId) throws DataAccessException {
		final String SQL = "SELECT * FROM m_user "
				+ "WHERE "
				+ "user_id=?";

		Map<String,Object> map = jdbc.queryForMap(SQL,userId);

		User user = new User();

			//userインスタンスに結果をセット
		user.setUserId((String) map.get("user_id"));
		user.setPassword((String) map.get("password"));
		user.setUserName((String) map.get("user_name"));
		user.setBirthday((Date) map.get("birthday"));
		user.setAge((Integer) map.get("age"));
		user.setMarriage((Boolean) map.get("marriage"));
		user.setRole((String) map.get("role"));

		return user;
	}

	/**
	 * m_userテーブルの中身を全件取得
	 */
	@Override
	public List<User> selectMany() throws DataAccessException {
		List<Map<String,Object>> list = jdbc.queryForList("SELECT * FROM m_user");

		List<User> userList = new ArrayList<>();

		for(Map<String,Object> map : list){
			User user = new User();

			user.setUserId((String) map.get("user_id"));
			user.setPassword((String) map.get("password"));
			user.setUserName((String) map.get("user_name"));
			user.setBirthday((Date) map.get("birthday"));
			user.setAge((Integer) map.get("age"));
			user.setMarriage((Boolean) map.get("marriage"));
			user.setRole((String) map.get("role"));

			userList.add(user);
		}

		return userList;

	}

	/**
	 * m_userテーブルを1件更新
	 */
	@Override
	public int updateOne(User user) throws DataAccessException {

			//パスワード暗号化
		String password = passwordEncoder.encode(user.getPassword());


		final String SQL = "UPDATE m_user "
				+ "SET "
				+ "password=?,"
				+ "user_name=?,"
				+ "birthday=?,"
				+ "age=?,"
				+ "marriage=? "
				+ "WHERE user_id=?";

		int rowNumber = jdbc.update(
				SQL,
				password,
				user.getUserName(),
				user.getBirthday(),
				user.getAge(),
				user.isMarriage(),
				user.getUserId());

		if(rowNumber > 0) throw new DataAccessException("トランザクションテスト") {};
		return rowNumber;
	}

	/**
	 * m_userテーブルを1件削除
	 */
	@Override
	public int deleteOne(String userId) throws DataAccessException {
		final String SQL = "DELETE FROM m_user "
				+ "WHERE "
				+ "user_id=?";

		return jdbc.update(SQL,userId);
	}

	@Override
	public void userCsvOut() throws DataAccessException {
		String sql = "SELECT * FROM m_user";

			//ResultsetExtractorの生成
		UserRowCallBackHandler handler = new UserRowCallBackHandler();
			//CSV出力
		jdbc.query(sql, handler);
	}



}
