package janken.hand.impl;

import java.util.Random;

import janken.hand.Hand;

public class ProbStrategy implements Strategy{

	private Random random;
	private int prevHandValue= 0;
	private int currentHandValue = 0;

	private int[][] history = {
			{1,1,1},
			{1,1,1},
			{1,1,1}
		};

	public ProbStrategy(int seed) {
		this.random = new Random(seed);
	}


	/* ============================================ */

	public Hand nextHand() {

		int bet = random.nextInt(getSum(currentHandValue));
		int handValue = (bet < history[currentHandValue][0])?
				0 :(bet < history[currentHandValue][0] + history[this.currentHandValue][1])?
				1 : 2;
		this.prevHandValue = currentHandValue;
		this.currentHandValue = handValue;
		return Hand.getHnad(handValue);
	}


	private int getSum(int hv) {
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += history[hv][i];
		}
		return sum;
	}


	@Override
	public void study(boolean result) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
