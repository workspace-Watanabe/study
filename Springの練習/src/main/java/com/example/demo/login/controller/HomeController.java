package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.dto.User;
import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.service.UserService;

@Controller
public class HomeController {

@Autowired
UserService userService;

	//結婚ステータスのラジオボタン用変数
private Map<String,Object> radioMarriage;


	/**
	 * ラジオボタンの初期化用メソッド
	 *
	 * @return 初期化したラジオマップ
	 */
private Map<String,Object> initRadioMarriage(){
	Map<String,Object> radio = new LinkedHashMap<>();

	radio.put("既婚",true);
	radio.put("未婚",false);

	return radio;
}

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
		 * ユーザーリストの取得
		 * ユーザーリストの件数の取得
		 * @param model
		 * @return homeLayout.HTML -> homeLayout.HTML
		 */
	@GetMapping("/userList")
	public String getUserList(Model model) {

		model.addAttribute("contents", "login/userList :: userList_contents");
			//ユーザー一覧の生成
		List<User>userList = userService.selectMany();
		model.addAttribute("userList",userList);


			//データ件数を取得
		int count = userService.count();
		model.addAttribute("userListCount",count);

		return "login/homeLayout";
	}



	@GetMapping("/userList/csv")
	public String getUserListCsv(Model model) {
			/*
			 *  ************
			 */
		return this.getUserList(model);
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



	@GetMapping("/userDetail//{id:.+}")
	public String getUserDetail(@ModelAttribute SignupForm form,
			Model model,
			@PathVariable("id") String userId) {

		//ゆーざーID確認
		System.out.println("user_id = " + userId);


		//コンテンツ部分にユーザー詳細を表示するための文字列を登録
	model.addAttribute("contents", "login/userDetail :: userDetail_contents");

			//結婚ステータス用ラジオボタンの初期化
		this.radioMarriage = this.initRadioMarriage();

			//ラジオボタンのMapをModelに登録
		model.addAttribute("radioMarriage",this.radioMarriage);

			//ユーザーIDのチェック
		if(userId != null && userId.length() > 0) {

				//ユーザー情報を取得
			User user = this.userService.selectOne(userId);

				//UserクラスをFormクラスに変換
			form.setUserId(user.getUserId());
			form.setUserName(user.getUserName());
			form.setBirthday(user.getBirthday());
			form.setAge(user.getAge());
			form.setMarriage(user.isMarriage());


		}
		return "login/homeLayout";
	}

	@PostMapping(value ="/userDetail", params = "update")
	public String postUserDetail(@ModelAttribute SignupForm form,
			Model model) {

		System.out.println("更新ボタンの処理");

			//Userインスタンスの生成
		User user = new User();

			//FormクラスをUserクラスに変換
		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setBirthday(form.getBirthday());
		user.setAge(form.getAge());
		user.setMarriage(form.isMarriage());

			//更新処理
		boolean result = userService.updateOne(user);

		if(result) {
			model.addAttribute("result", "更新成功");
		}else {
			model.addAttribute("result","更新失敗");
		}

		return this.getUserList(model);
	}

	@PostMapping(value = "userDetail",params="delete")
	public String postUserDetailDelete(
			@ModelAttribute SignupForm form,
			Model model) {

			System.out.println("削除ボタンの処理");

				//削除処理
			boolean result = this.userService.deleteOne(form.getUserId());

			if(result) {
				model.addAttribute("result", "削除成功");
			}else {
				model.addAttribute("result","削除失敗");
			}
			return this.getUserList(model);
	}

}
