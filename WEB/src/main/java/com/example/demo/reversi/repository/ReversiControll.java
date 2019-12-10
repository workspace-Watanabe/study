package com.example.demo.reversi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.reversi.model.TABLE;

import lombok.Data;

@Data
public class ReversiControll extends ReversiControllInterface {

	@Autowired
	JdbcTemplate jdbc;

	private List<TABLE> list;

	/**
	 * 盤面の状態を指定してデータを探す
	 */
	@Override
	public List<TABLE> select(String status) throws DataAccessException {
		final String SQL = "SELECT column_, line, status FROM reversi "
				+ "WHERE "
				+ "status=?";

		List<TABLE> DTOlist =  new ArrayList<>();

		List<Map<String,Object>> tableList = jdbc.queryForList(SQL,status);

		for(Map<String,Object> map : tableList) {
			TABLE table = new TABLE();
			table.setColumn((Integer)map.get("column_"));
			table.setLine((Integer)map.get("line"));
			table.setStatus((String)map.get("status"));

			DTOlist.add(table);
		}

		return DTOlist;
	}

	@Override
	public List<TABLE> selectComplete(String status) throws DataAccessException {
		JdbcDAO jdbcDAO = new JdbcDAO();

			//盤面をすべて取得
		List<TABLE> allList = jdbcDAO.Select();

			//白か黒の盤面を取得
		List<TABLE> statusList = this.select(status);

		for(TABLE table : statusList) {
			table.
		}


		return null;
	}

}
