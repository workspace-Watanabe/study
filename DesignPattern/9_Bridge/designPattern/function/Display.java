package designPattern.function;

import designPattern.imple.DisplayImpl;

public class Display {

	private DisplayImpl impl;

	public Display(DisplayImpl impl) {
		this.impl = impl;
	}

	public void open() {
		impl.rawOpen();
	}

	public void print() {
		this.impl.rawPrint();
	}

	public void close() {
		this.impl.rawClose();
	}


	/**
	 * TemplateMethodPattern
	 */
	public final void display() {
		this.open();
		this.print();
		this.close();
	}


}
