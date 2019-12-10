package com.example.demo.login.domain.repository.jdbc.UserDAOjdbcImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.dto.User;
import com.example.demo.login.domain.repository.UserDAO;

@Repository("UserDAOjdbcImpl")
public class UserDAOjdbcImpl implements UserDAO{

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int count() throws DataAccessException {

		int count = jdbc.queryForObject("SELECT COUNT(*) FROM m_user",Integer.class);

		return count;
	}

	@Override
	public int insertOne(User user) throws DataAccessException {

		int rowNumber  = jdbc.update("INSERT INTO m_user("
				+ "user_id,"
				+ "password,"
				+ "user_name,"
				+ "birthday,"
				+ "age,"
				+ "marriage,"
				+ "role"
				+ ") "
				+ "VALUES(?,?,?,?,?,?,?)"
				,user.getUserId()
				,user.getPassword()
				,user.getUserName()
				,user.getBirthday()
				,user.getAge()
				,user.isMarriage()
				,user.getRole());

		return rowNumber;
	}

	@Override
	public User selectOne(String userId) throws DataAccessException {

			final String SQL = "SELECT * FROM m_user "
					+ "WHERE user_id=?";

			Map<String,Object> map  = jdbc.queryForMap(SQL,userId);

			User user = new User();

			if(map != null) {
				user.setUserId((String)map.get("user_id"));
				user.setPassword((String)map.get("password"));
				user.setUserName((String)map.get("user_name"));
				user.setBirthday((Date)map.get("birthday"));
				user.setAge((Integer)map.get("age"));
				user.setMarriage((Boolean)map.get("marriage"));
				user.setRole((String)map.get("role"));

			}

		return user;
	}

	@Override
	public List<User> selectMany() throws DataAccessException {

		List<Map<String,Object>> getList = jdbc.queryForList("SELECT * FROM m_user");

			//結果返却用の変数
		List<User> userList = new ArrayList<>();

			//取得したデータを結果返却用のListに格納していく
		for(Map<String,Object> map : getList) {
			User user = new User();

			user.setUserId((String)map.get("user_id"));
			user.setPassword((String)map.get("password"));
			user.setUserName((String)map.get("user_name"));
			user.setBirthday((Date)map.get("birthday"));
			user.setAge((Integer)map.get("age"));
			user.setMarriage((Boolean)map.get("marriage"));
			user.setRole((String)map.get("role"));

				//Listに追加
			userList.add(user);
		}

		return userList;
	}

	@Override
	public int updateOne(User user) throws DataAccessException {

		final String SQL = "UPDATE m_user "
			+ "SET "
				+ "password=?,"
				+ "user_name=?,"
				+ "birthday=?,"
				+ "age=?,"
				+ "marriage=? "
			+ "WHERE user_id=?";
		int rowNumber = jdbc.update(SQL
				,user.getPassword()
				,user.getUserName()
				,user.getBirthday()
				,user.getAge()
				,user.isMarriage()
				,user.getUserId());

		return rowNumber;
	}

	@Override
	public int deleteOne(String userId) throws DataAccessException {

		final String SQL = "DELETE FROM m_user "
				+ "WHERE user_id=?";

		int rowNumber = jdbc.update(SQL,userId);

		return rowNumber;
	}

	@Override
	public void userCsvOut() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ

	}
}
