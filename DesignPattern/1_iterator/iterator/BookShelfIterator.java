package iterator;

public class BookShelfIterator implements Iterator{
	
		//本棚を表す変数
	private BookShelf bookShelf;
		//現在位置
	private int index;
	
		
		/**
		 * BookShelfクラスのiteratorメソッドによって実行させる
		 * 
		 * @param bookShelf 本棚
		 */
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}
	
	
	public boolean hasNext() {
			//本棚のサイズより現在のindexが小さいならtrue
		if(index < bookShelf.getLength()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public Object next() {
		
			//本棚から現在の位置の本を取り出す
		Book book = bookShelf.getBook(index);
			//index番号を進める
		index++;
		return book;
	}
}
