package designPattern.function;

import designPattern.imple.DisplayImpl;

public class CountDisplay extends Display{

	public CountDisplay(DisplayImpl impl) {
		super(impl);

	}

	public void multiDisplay(int times) {
		this.open();

		for(int i=0; i < times; i++) {
			this.print();
		}

		close();
	}

}
