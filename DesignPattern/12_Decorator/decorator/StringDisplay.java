package decorator;

public class StringDisplay extends Display{

		//表示文字列
	private String string;

	public StringDisplay(String string) {
		this.string = string;
	}


		/**
		 * 表示する文字数を返す
		 */
	@Override
	public int getColumns() {
		return string.length()*2;
	}

	/**
	 * このクラスでは行数は1
	 */
	@Override
	public int getRows() {

		return 1;
	}




	@Override
	public String getRowText(int row) {
		return (row == 0)? string : null;
	}

}
