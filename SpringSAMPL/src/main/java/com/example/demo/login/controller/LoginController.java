package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

		/**
		 * login.htmlに画面遷移
		 * @param model
		 * @return
		 */
	@GetMapping("/login")
	public String getLogin(Model model) {

			//login.htmlに画面遷移
		return "login/login";
	}
}
