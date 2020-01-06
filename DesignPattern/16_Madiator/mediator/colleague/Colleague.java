package mediator.colleague;

import mediator.mediator.Mediator;

//相談役に対して相談を持ち掛ける
public interface Colleague {
		public void setMediator(Mediator mediator);
		public void setColleagueEnabled(boolean enabled);
}
