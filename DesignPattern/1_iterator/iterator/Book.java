package iterator;

	/*
	 * 本を表すクラス
	 */
public class Book {
	
		//本の名前
	private String bookName;
	
	public String getBookName() {
		return bookName;
	}
	
		/**
		 * 本の名前をセットするコンストラクタ
		 * @param bookName 本の名前
		 */
	public Book(String bookName) {
		this.bookName = bookName;
	}
}
