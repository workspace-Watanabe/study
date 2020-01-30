package state;

import state.context.Context;

public class DayState implements State{
	//唯一のインスタンス
	private static State dayState = new DayState();

	//インスタンス化禁止
	private DayState() {
	}

	//唯一のインスタンスを得る
	public static State getInstace() {
		return dayState;
	}

	/**
	 * 時刻設定
	 */
	public void doClock(Context context, int hour) {
		if(17 <= hour || hour < 9) {
			context.changeState(NightState.getInstance());
		}
	}

	/**
	 * 金庫使用
	 */
	public void doUse(Context context) {
		context.recordLog("金庫使用(昼間)");
	}

	/**
	 * 非常ベルを鳴らす
	 */
	@Override
	public void doArarm(Context context) {
		context.callSecurityCenter("非常ベル(昼間)");

	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("通常の電話(昼間)");
	}

	@Override
	public String toString() {
		return "[昼間]";
	}

}
