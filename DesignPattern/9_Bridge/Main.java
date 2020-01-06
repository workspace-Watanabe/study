import designPattern.function.CountDisplay;
import designPattern.function.Display;
import designPattern.function.RandomDisplay;
import designPattern.imple.FileDisplayImpl;
import designPattern.imple.StringDisplayImpl;

public class Main {

	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("Hello World"));
		CountDisplay d2 = new CountDisplay(new StringDisplayImpl("Hello World!!"));
		RandomDisplay d3 = new RandomDisplay(new StringDisplayImpl("Hello World!!"));
		RandomDisplay d4 = new RandomDisplay(new FileDisplayImpl());
		d1.display();
		d2.multiDisplay(5);



	}
}
