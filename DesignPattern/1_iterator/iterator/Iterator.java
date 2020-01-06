package iterator;

public interface Iterator {
		
		/**
		 * 次の要素があるか確かめる
		 * @return	次の要素があるならtrue
		 */
	public abstract boolean hasNext();
		
		/**
		 * 要素を取り出し、index番号を進める
		 * @return	要素
		 */
	public abstract Object next();
}
