package listfactory;

import java.util.Iterator;

import factory.Item;
import factory.Tray;

public class ListTray extends Tray{

	public ListTray(String caption) {
		super(caption);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public String makeHTML() {

		StringBuffer sb = new StringBuffer();
		sb.append("<li>\n");
		sb.append(this.caption + "\n");
		sb.append("<ul>\n");

		Iterator it = tray.iterator();

		while(it.hasNext()) {
			Item item = (Item)it.next();
			sb.append(item.makeHTML());
		}

		sb.append("</ul>\n");
		sb.append("<li>\n");
		return sb.toString();
	}

}
