package state.context;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import state.DayState;
import state.State;

public class SafeFrame extends Frame implements Context, ActionListener {

	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10,60);
	private Button buttonUse = new Button("金庫使用");
	private Button buttonAlarm = new Button("非常ベル");
	private Button buttonPhone = new Button("通常電話");
	private Button buttonExit = new Button("終了");

	private State state = DayState.getInstace();

	public SafeFrame(String title) {
		super(title);
		setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BorderLayout());
		//textClockを配置
		add(textClock,BorderLayout.NORTH);
		textClock.setEditable(false);
		//textScreenを配置
		add(textScreen,BorderLayout.CENTER);
		textScreen.setEditable(false);
		//パネルにボタンを配置
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
			//---------------- そのパネルを配置 --------------
		add(panel,BorderLayout.SOUTH);

		pack();
		show();
		//リスナの設定
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());

		if(e.getSource() == buttonUse)            //金庫使用ボタン
			state.doUse(this);
		else if(e.getSource() == buttonAlarm)    //非常ベルボタン
			state.doArarm(this);
		else if(e.getSource() == buttonPhone)    //通常電話
			state.doPhone(this);
		else if (e.getSource() == buttonExit)
			System.exit(0);
		else
			System.out.println("?");
	}

	@Override
	public void setClock(int hour) {
		String clockString = "現在時刻は";
		clockString += (hour < 10)? "0" + hour + ":00" : hour + ":00";
		System.out.println(clockString);
		textClock.setText(clockString);
		state.doClock(this, hour);

	}

	/**
	 * 状態変化
	 */
	@Override
	public void changeState(State state) {
		System.out.println(this.state + "から" + state + "に変更しました。");
		this.state = state;
	}

	@Override
	public void callSecurityCenter(String msg) {
		textScreen.append("call!" + msg + "\n");
	}

	@Override
	public void recordLog(String msg) {
		textScreen.append("record... "+ msg + "\n");
	}

}
