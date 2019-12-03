package factory;
import java.util.ArrayList;
/*
 * リストの枠組み
 */
public	abstract class Tray extends Item{

	protected ArrayList tray = new ArrayList();

	public Tray(String caption) {
		super(caption);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void add(Item item) {
		tray.add(item);
	}

}
