package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

@Controller
public class SignupController {

		//ラジオボタン
	private Map<String,String>radioMarriage;

	@Autowired
	private UserService userService;

		/**
		 * ラジオボタンの初期化メソッド
		 * @return
		 */
	private Map<String,String> initRadioMarriage(){
		Map<String,String> radio = new LinkedHashMap<>();

			//既婚、未婚をMapに格納
		radio.put("既婚", "true");
		radio.put("未婚", "false");

		return radio;
	}

		/**
		 * ユーザー登録画面のGet用コントローラー
		 * @param model
		 * @return
		 */
	@GetMapping("/signup")
	public String getSignup(
			@ModelAttribute SignupForm form,
			Model model) {

			//ラジオボタンの初期化メソッドの呼び出し
		radioMarriage = this.initRadioMarriage();

			//Modelに登録
		model.addAttribute("radioMarriage", this.radioMarriage);

			//signpu.htmlに画面遷移
		return "login/signup";
	}


		/**
		 * ユーザー登録画面のPOST用コントローラー
		 * @param model
		 * @return
		 */
	@PostMapping("/signup")
	public String postSignuo(
			 @ModelAttribute @Validated SignupForm form,
			BindingResult result,
			Model model) {

			//入力チェックに引っかかった場合、ユーザー登録画面に戻る
		if(result.hasErrors()) {
			return getSignup(form,model);
		}


			//formの中身をコンソールにだして確認
		System.out.println(form);

			//insert用変数
		User user = new User();

		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setBirthday(form.getBirthday());
		user.setAge(form.getAge());
		user.setMarriage(form.isMarriage());
		user.setRole("ROLE_GENERAL");

			//insert文実行
		String message = (userService.insert(user))? "insert成功" : "insert失敗";

			//結果をコンソールに出力
		System.out.println(message);

			//login.htmlにリダイレクト
		return "redirect:/login";
	}



}
