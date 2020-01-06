package observer;

public class InCrementNumberGenerator extends NumberGenerator {

	private final int INDEX;
	private final int END;
	private final int INCREMENT;
	private int number;

	public InCrementNumberGenerator(int index, int end, int increment) {
		INDEX = index;
		END = end;
		INCREMENT = increment;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void execute() {
		for(number = INDEX; number < END; number+=INCREMENT) {
			this.notifyObservers();
		}
	}

}
