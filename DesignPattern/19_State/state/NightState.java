package state;

import state.context.Context;

public class NightState implements State{
		//唯一のインスタンス
	private static State nightState = new NightState();

	private NightState() {

	}


	// ========================================================//

	public static State getInstance() {
		return nightState;
	}

	@Override
	public void doClock(Context context, int hour) {
		if(9 <= hour && hour < 17)
			context.changeState(DayState.getInstace());
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("非常！: 夜間の金庫使用!!");

	}

	@Override
	public void doArarm(Context context) {
		context.callSecurityCenter("非常 : 夜間の非常ベル)");

	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("夜間の通話録音");
	}

	@Override
	public String toString() {
		return "[夜間]";
	}

}
