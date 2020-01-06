package main;

import iterator.Book;
import iterator.BookShelf;
import iterator.Iterator;

public class Main {

	public static void main(String[] args) {
			
		BookShelf bookShelf = new BookShelf(4);
		
		bookShelf.appendBook(new Book("白雪姫"));
		bookShelf.appendBook(new Book("あしながおじさん"));
		bookShelf.appendBook(new Book("シンデレラ"));
		bookShelf.appendBook(new Book("ハリーポッター"));
		
		Iterator it = bookShelf.iterator();
		
		while(it.hasNext()) {
			Book book = (Book) it.next();
			System.out.println(book.getBookName());
		}
	}

}
