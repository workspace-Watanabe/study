package com.example.demo.reversi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.reversi.model.TABLE;
import com.example.demo.reversi.repository.JdbcDAO;

@Service
public class ReversiService {

	@Autowired
	JdbcDAO dao;


		/**
		 * ユーザーが選択した盤面に対応した テーブルを作成します
		 *
		 * @param numberOfBoards 4×4 または 8×8
		 */
	public void createTable(int numberOfBoards) {
		dao.createTable(numberOfBoards);
	}

	/**
	 * 作成したテーブルから情報を取得します
	 *
	 * @return 取得したテーブルの情報
	 */
	public List<TABLE> getTableSelect(){
		return dao.Select();
	}
}
