package janken.hand;

/**
 * ジャンケンのときの手を表すクラス
 * @author Yukari
 *
 */
public class Hand {

		//グー
	public static final int HANDVALUE_ROCK = 0;
		//チョキ
	public static final int HANDVALUE_SCISSORS = 1;
		//パー
	public static final int HANDVALUE_PARER = 2;


	/*
	 * ジャンケンの手の値
	 */
	private int handValue;

	/*
	 * コンストラクタで値の挿入
	 * private にすることでほかのクラスからの直接的なインスタンス生成の禁止
	 * @param handValue
	 */
	private Hand(int handValue) {
		this.handValue = handValue;
	}


		/*
		 *
		 * 	ジャンケンの手を表す3つのインスタンス
		 *
		 */
	public static final Hand[] hand = {
			new Hand(HANDVALUE_ROCK),
			new Hand(HANDVALUE_SCISSORS),
			new Hand(HANDVALUE_PARER),
	};

		/*
		 * ジャンケンの手の文字表現
		 */
	private static final String[] name = {
			"グー", "チョキ", "パー"
	};



	/* ================================================================== */


	/**
	 * インスタンスを取得
	 * @param index
	 * @return	Handのインスタンス
	 */
	public static Hand getHnad(int index) {
		return hand[index];
	}

	/**
	 * ジャンケンを行う処理
	 *
	 * あいこ -> 0
	 * かち   -> 1
	 * 負け   -> -1
	 * @param h
	 * @return
	 */
	private int fight(Hand h) {
		int result = (this == h)? 0 : (this.handValue % 3 == h.handValue)? 1 : -1 ;

		return result;
	}


	/**
	 *	勝ちならtrue
	 */
	public boolean isStrongThan(Hand h) {
		return this.fight(h) == 1;
	}

	/**
	 * 負けならtrue
	 */
	public boolean isWeakerThan(Hand h) {
		return this.fight(h) == -1;
	}

	/* ============================================ */

	@Override
	public String toString() {
		return name[this.handValue];
	}
}
