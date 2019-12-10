package com.example.demo.password.repository;

import org.springframework.dao.DataAccessException;

import com.example.demo.password.beans.User;

public interface UserDAO {

		/**
		 * テーブルからデータを一件取得
		 *
		 * @param userMail
		 * @return	データ
		 * @throws DataAccessException
		 */
	public User selectOne(String userMail) throws DataAccessException;
}
