package com.example.demo.login.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService service;

		//結婚ステータスのラジオボタン用変数
	private Map<String,String > radioMarriage;

		/**
		 * ラジオボタンの初期化メソッド
		 *
		 * @param model
		 * @return
		 */
	private Map<String,String> initRadioMarriage(){

		Map<String,String> radio = new LinkedHashMap<>();
			//既婚,未婚をMapに格納
		radio.put("既婚","true");
		radio.put("未婚","false");

		return radio;
	}



	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("contents", "login/home :: home_contents");

		return "login/homeLayout";
	}

	@PostMapping("/logout")
	public String postLogout() {

		return "redirect:/login";

	}

	@GetMapping("/userList")
	public String getUserList(Model model) {

			//コンテンツ部分にユーザー一覧を表示する為の文字列を登録
		model.addAttribute("contents","login/userList :: userList_contents");

			//ユーザー一覧の生成
		List<User> userList = service.selectMany();

			//modelにユーザーリストを登録
		model.addAttribute("userList", userList);

			//データ件数を取得
		int count = this.service.count();
		model.addAttribute("userListCount", count);


		return "login/homeLayout";
	}


	@GetMapping("/userDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute SignupForm form,
			Model model,
			@PathVariable("id") String userId) {
			//ユーザーID確認(デバッグ)
		System.out.println("userId = " + userId);

			//コンテンツ部分にユーザー一覧を表示するための文字列を登録
		model.addAttribute("contents", "login/userDetail :: userDetail_contents");

			//結婚ステータスを初期化
		this.radioMarriage = initRadioMarriage();

			//ラジオボタン用のMapをModelに登録
		model.addAttribute("radioMarriage", this.radioMarriage);

			//ユーザーIDのチェック
		if(userId != null && userId.length() > 0) {
				//ユーザー情報を取得
			User user = service.selectOne(userId);

				//formクラスにセット
			form.setUserId(user.getUserId());
			form.setPassword(user.getPassword());
			form.setUserName(user.getUserName());
			form.setBirthday(user.getBirthday());
			form.setAge(user.getAge());
			form.setMarriage(user.isMarriage());

		}
		return "login/homeLayout";
	}

	/**
	 * ユーザー更新を行う
	 */
	@PostMapping(value="/userDetail",params="update")
	public String postUserDetailUpdate(@ModelAttribute SignupForm form,
			Model model) {
		System.out.println("更新ボタンの処理を行います");

		User user = new User();

		user.setUserId(form.getUserId());
		user.setUserName(form.getUserName());
		user.setPassword(form.getPassword());
		user.setBirthday(form.getBirthday());
		user.setAge(form.getAge());
		user.setMarriage(form.isMarriage());
		try {
			String result = (this.service.updateOne(user))? "更新成功" : "更新失敗";
				//結果メッセージをmodelにセット
			model.addAttribute("result", result);
		}catch(DataAccessException e) {
			model.addAttribute("result","更新失敗(トランザクションテスト)");
		}
			//return homeLayout.html
		return getUserList(model);
	}

	/**
	 * ユーザー削除を行う
	 * @param form
	 * @param model
	 * @return
	 */
	@PostMapping(value="/userDetail", params="delete")
	public String postUserDetailDelete(@ModelAttribute SignupForm form,
			Model model) {
		System.out.println("削除ボタンの処理を行います");

		String result = (this.service.deleteOne(form.getUserId()))? "削除成功" : "削除失敗";

		model.addAttribute("result", result);

		return getUserList(model);
	}


	/**
	 * CSVファイルを出力する
	 */
	@GetMapping("/userList/csv")
	public ResponseEntity<byte[]> getUserListCsv(Model model){
			//ユーザーを全権取得して、CSVをserverに保存する
		this.service.userCsvOut();

		byte[] bytes=null;
		try {
				//サーバーに保存されているsample.csvをbyteで取得
			bytes = this.service.getFile("sample.csv");
		}catch(IOException e) {
			e.printStackTrace();
		}

			//HTTPヘッダーの設定
		HttpHeaders header = new HttpHeaders();
		header.add("Count-Type", "text/csv; charset=UTF-8");
		header.setContentDispositionFormData("filename","sample.csv");

		return new ResponseEntity<>(bytes,header,HttpStatus.OK);
	}


	@GetMapping("/admin")
	public String getAdmin(Model model) {
		model.addAttribute("contents", "login/admin :: admin_contents");

		return "login/homeLayout";
	}

}
