package com.example.demo.login.domain.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//自動でセッターやゲッターをつける
@Data
public class SignupForm {

		/**
		 * ユーザーID
		 */
	@NotBlank
	@Email
	private String userId;

		/**
		 * パスワード
		 */
	@NotBlank
	@Length(min=4, max = 100)
	private String password;


		/**
		 * ユーザー名
		 */
	@NotBlank
	private String userName;


		/**
		 * @DateTimeFormatは画面から渡されてきた文字列を
		 * 日付型に変えてくれる
		 */
	@NotNull
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date birthday;

		/**
		 * 年齢
		 */
	@Min(20)
	@Max(100)
	private int age;


		/**
		 * 結婚ステータス
		 */
	private boolean marriage;
}
