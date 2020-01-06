package mement.game;

import java.util.ArrayList;
import java.util.List;

public class Mement {

		//所持金
	int money;
		//フルーツ
	ArrayList<String> fruits;

	Mement(int money){
		this.money = money;
		this.fruits = new ArrayList<>();
	}

		/**
		 * 所持金を得る
		 */
	public int getMoney() {
		return money;
	}
		/**
		 * フルーツを追加する
		 */
	void addFruits(String fruit) {
		fruits.add(fruit);
	}
		/**
		 * フルーツを得る
		 */
	List<String> getFruits(){
		return (List<String>) fruits.clone();
	}



}
