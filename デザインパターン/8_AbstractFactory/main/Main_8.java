package main;

import factory.Factory;
import factory.Link;
import factory.Page;
import factory.Tray;
public class Main_8 {

	public static void main(String[] args) {

		if(args.length != 1) {
			System.out.print("NO!!");
			System.exit(0);
		}

		Factory factory = Factory.getFactory(args[0]);

		Link asahi = factory.createLink("朝日新聞", "http://www.asahi.com");

		Tray tray = factory.createTray("新聞");
		tray.add(asahi);

		Page page = factory.createPage("LinkPage", "結月ゆかり");
		page.add(tray);
		page.output();
	}

}
