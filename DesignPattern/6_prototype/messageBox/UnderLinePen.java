package messageBox;

import framework.Product;

public class UnderLinePen implements Product{
	
	private char ulchar;
	
	public UnderLinePen(char ulchar) {
		this.ulchar = ulchar;
	}
	
	
		/**
		 * 文字列の下に装飾を施す
		 */
	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		
		System.out.println("\"" + s + "\"");
		
		System.out.print(" ");
		for(int i = 0; i < length; i++) {
			System.out.print(this.ulchar);
		}
		System.out.print("\n");
	}
	
	
	@Override
	public Product createClone() {
		Product p = null;
		
		try {
			p = (Product)clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
}
