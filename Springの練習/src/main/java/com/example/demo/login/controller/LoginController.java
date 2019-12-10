package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

	@PostMapping("/login")
	public String postLogin(Model model) {

			//Home画面に遷移
		return "redirect:/home";
	}

}
