package composite;

/**
 * ディレクトリエントリを表現するクラス
 *
 * @author merut
 *
 */
public abstract class Entry {
	public abstract String getName();
	public abstract int getSize();

	public Entry add(Entry entry) throws FileTreatmentException{
		throw new FileTreatmentException();
	}

	public void printList() {
		printList("");
	}

	protected abstract void printList(String prefix);


	@Override
	public String toString() {
		return this.getName() + "(" + this.getSize() + ")";
	}
}
