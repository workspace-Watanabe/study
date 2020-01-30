package flyweight;

import java.util.Scanner;

public class Main {
	public  static void  main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigString bs = new BigString(scan.next());
		bs.print();
	}

}
