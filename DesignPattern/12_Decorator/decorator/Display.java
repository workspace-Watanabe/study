package decorator;

public abstract class Display {

	/**
	 * 横の文字数を得る
	 * @return 文字数
	 */
	public abstract int getColumns();


	/**
	 * 縦の行数を得る
	 * @return 行数
	 */
	public abstract int getRows();


	/**
	 * row 番目の文字列を得る
	 * @param row
	 * @return
	 */
	public abstract String getRowText(int row);


	/**
	 * 文字列の表示を行う
	 */
	public final void show() {
		for(int i = 0; i < this.getRows(); i++) {
			System.out.println(this.getRowText(i));
		}
	}
}
