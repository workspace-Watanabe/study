package designPattern.imple;

public class StringDisplayImpl implements DisplayImpl{


	private String string;

	private int width;

	public StringDisplayImpl(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}


	@Override
	public void rawOpen() {
			this.printLine();
	}

	@Override
	public void rawPrint() {
		System.out.println("|" + string + "|");

	}

	@Override
	public void rawClose() {
		this.printLine();
	}

	private void printLine() {
		System.out.print("+");

		for(int i=0; i < this.width; i++) {
			System.out.print("-");
		}

		System.out.println("+");
	}
}
