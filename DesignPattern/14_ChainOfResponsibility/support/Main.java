package support;

import support.abst.Support;
import support.impl.LimitSupport;
import support.impl.NoSupport;
import support.impl.OddSupport;
import support.impl.SpecialSupport;
import trouble.Trouble;

public class Main {
	public static void main(String[] args) {
			//トラブル解決者を生成
		Support alice = new NoSupport("Alice");
		Support bob = new LimitSupport("Bob",100);
		Support charile = new SpecialSupport("Charile", 429);
		Support diana = new LimitSupport("Diana", 200);
		Support elmo = new OddSupport("Elmo");
		Support fred = new LimitSupport("Fred", 300);

			//連鎖の形成
		alice.setNext(bob).setNext(charile).setNext(diana).setNext(elmo).setNext(fred);

			//トラブルを発生させる
		for(int i=0; i < 500; i++) {
			alice.support(new Trouble(i));
		}
	}
}
