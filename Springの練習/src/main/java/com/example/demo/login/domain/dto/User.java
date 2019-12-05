package com.example.demo.login.domain.dto;

import java.util.Date;

import lombok.Data;

	/**
	 *	Home.htmlに移動する際にログインをするためのステータスを補完
	 *	beands
	 * @author merut
	 *
	 */
@Data
public class User {

		/**
		 * ユーザーID
		 */
	private String userId;


		/**
		 * パスワード
		 */
	private String password;


		/**
		 * ユーザー名
		 */
	private String userName;


		/**
		 * 誕生日
		 */
	private Date birthday;


		/**
		 * 年齢
		 */
	private int age;


		/**
		 * 結婚ステータス
		 */
	private boolean marriage;
}
