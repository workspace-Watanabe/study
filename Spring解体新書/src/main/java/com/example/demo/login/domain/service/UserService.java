package com.example.demo.login.domain.service;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDAO;

@Transactional
@Service
public class UserService {

	@Autowired
	@Qualifier("UserDaoJdbcImpl")
	UserDAO dao;

	/**
	 * m_userテーブルにユーザーの新規登録を行う
	 *
	 * @param user ユーザー情報
	 * @return 新規登録を行えたかどうか
	 */
	public boolean insert(User user) {

		int rownumber = dao.insertOne(user);

		return (rownumber > 0)? true : false;
	}


	/**
	 * カウント用メソッド
	 * @return
	 */
	public int count() {
		return dao.count();
	}

	/**
	 * 全件取得用メソッド
	 *
	 * @return 全User情報
	 */
	public List<User> selectMany(){
		return dao.selectMany();
	}



	/**
	 * m_userテーブルのデータを1件取得
	 */
	public User selectOne(String userId) {
		return dao.selectOne(userId);
	}


	/**
	 * m_userテーブルのデータを1件更新
	 * @param user
	 * @return
	 */
	public boolean updateOne(User user) {
		int rowNumber = dao.updateOne(user);

		return (rowNumber > 0)? true : false;
	}

	/**
	 * m_userテーブルのデータを1件削除
	 *
	 * @param userId
	 * @return
	 */
	public boolean deleteOne(String userId) {

		int result = dao.deleteOne(userId);


		return (result > 0)? true : false;
	}

	/**
	 * ユーザー一覧をCSV出力する
	 */
	public void userCsvOut() throws DataAccessException{
		dao.userCsvOut();
	}

	/**
	 * サーバに保存されているファイルを取得して、Byte配列に変換する
	 *
	 */
	public byte[] getFile(String fileName) throws IOException{
			//ファイルシステム(デフォルト)の取得
		FileSystem fs = FileSystems.getDefault();
			//ファイルの取得
		Path p = fs.getPath(fileName);
			//ファイルをbyte配列に変換
		byte[] bytes = Files.readAllBytes(p);

		return bytes;
	}
}
