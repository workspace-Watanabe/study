package factory;

/*
 * LinkとTrayクラスを同一視する為のクラス
 */
public abstract class Item {

		/*
		 * 見出し
		 */
	protected String caption;

	public Item(String caption) {
		this.caption = caption;
	}

	public abstract String makeHTML();
}
