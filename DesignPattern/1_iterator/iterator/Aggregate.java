package iterator;
	/**
	 * 集合体を表すインターフェース
	 * @author Yukari
	 *
	 */
public interface Aggregate {
		
		/*
		 * 次の要素が存在するかどうか確かめる
		 */
	public abstract boolean hasnext();
	
		/**
		 * 次の要素を得る
		 * @return	
		 */
	public abstract Object next();
}
