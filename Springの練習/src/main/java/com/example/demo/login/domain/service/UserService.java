package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.dto.User;
import com.example.demo.login.domain.repository.UserDAO;

@Service
public class UserService {

	@Autowired
	@Qualifier("UserDAOjdbcImpl3")
	UserDAO dao;

	public boolean insert(User user) {

			//insert実行
		int num = dao.insertOne(user);

			//判定用変数
		boolean result = false;

		if(num > 0) {
				//insert成功
			result = true;
		}

		return result;
	}

	public int count() {
		return dao.count();
	}


		/**
		 * データを全権取得
		 * @return userデータ
		 */
	public List<User> selectMany(){
			//全件取得
		return dao.selectMany();
	}

	public User selectOne(String userId) {
		return dao.selectOne(userId);
	}

		/**
		 * データを一件更新
		 * 成功していたらtrue
		 * @param user
		 * @return
		 */
	public boolean updateOne(User user) {
		int num = dao.updateOne(user);

		boolean result = false;
		if(num > 0) {
			result = true;
		}

		return result;
	}


			/**
			 * データを一件削除
			 * @param userId
			 * @return	成功していたらTRUE
			 */
		public boolean deleteOne(String userId) {

				//一件削除
			int num = dao.deleteOne(userId);

			boolean result = false;

			if(num > 0) {
				result = true;
			}

			return result;
		}
}
