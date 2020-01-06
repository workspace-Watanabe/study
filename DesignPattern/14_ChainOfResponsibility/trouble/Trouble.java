package trouble;

/**
 *
 * 発生したトラブルを表すクラス
 *
 */
public class Trouble {
		//トラブル番号
	private int number;
		//トラブルの生成
	public Trouble(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

		//トラブルの文字列表現
	public String toString() {
		return "[Trouble]" + number + "]";
	}
}
