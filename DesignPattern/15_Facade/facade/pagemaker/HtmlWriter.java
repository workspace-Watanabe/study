package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {

	private Writer writer;

	public HtmlWriter(Writer writer) {
		this.writer = writer;
	}

	/**
	 * タイトルの出力
	 *
	 * @param title
	 * @throws IOException
	 */
	public void title(String title) throws IOException{
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>" + title + "</title>");
		writer.write("</head>");
		writer.write("<body>\n");
		writer.write("<h1>" + title + "</h1>");
	}

	/**
	 * 段落の出力
	 */
	public void paragraph(String msg) throws IOException{
		writer.write("<p>" + msg + "</p>\n");
	}

	/**
	 * リンクの出力
	 */
	public void link(String href, String caption) throws IOException{
		paragraph("<a href=\"" + href + "\">" + caption + "</a>");
	}

	//メールアドレスの出力
	public void mailto(String mailaddr, String userName)throws IOException{
		link("mailto : " + mailaddr, userName);
	}

	public void close() throws IOException{
		writer.write("</body>");
		writer.write("</html>\n");
		writer.close();
	}
}
