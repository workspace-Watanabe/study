package com.example.demo.reversi.repository;

import org.springframework.dao.DataAccessException;

/**
	 * オセロの盤面を操作するためのSQL文を送る
	 *
	 * @author 結月ゆかり
	 *
	 */
public interface CreateTableInterFace {

		/**
		 * テーブルにデータを挿入
		 *
		 *	行と列と盤面の状態を指定する
		 *
		 * @return データを挿入した数
		 */
	public int insert (
			int line,
			int column,
			String status
			)throws DataAccessException;

	/**
	 * テーブルを作成する
	 * @throws DataAccessException
	 */
	public void CreateTable()throws DataAccessException;

	/**
	 * テーブルをドロップする
	 * @throws DataAccessException
	 */
	public void DropTable() throws DataAccessException;

	/**
	 * テーブルを新たに作成する
	 * @param numberOfBoards 盤面の数
	 * @throws DataAccessException
	 */
	public void Initialization(int numberOfBoards) throws DataAccessException;
	
	
}
