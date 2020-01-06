package mediator.mediator;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mediator.colleague.ColleagueButton;
import mediator.colleague.ColleagueCheckbox;
import mediator.colleague.ColleagueTextField;
public class LoginFrame extends Frame implements ActionListener, Mediator{

	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;


		//コンストラクタ
		//ウィンドウの初期化
	public LoginFrame(String title) {
		super(title);
		this.setBackground(Color.LIGHT_GRAY);
			//レイアウトマネージャーを使って4×2のグリッドを作る
		this.setLayout(new GridLayout(4, 2));
			//Colleagueたちの生成
		createColleagues();
			//配置
		this.add(checkGuest);

	}



	@Override
	public void createColleagues() {
			//生成
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest",g , true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		textUser = new ColleagueTextField("",10);
		textPass = new ColleagueTextField("",10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");

			//Mediatorのセット
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);

			//Listenerのセット
		checkGuest.addItemListener(checkGuest);
		checkGuest.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	/**
	 * Colleagueからの通知で各Colleagueの有効/無効を判定する
	 */
	@Override
	public void colleagueChanged() {
			//ゲストモード
		if(checkGuest.getState()) {
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		}else {
			textUser.setColleagueEnabled(true);
			this.userpassChanged();
		}
	}

	/**
	 * TextUserまたはTextPassの変更があった
	 * 各Colleagueの有効/無効を判定する
	 */
	private void userpassChanged() {
		if(textUser.getText().length() > 0) {
			textPass.setColleagueEnabled(true);
			if(textPass.getText().length() > 0) {
				buttonOk.setColleagueEnabled(true);
			}else {
				textPass.setColleagueEnabled(false);
				buttonOk.setColleagueEnabled(false);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		System.exit(0);
	}
}
