package com.example.demo.reversi.model;

import java.util.List;

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


	public TABLE getTABLE(List<TABLE> list) {
		for(TABLE table : list) {
			for(TABLE tablej : list) {
				if(table.column-1 == tablej.column
						&& table.line-1 == tablej.line) {
					this.getTABLE(list,tablej, -1, -1);
				}
			}
		}
		return ;
	}


	public TABLE getTABLE(List<TABLE>list,TABLE table, int culumn,int line) {
		for(TABLE tablej : list) {
			if(table.column+culumn == tablej.column
					&& table.line+line == tablej.line) {
				this.getTABLE(list,tablej, culumn,line);
			}else
		}

		return ;
	}
}
