package janken.hand.impl;

import java.util.Random;

import janken.hand.Hand;

public class WinningStrategy implements Strategy{

	private Random random;

	private boolean won = false;

	private Hand hand;

	public WinningStrategy(int seed) {
		random = new Random(seed);
	}

	/* ============================== */


	@Override
	public Hand nextHand() {
		if(!won) hand = hand.getHnad(random.nextInt(3));

		return hand;
	}

	@Override
	public void study(boolean result) {
		this.won = result;

	}

}
