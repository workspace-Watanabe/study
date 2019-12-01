package framework;
	
	/*
	 * 複製を可能にするクラス
	 */
public interface Product extends Cloneable {
		
		/**
		 * 
		 * 文字列に装飾を施す
		 * 
		 * @param s 文字列
		 */
	public abstract void use(String s);
	
	
	public abstract Product createClone();
}
