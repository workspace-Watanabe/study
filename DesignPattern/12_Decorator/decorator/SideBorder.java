package decorator;

public class SideBorder extends Border{

	private char c;

	public SideBorder(Display display, char c) {
		super(display);
		this.c = c;
	}

	@Override
	public int getColumns() {

		return ( this.display.getColumns() );
	}

	@Override
	public int getRows() {

		return this.display.getRows();
	}

	@Override
	public String getRowText(int row) {

		return c + display.getRowText(row) + c;
	}


}
