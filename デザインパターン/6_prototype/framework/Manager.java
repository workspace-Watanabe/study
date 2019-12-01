package framework;

import java.util.HashMap;

/*
 * Productインターフェースを利用してインスタンスの複製を行うクラス
 */
public class Manager {
	
	private HashMap<String , Product> map = new HashMap();
	
		
		/**
		 * 
		 * 製品の名前とProductインターフェースを与えられると。その１組をmapに登録する
		 * 
		 * @param name 製品の名前
		 * @param proto
		 */
	public void register(String name, Product proto) {
		map.put(name,proto);
	}
	
		/**
		 * 
		 * 指定したキーに対応するProduct型のインスタンスを取り出し、
		 * それのクローンを返す
		 * 
		 * @param protoname key
		 * @return keyに対応するProduct型のインスタンスのコピー
		 */
	public Product create(String protoname) {
		Product p = (Product)map.get(protoname);
		return p.createClone();
	}
}
