package observer;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
		//観測者たちを保持
	private ArrayList<Observer> list = new ArrayList<>();
		//観測者を追加
	public void addObserver(Observer observer) {
		list.add(observer);
	}
		//Observerを削除
	public void deleteObserver(Observer observer) {
		list.remove(observer);
	}
	/**
	 * オブザーバーに通知
	 */
	public void notifyObservers() {
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Observer o = (Observer) it.next();
			o.update(this);
		}
	}
		//数を取得する
	public abstract int getNumber();
		//数を生成する
	public abstract void execute();
}
