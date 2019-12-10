package com.example.demo.reversi.model;

import lombok.Data;

@Data
public class TABLE {

	/**
	 * オセロの盤面の列
	 */
	private int column;


	/**
	 * オセロの盤面の行
	 */
	private int line;


	/**
	 * オセロの盤面の状態
	 */
	private String status;
}
