package q_2;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i < 9; i++) {
			Triple triple = Triple.getInstance(i%3);
			System.out.println(i + ":" + triple );
		}

	}

}
