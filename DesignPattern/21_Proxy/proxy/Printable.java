package proxy;
/**
 * 主体
 */
public interface Printable {
	public void setPrinterName(String name);
	public String getPrintterName();
	public void print(String msg);
}
