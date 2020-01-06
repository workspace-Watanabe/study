package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * メールアドレスからユーザーのWEBページを作るクラス
 * @author merut
 *
 */
public class PageMaker {
	private PageMaker() {

	}

	public static void makeWelcomePage(String mail, String fileName) {
		try {
			Properties mailProp = Database.getProperties("maildata");
			String userName = mailProp.getProperty(mail);
			HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
			writer.title("Welcome to" + userName + "'s page!");
			writer.paragraph("メール待っていますね");
			writer.mailto(mail, userName);
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
