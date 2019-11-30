package singleton;
	/*
	 * 1つのインスタンスしか持たないことを保証するクラス
	 */
public class Singleton {
	
		//このクラスのインスタンス
	private static Singleton singleton = new Singleton();
	
		//privateにすることで普通にインスタンス化はできない
	private Singleton() {
		System.out.println("インスタンスを生成しました");
	}
	
		/**
		 * すでに生成されているインスタンスを返す
		 * 
		 * @return このクラスのインスタンス
		 */
	public static Singleton getInstance() {
		return singleton;
	}
}
