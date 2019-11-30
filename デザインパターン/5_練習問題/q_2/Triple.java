package q_2;

public class Triple {
	
	private static Triple[] triple = {
			new Triple(0),
			new Triple(1),
			new Triple(2),
	};
	
	private int id;
	
	private Triple(int index) {
		System.out.println("The instance" + index+ "is created");
		this.id = index;
	}
	
	public static Triple getInstance(int id) {
		return triple[id];
	}
	
	public String toString() {
		return "[Triple id = " + id + "]";
	}
}
