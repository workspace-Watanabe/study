package observer;

public class Main {
	public static void main(String[] a) {
		NumberGenerator generator = new InCrementNumberGenerator(10,50,5);
		Observer observer1 = new DiditObserver();
		Observer observer2 = new GraphObserver();
		generator.addObserver(observer1);
		generator.addObserver(observer2);
		generator.execute();
	}
}
