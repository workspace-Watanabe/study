package mediator.colleague;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import mediator.mediator.Mediator;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague{
	private Mediator mediator;

	public ColleagueCheckbox(String caption,
								CheckboxGroup group,
								boolean state) {
		super(caption, group, state);
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	/**
	 * 有効/無効が指示される
	 */
	@Override
	public void setColleagueEnabled(boolean enabled) {
		this.setEnabled(enabled);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		mediator.colleagueChanged();
	}


}
