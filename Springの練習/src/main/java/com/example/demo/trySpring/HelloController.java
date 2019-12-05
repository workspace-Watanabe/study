package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}

	@PostMapping("/hello")
	public String getPost(@RequestParam("text1")String str , Model model) {

		model.addAttribute("sample" , str);

		return "helloResponse";
	}

		//従業員テーブルからIDを使ったSELECT文の結果
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2")String str, Model model) {

			//String型からint型に変換
		int id = Integer.parseInt(str);

			//１件検索
		Employee employee = helloService.findOne(id);

			//検索結果をModelに登録
		model.addAttribute("employee_id", employee.getEmployeeId());
		model.addAttribute("employee_name", employee.getEmployeeName());
		model.addAttribute("age", employee.getAge());

		return "helloResponseDB";
	}
}
