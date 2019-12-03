package listfactory;

import java.util.Iterator;

import factory.Item;
import factory.Page;

public class ListPage extends Page{

	public ListPage(String title, String author) {
		super(title, author);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public String makeHTML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html><header><title>" + this.title + "</title></header>\n");
		sb.append("<body>\n");
		sb.append("<h1>" + this.title + "</h1>");
		sb.append("<ul>\n");
		Iterator it = this.content.iterator();

		while(it.hasNext()) {
			Item item = (Item)it.next();
			sb.append(item.makeHTML());
		}
		sb.append("</ul>\n");
		sb.append("<hr><address>" + this.author + "</address>");
		sb.append("</body></html>");
		return sb.toString();
	}

}
