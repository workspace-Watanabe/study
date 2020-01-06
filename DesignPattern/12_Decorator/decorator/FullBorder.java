package decorator;

public class FullBorder extends Border{

	public FullBorder(Display display) {
		super(display);
	}



	/**
	 * 文字数は中身の両側に飾り文字分を加えたもの
	 */
	@Override
	public int getColumns() {

		return  this.display.getColumns() ;
	}

	/**
	 * 行数は中身の行数に上下の飾り文字分を加えたもの
	 */
	@Override
	public int getRows() {

		return 1 + this.display.getRows() + 1;
	}

	@Override
	public String getRowText(int row) {

		return (row == 0)?
				"+-" + this.makeLine('-', display.getColumns()) + "-+"


				:(row == (this.display.getRows() + 1))?

						"+" + this.makeLine('-', display.getColumns()) + "+"
						: "|" + this.display.getRowText(row -1) + "|";
	}


	/**
	 * 文字cをcount子連続させた文字列を作る
	 * @param c
	 * @param count
	 * @return
	 */
	private String makeLine(char c, int count) {
		StringBuffer buf = new StringBuffer();

		for(int i = 0; i < count; i++) {
			buf.append(c);
		}
		return buf.toString();
	}
}
