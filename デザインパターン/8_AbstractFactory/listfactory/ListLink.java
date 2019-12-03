package listfactory;

import factory.Link;

public class ListLink extends Link{

	public ListLink(String caption, String url) {
		super(caption, url);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public String makeHTML() {
		// TODO 自動生成されたメソッド・スタブ

		return "<list><a href=\"" + url + "\">" + caption + "</a></li>\n";
	}

}
