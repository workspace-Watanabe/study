package proxy;

public class Main {
	public static void main(String[] args) {
		Printable printable = new PrinterProxy("ALICE","proxy.Printer");
		System.out.println("名前は現在" + printable.getPrintterName() + "です。");
		printable.setPrinterName("Bob");
		System.out.println("名前は現在" + printable.getPrintterName() + "です。");
		printable.print("Hello World");
	}
}
