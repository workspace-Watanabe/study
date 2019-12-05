package com.example.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService user;


		/**
		 * ユーザー一覧画面のGET用メソッド
		 *
		 * @param model
		 * @return homeLayout.html
		 */
	@GetMapping("/home")
	public String getHome(Model model) {

			//コンテンツ部分にユーザー一覧を表示するための文字列を登録
		model.addAttribute("contents", "login/home :: home_contents");

		return "login/homeLayout";
	}


		/**
		 * ログアウト用のメソッド
		 * @return login.html
		 */
	@PostMapping("/logout")
	public String postLogout() {

			//ログイン画面にリダイレクト
		return "redirect:/login";
	}
}
