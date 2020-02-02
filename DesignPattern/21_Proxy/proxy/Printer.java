package proxy;
/**
 * 本人
 *
 */
public class Printer implements Printable{

	//プリンターの名前
	private String name;

	public Printer() {
		heavyJob("プリンターのインスタンスを生成中");
	}

	public Printer(String name) {
		this.name = name;
		heavyJob("Printerノインスタンス" + name + "を準備中");
	}

//=======================================================================================================//

	/**
	 * 名前を設定
	 */
	@Override
	public void setPrinterName(String name) {
		this.name = name;
	}

	/**
	 * 名前を取得
	 */
	@Override
	public String getPrintterName() {
		return name;
	}

	/**
	 * プリンタの名前付きで文字列を取得
	 */
	@Override
	public void print(String msg) {
		System.out.println("====" + name + "====");
		System.out.println(msg);
	}

	/**
	 * 重い仕事
	 */
	private void heavyJob(String msg) {
		System.out.println(msg);
		for(int i=0; i < 5; i++) {
			System.out.println(".");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("完了。");
	}

}
