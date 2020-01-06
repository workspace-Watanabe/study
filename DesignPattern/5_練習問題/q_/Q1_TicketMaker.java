package q_;

public class Q1_TicketMaker {
	
	private static Q1_TicketMaker t = new Q1_TicketMaker();
	
	private Q1_TicketMaker() {
		
	}
	
	public static Q1_TicketMaker getInstance() {
		return t;
	}
	
	private int ticket = 100;
	
	public int getNextTicketNumber() {
		return ticket++;
	}
}
