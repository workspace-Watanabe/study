package mement.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {

		//所持金
	private int money;
		//フルーツ
	private List<String> fruits = new ArrayList<>();
		//乱数発生器
	private Random random = new Random();
		//フルーツ名の表
	private static String[] fruitsName = {
			"リンゴ", "ぶどう", "バナナ", "みかん"
	};

	public Gamer(int money) {
		this.money = money;
	}

		/**
		 * 現在の所持金を得る
		 */
	public int getMoney() {
		return money;
	}

		/**
		 *	賭ける
		 */
	public void bet() {
		int dice = random.nextInt(6) + 1;
			//1の目...所持金を得る
		if(dice == 1) {
			money += 100;
			System.out.println("所持金が増えました。");
			//2の目...所持金が半分になる
		}else if(dice == 2) {
			money /= 2;
			System.out.println("所持金が半分になりました。");
			//6の目...フルーツをもらう
		}else if(dice == 6) {
			String fruit = getFruit();
			fruits.add(fruit);
		}else {
			System.out.println("何も起こりませんでした");
		}
	}

		/**
		 * 状態を保存する
		 */
	public Mement createMement() {
		Mement mement = new Mement(money);
		Iterator it = fruits.iterator();

		while(it.hasNext()) {
			String fruit = (String) it.next();
				//フルーツはおいしいものだけ保存
			if(fruit.startsWith("おいしい")) {
				mement.addFruits(fruit);
			}
		}
		return mement;
	}

		/**
		 * アンドゥを行う
		 */
	public void restoreMement(Mement mement) {
		this.money = mement.money;
		this.fruits = mement.getFruits();
	}

	public String toString() {
		return "[money = " + money + " , fruits = " + fruits + "]";
	}

		/**
		 * フルーツを得る
		 */
	private String getFruit() {
		String prefix = (random.nextBoolean())? "おいしい" : "";
		int randomIndex = random.nextInt(fruitsName.length);

		return prefix + fruitsName[randomIndex];
	}
}
