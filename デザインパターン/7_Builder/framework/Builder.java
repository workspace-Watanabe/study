package framework;
/**
 * 文書を作るメソッドを宣言しているインターフェース
 * 
 * @author yukari
 *
 */
public interface Builder {
	
		/**
		 * 文書のタイトルを作成
		 * 
		 * @param title タイトル
		 */
	public abstract void makeTitle(String title);
		
		/**
		 * 文書の文字列を作成
		 * 
		 * @param str 文字列
		 */
	public abstract void makeString(String str);
		
	
		/**
		 * 箇条書きを作成
		 * 
		 * @param items リストの中身
		 */
	public abstract void makeItems(String[] items);
	
	
		/**
		 * 文書を完成させる
		 */
	public abstract void close();
}
