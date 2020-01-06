package composite;

public class File extends Entry{
	private String name;

	private int size;

	public String test;
	public File(String name, int size ,String test) {
		this.name = name;
		this.size = size;
		this.test = test;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public int getSize() {

		return this.size;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);

	}


}
