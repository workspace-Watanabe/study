package state;

import state.context.Context;

public interface State {
	//時刻設定
	public void doClock(Context context, int hour);
	//金庫使用
	public void doUse(Context context);
	//非常ベル
	public void doArarm(Context context);
	//通常電話
	public void doPhone(Context context);
}
