package iterator;
	/*
	 * 本棚を表現しているクラス
	 * 集合体を意味するためAggregateインターフェースを実装している
	 * 
	 */
public class BookShelf implements Aggregate{
	
	private Book[] books;
		/**
		 * 指定した位置の本を戻り値として返す
		 * @param index	指定する位置
		 * @return 本の名前
		 */
	public Book getBook(int index) {
		return books[index];
	}
		
		//現在位置
	private int last = 0;
		
		/**
		 * 指定したサイズの本棚を作成
		 * 
		 * @param maxsize 本棚のサイズ
		 */
	public BookShelf(int maxsize) {
		books = new Book[maxsize];
	}
		
		/**
		 * 現在位置に本を追加
		 * その後、位置を１つ進める
		 * 
		 * @param book 本
		 * 
		 */
	public void appendBook(Book book) {
		this.books[last] = book;
		last++;
	}
			/**
			 * 本棚のサイズを返す
			 * 
			 * @return	本棚のサイズ
			 */
		public int getLength() {
			return last;
		}
	
	
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
}
