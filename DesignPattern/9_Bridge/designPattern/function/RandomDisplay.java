package designPattern.function;

import designPattern.imple.DisplayImpl;

public class RandomDisplay extends Display {

	public RandomDisplay(DisplayImpl impl) {
		super(impl);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public final void randomDisplay(int times) {
		int random = (int) (Math.random()*times);

		this.open();

		for(int i = 0; i < random; i++) {
			this.print();
		}

		this.close();
	}
}
