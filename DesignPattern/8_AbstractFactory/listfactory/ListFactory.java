package listfactory;

import factory.Factory;
import factory.Link;
import factory.Page;
import factory.Tray;

public class ListFactory extends Factory{

	@Override
	public Link createLink(String caption, String url) {

		return new ListLink(caption,url);
	}

	@Override
	public Tray createTray(String caption) {
		// TODO 自動生成されたメソッド・スタブ
		return new ListTray(caption);
	}

	@Override
	public Page createPage(String title, String author) {
		// TODO 自動生成されたメソッド・スタブ
		return new ListPage(title,author);
	}

}
