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

import com.example.demo.login.domain.dto.User;
import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.service.UserService;
@Controller
public class SignupController {


	@Autowired
	private UserService userService;

		//ラジオボタンの実装
	private Map<String , String> radioMarriage;


	/**
	 * ラジオボタンの初期化メソッド
	 * @return
	 */
	public Map<String , String> initRadioMarriage(){

		Map<String , String> radio = new LinkedHashMap<>();


		radio.put("既婚", "true");
		radio.put("未婚", "false");

		return radio;
	}



		/**
		 * ユーザー登録画面のGET用コントローラー
		 * @param model
		 * @return
		 */
	@GetMapping("/signup")
		//@ModelAttributeをつけると自動でmodelに登録される
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {

			//ラジオボタンの初期化メソッド呼び出し
		radioMarriage = this.initRadioMarriage();

		//ラジオボタン用のMapをModelに登録
		model.addAttribute("radioMarriage", radioMarriage);

			//signup.htmlに画面遷移
		return "login/signup";
	}


		/**
		 *	signupForm.htmlからのPOST用コントローラー
		 * @return
		 */
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm form,
			BindingResult bindingResult,//自動で入力Formの情報が正しいか判断してくれる
			Model model) {

			//入力チェックに引っかかった場合、ユーザー登録画面に戻る
		if(bindingResult.hasErrors()) {
			return getSignUp(form,model);
		}

			//formの中身をコンソールに出して確認します
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

		boolean result = userService.insert(user);

		if(result == true) {
			System.out.println("SUCCESS");
		}else {
			System.out.println("ERROR");
		}

			//login.htmlにリダイレクト
		return "redirect:/login";
	}
}
