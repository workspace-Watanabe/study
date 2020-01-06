package janken.hand.impl;

import janken.hand.Hand;

/**
 * ジャンケンの戦略のための抽象メソッドを集めたインターフェース
 *
 * @author merut
 *
 */
public interface Strategy {

	/**
	 * 次の手を決める
	 */
	public  Hand nextHand();

	/**
	 * 直前の出した手の勝敗から、
	 * 次に出す手の戻り値をきめる判断の材料にする
	 */
	public	void study(boolean result);
}
