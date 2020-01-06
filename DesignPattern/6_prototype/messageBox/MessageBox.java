package messageBox;

import framework.Product;

public class MessageBox implements Product{
	
	private char decochar;
	
	public MessageBox(char decochar) {
		this.decochar  = decochar;
	}
	
		/**
		 * 与えられた文字列を囲うように装飾を施す
		 */
	@Override
	public void use(String s) {
			//与えられた引数の文字数
		int length = s.getBytes().length;
			
			//引数の文字列の上にdecocharを配置
		for(int i=0; i < length+4; i++) {
			System.out.print(this.decochar);
		}
		System.out.print("\n");
		
			//引数を出力, 左右にdecocharを配置
		System.out.println(this.decochar + " " + s + " " + decochar);
		
		//引数の文字列の下にdecocharを配置
				for(int i=0; i < length+4; i++) {
					System.out.print(this.decochar);
				}
				System.out.print("\n");
	}
	
	@Override
	public Product createClone() {
		Product p = null;
		
		try {
				//クローンを生成
			p = (Product)clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
			//コピーを返す
		return p;
	}
}
