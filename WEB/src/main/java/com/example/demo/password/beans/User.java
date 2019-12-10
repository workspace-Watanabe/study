package com.example.demo.password.beans;

import lombok.Data;

@Data
public class User {

		/**
		 * Id
		 */
	private int id;


		/**
		 * ユーザー名
		 */
	private String userName;


		/**
		 * ユーザーメールアドレス
		 */

	private String userMail;


		/**
		 * パスワード
		 */

	private String password;
}
