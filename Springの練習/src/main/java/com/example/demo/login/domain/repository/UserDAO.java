package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.dto.User;

public interface UserDAO {

		/**
		 * Userテーブルの件数を取得1
		 *
		 * @return テーブルの件数
		 * @throws DataAccessException
		 */
	public int count() throws DataAccessException;


		/**
		 * Userテーブルにデータを一件登録
		 *
		 * @param user
		 * @return
		 * @throws DataAccessException
		 */
	public int insertOne(User user)throws DataAccessException;


		/**
		 * Userテーブルのデータを一件取得
		 *
		 * @param userId
		 * @return Userテーブルから取得したデータ
		 * @throws DataAccessException
		 */
	public User selectOne(String userId)throws DataAccessException;


		/**
		 * Userテーブルの全データを取得
		 * @return	Userテーブルから取得した全データ
		 * @throws DataAccessException
		 */
	public List<User>selectMany()throws DataAccessException;


		/**
		 * Userテーブルを一件更新
		 * @param user
		 * @return
		 * @throws DataAccessException
		 */
	public int updateOne(User user)throws DataAccessException;


		/**
		 * Userテーブルを一件削除
		 * @param userId
		 * @return
		 * @throws DataAccessException
		 */
	public int deleteOne(String userId)throws DataAccessException;


		/**
		 * SQL取得結果をserverにCSVで保存する
		 * @throws DataAccessException
		 */
	public void userCsvOut()throws DataAccessException;
}
