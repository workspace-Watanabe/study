package com.example.demo.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.password.beans.User;
import com.example.demo.password.model.CheckForm;
import com.example.demo.password.service.UserService;

@Controller
public class PasswordController {

	@Autowired
	UserService userService;

	/**
	 * パスワード画面に遷移する
	 *
	 * @return home.HTML -> password.HTML
	 */
	@GetMapping("/password")
	public String getPassword(@ModelAttribute CheckForm form,
			Model model) {
		model.addAttribute("contents", "");
		return "password/password";
	}

	@GetMapping("/check")
	public String getCheck(@ModelAttribute CheckForm form,
			Model model) {

		model.addAttribute("contents", "");
		return "password/password";
	}

	@PostMapping("/check")
	public String postCheck(
			@ModelAttribute @Validated CheckForm form,
			BindingResult result,
			Model model) {

		if(result.hasErrors()) {
			model.addAttribute("contents", "password/userPass ::  error_contents");
			return "password/password";

		}
		model.addAttribute("contents", "password/userPass :: password_contents");

		User user = userService.selectOne(form.getUserMail());

		form.setUserMail(user.getUserMail());
		form.setPassword(user.getPassword());
		System.out.println(form.getUserMail());

		model.addAttribute("checkForm", form);
		return "password/password";
	}

}
