package com.example.demo.reversi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.reversi.model.ReversiPiece;
import com.example.demo.reversi.model.TABLE;

import lombok.Data;
import lombok.Getter;

/**
 * 盤面を作成するクラス
 *
 * @author 結月ゆかり
 *
 */
@Repository
@Data
public class JdbcDAO extends CreateTableTemplate {

	//JDBC操作用のインスタンス
	@Autowired
	JdbcTemplate jdbc;

	@Getter
	private int numberOfBoards=0;

		/**
		 * 盤面の作成
		 * @param numberOfBoards 4*4 または 8*8
		 * @throws DataAccessException
		 */
	public void Initialization(int numberOfBoards) throws DataAccessException{
			//駒の状態
		String status;
			//列,行の数
		int num = 1;


			//列と行の数を決める
		while(numberOfBoards != Math.pow(num, 2)) {
				//違ったら数字を足す
			num++;
		}


			//列の数分作成
		for(int i = 1; i <= num; i++) {
				//行の数分作成する
			for(int j = 1; j <= num; j++) {
					//駒の状態を決める
				status = this.statusCheck(num, i, j);

					//SQL文を使いデータ挿入
				int rowNumber = this.insert(i, j, status);
					//駒の数を加える
				this.numberOfBoards += rowNumber;
			}
		}
	}


	@Override
	public int insert(int line, int column, String status)throws  DataAccessException {
		final String SQL = "INSERT INTO reversi("
				+ "column_,"
				+ "line,"
				+ "status) "
				+ "VALUES(?,?,?)";

		int rowNumber = jdbc.update(SQL,line,column,status);

		return rowNumber;
	}


		/**
		 * 初期配置時に
		 * 駒の状態を決める
		 *
		 * @param num 列、行の数
		 * @param i	現在の列番号
		 * @param j	現在の行番号
		 * @return		駒の状態
		 */
	public String statusCheck(int num, int i, int j) {
			//初期状態では配置なし
		String status = ReversiPiece.getPiece(2);

			//白の状態を設定
		if
			(i == (num/2) && j == (num/2)
				|| i == (num/2 + 1) && (j == (num/2 +1))) {

			status = ReversiPiece.getPiece(1);

		}else if
			(i == (num/2) && j == (num/2+1)
			|| i == (num/2 + 1) && j == (num/2)) {

			status = ReversiPiece.getPiece(0);
		}

		return status;
	}


		@Override
		public void CreateTable() throws DataAccessException {
			final String SQL = "CREATE TABLE IF NOT EXISTS reversi"
					+ "(id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
					"	column_ INT," +
					"	line INT," +
					"	status VARCHAR(50));";
			jdbc.execute(SQL);
		}


		/**
		 * reversiテーブルのドロップ
		 */
		@Override
		public void DropTable() throws DataAccessException {
			final String SQL =	"DROP TABLE IF EXISTS reversi";
			jdbc.execute(SQL);
		}


		@Override
		public List<TABLE> Select() {

			List<TABLE> tableList = new ArrayList<>();

			//テーブルの中身を取得
			final String SQL = "SELECT column_,line,status FROM reversi";
				//SQL文の実行
			List<Map<String,Object>> list = jdbc.queryForList(SQL);

			for(Map<String, Object> map : list) {
				TABLE table = new TABLE();
					//テーブルの状態をセット
				table.setColumn((Integer)map.get("column_"));
				table.setLine((Integer)map.get("line"));
				table.setStatus((String)map.get("status"));

					//テーブルリストに格納
				tableList.add(table);
			}

			return tableList;
		}



}
