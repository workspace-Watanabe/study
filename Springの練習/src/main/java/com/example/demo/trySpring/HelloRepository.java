package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 * RepositoryをつけることでDIに登録されるようになる
 */
@Repository
public class HelloRepository {

	//自動でインスタンスを取得する？
	@Autowired
	private JdbcTemplate jdbc;

	public Map<String , Object> findOne(int id){

		final String query = "SELECT "
				+ "employee_id,"
				+ "employee_name,"
				+ "age,"
				+ "FROM employee "
				+ "WHERE employee_id=?";

			//検索実行
		Map<String , Object> employee = jdbc.queryForMap(query,id);
		return employee;
	}
}
