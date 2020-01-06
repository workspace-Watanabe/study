package mement;

import mement.game.Gamer;
import mement.game.Mement;

public class Main {
	public static void main(String[] args) {
			//最初の所持金は100円
		Gamer gamer = new Gamer(100);
		Mement mement = gamer.createMement();

		for(int i=0; i < 100; i++) {
			System.out.println("===============" + i);
			System.out.println("現状 : " + gamer);

			gamer.bet();

			System.out.println("所持金は" + gamer.getMoney() + "円になりました。");

			if(gamer.getMoney() > mement.getMoney()) {
				System.out.println("所持金が増えたので、現在の状態を保存しておこう");
				mement = gamer.createMement();
			}else if(gamer.getMoney() < (mement.getMoney()/2)) {
				System.out.println("だいぶ減ったので、以前の状態に復帰しよう。");
				gamer.restoreMement(mement);
			}

			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {

			}
		}

	}
}
