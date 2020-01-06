package mediator.colleague;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import mediator.mediator.Mediator;

public class ColleagueTextField extends TextField implements TextListener,Colleague{
		private Mediator mediator;

		public ColleagueTextField(String text, int columns) {
			super(text,columns);
		}

		/**
		 * Mediatorを保持
		 */
		public void setMediator(Mediator mediator) {
			this.mediator = mediator;
		}

		/**
		 * Mediatorから有効/無効が支持される
		 */
		public void setColleagueEnabled(boolean enabled) {
			setEnabled(enabled);
			this.setBackground(enabled? Color.white : Color.lightGray);
		}

		/**
		 * 文字列が変化したらMediatorに通知
		 */
		@Override
		public void textValueChanged(TextEvent e) {
			mediator.colleagueChanged();
		}
}
