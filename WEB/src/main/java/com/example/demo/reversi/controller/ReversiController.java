package com.example.demo.reversi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.reversi.model.TABLE;
import com.example.demo.reversi.model.TableForm;
import com.example.demo.reversi.service.ReversiService;

@Controller
public class ReversiController {

@Autowired
private ReversiService service;

private Map<String,Integer> map;


	/***
	 * セレクトボックスを作成
	 * @return
	 */
	@ModelAttribute("boardOption")
	public Map<String,Integer> cxBoxList(){
		map = new HashMap<>();
		map.put("4×4",16);
		map.put("8×8",64);
		map.put("16×16",256);
		return map;
	}



	/**
	 * 列と行の数を計算
	 * その数をListに格納
	 *
	 * @param numberOfBoards 盤面の数
	 * @return List
	 */
	public List<Integer> numberList(int numberOfBoards){
		List<Integer> list = new ArrayList<>();
		int num = 1;
		while (numberOfBoards != Math.pow(num,2)) {
			num++;
		}

		for(int i=1; i <= num; i++) {
			list.add(i);
		}
		return list;
	}




		/**
		 * オセロゲームのページに移動
		 * index.HTML
		 * @return reversi.HTML
		 */
	@GetMapping("/reversi")
	public String getReversi(@ModelAttribute TableForm form,
			Model model) {

		model.addAttribute("contents","");
		return "Reversi/reversi";
	}

	@PostMapping("/HELLO")
	public String getCheck(
			@ModelAttribute TableForm form,
			@ModelAttribute("othello") TABLE othello,
			Model model
			) {

		service.createTable(form.getNum());
		List<TABLE> table = service.getTableSelect();


		List<Integer>list = this.numberList(form.getNum());

		model.addAttribute("table",table);
		model.addAttribute("number", list.get(list.size()-1));

		model.addAttribute("contents","Reversi/tableCreate :: start_contents");

		return "Reversi/reversi";

	}

	@PostMapping("next")
	public String postNext(
			@ModelAttribute("othello") TABLE othello,
			Model model) {




		return "index";
	}
}
