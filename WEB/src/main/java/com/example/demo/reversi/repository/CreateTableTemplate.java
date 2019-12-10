package com.example.demo.reversi.repository;

import java.util.List;

import com.example.demo.reversi.model.TABLE;

public abstract class CreateTableTemplate implements CreateTableInterFace{

		/**
		 * テーブルを初期化する
		 * 指定された盤面のテーブルを作りなおす
		 * @param numberOfBoards
		 */
		public void createTable(int numberOfBoards) {
			this.DropTable();
			this.CreateTable();
			this.Initialization(numberOfBoards);
		}

		/**
		 * テーブルの中身を取得
		 * @return
		 */
		public abstract List<TABLE> Select();
}
