package observer;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator{

		//現在の数
	private int number;
		//乱数発生器
	private Random random = new Random();

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void execute() {
		for(int i=0; i< 20; i++) {
			number = random.nextInt(50);
				//乱数を発生させそのつど観測者に伝える
			this.notifyObservers();
		}
	}

}
