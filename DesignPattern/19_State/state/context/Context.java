package state.context;

import state.State;

public interface Context {
		//時刻の設定
	public void setClock(int hour);
		//状態変化
	public void changeState(State state);
		//警備センター呼び出し
	public void callSecurityCenter(String msg);
		//警備センター記録
	public void recordLog(String msg);
}
