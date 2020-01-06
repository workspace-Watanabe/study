package facade;

import facade.pagemaker.PageMaker;

public class Main {
	public static void main(String[] args) {
		PageMaker.makeWelcomePage("taiga@taiga.com", "welcome.html");
	}
}
