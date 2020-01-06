package main;
import builder.HTMLBuilder;
import builder.TextBuilder;
import framework.Director;

public class Main_7 {
	public static void main(String[] args) {
		if(args.length != 1) {
			usage();
			System.exit(0);
		}
		
		switch(args[0]) {
		case "plain":
			TextBuilder textBuilder = new TextBuilder();
			Director director = new Director(textBuilder);
			director.construct();
			String result = textBuilder.getResult();
			System.out.print(result);
			break;
		
		case "html":
			HTMLBuilder html = new HTMLBuilder();
			Director htmlD = new Director(html);
			htmlD.construct();
			String filename = html.getResult();
			System.out.println(filename + "が作成されました！");
			break;
		default:
			usage();
			System.exit(0);
		}
	}

	private static void usage() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Usage: java Main plain");
		System.out.println("Usage: java Main html");
	}
}
