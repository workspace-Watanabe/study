package proxy;
/**
 * 代理人
 *
 */

public class PrinterProxy implements Printable {
	//名前
	private String name;
	//本人
	private Printable printer;
	//クラスネーム
	private String className;


	public PrinterProxy(String name, String className) {
		this.name = name;
		this.className = className;
	}
//============================================================================//

	/**
	 * 本人のインスタンスを保持しているなら本人にも設定する
	 */
	@Override
	public void setPrinterName(String name) {
		this.name = name;
		if(printer != null)
			printer.setPrinterName(name);
	}

	/**
	 * 名前を取得
	 */
	@Override
	public String getPrintterName() {
		return name;
	}

	/**
	 * 代理人としての管轄外なので本人に任せる
	 */
	@Override
	public void print(String msg) {
		realize();
		printer.print(msg);
	}

	/**
	 * 本人を生成
	 */
	public void realize() {
		if(printer == null) {
			try {
				printer = (Printer)Class.forName(className).newInstance();
				printer.setPrinterName(name);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


}
