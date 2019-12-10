package com.example.demo.reversi.model;

import lombok.Data;

@Data
public class ReversiPiece {


	private static String[] piece = {"黒", "白", "配置なし"};

	public static String getPiece(int number) {
		return piece[number];
	}
}
