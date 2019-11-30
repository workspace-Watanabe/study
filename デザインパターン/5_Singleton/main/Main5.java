package main;
import singleton.Singleton;

public class Main5 {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		String text = (s1 == s2)? "同じインスタンスです" : "違うインスタンスです";
		
		System.out.println(text);

	}

}
