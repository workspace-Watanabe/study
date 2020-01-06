package support.abst;

import trouble.Trouble;

/**
 * トラブルを解決する抽象クラス
 *
 * @author merut
 *
 */
public abstract class Support {
		//トラブル解決者の名前
	private String name;
		//たらいまわしの先
	private Support next;

		//トラブル解決者の生成
	public Support(String name) {
		this.name = name;
	}

		/**
		 * たらいまわしの先を指定
		 *
		 */
	public Support setNext(Support support) {
		this.next = support;
		return next;
	}

	/**
	 * トラブル解決の手順
	 */
	public final void support(Trouble trouble) {
		for(Support support = this; support != null; support = support.next) {
			if(support.resolve(trouble)) {
				done(trouble);
				break;
			}else if(support.next == null) {
				fail(trouble);
			}

		}
	}

		//文字列表現
	public String toString() {
		return "[" + this.name + "]";
	}

		//解決用メソッド
	protected abstract boolean resolve(Trouble trouble);

		/**
		 * 解決
		 */
	protected void done(Trouble trouble) {
		System.out.println(trouble + " is resolved by" + this + ".");
	}

		/**
		 * 未解決
		 */
	protected void fail(Trouble trouble) {
		System.out.println(trouble + " cannot be resolved");
	}

}
