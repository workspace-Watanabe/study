package decorator.main;

import decorator.Display;
import decorator.FullBorder;
import decorator.SideBorder;
import decorator.StringDisplay;

public class Main {
	public static void main(String[] args){

		Display d1 = new StringDisplay("Helloworld");
		d1.show();

		Display d2 = new SideBorder(d1,'#');
		d2.show();

		Display d3 = new FullBorder(d2);
		d3.show();

		Display d4 =
						new SideBorder(
								new FullBorder(
										new FullBorder(
												new StringDisplay("こんにちは"))),'*');
		d4.show();
	}
}
