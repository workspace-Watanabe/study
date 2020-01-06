package mediator.colleague;

import java.awt.Button;

import mediator.mediator.Mediator;

public class ColleagueButton extends Button implements Colleague{
	private Mediator mediator;

	public ColleagueButton(String caption) {
		super(caption);
	}

	/**
	 * Mediatorを保持する
	 */
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	/**
	 * Mediatorから有効/無効を支持される
	 */
	public void setColleagueEnabled(boolean enabled) {
		this.setEnabled(enabled);
	}
}
