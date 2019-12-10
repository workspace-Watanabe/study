package com.example.demo.reversi.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.reversi.model.TABLE;

/**
 * 盤面の確認や操作を行う
 * @author merut
 *
 */
public abstract class ReversiControllInterface {

	/**
	 * 盤面の確認
	 * @return 結果に一致したデータ
	 * @throws DataAccessException
	 */
	public abstract List<TABLE> select(String status) throws DataAccessException;


	public abstract List<TABLE> selectComplete(String status) throws DataAccessException;



	public List<TABLE> getNextTable(String table){
		return this.selectComplete(this.select(table));
	}
}
