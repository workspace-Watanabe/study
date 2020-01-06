package composite;

public class Main {
	public static void main(String[] args) {


			System.out.println("Making root entries");
			Directory rootdir = new Directory("root");
			Directory bindir = new Directory("bin");
			Directory tmpdir = new Directory("tmp");
			Directory userdir = new Directory("user");

			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(userdir);


			rootdir.add(new File("vi",1000,""));
			rootdir.printList();


	}
}
