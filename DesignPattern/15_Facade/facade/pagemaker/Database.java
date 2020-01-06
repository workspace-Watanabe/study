package facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * データベース名からユーザー名を得るクラス
 *
 *
 */
public class Database {
		//インスタンス生成を禁止する
	private Database() {

	}

	/**
	 * データベース名からPropertiesを得る
	 * @param dbname
	 * @return
	 */
	public static Properties getProperties(String dbname) {

		String fileName = dbname + ".txt";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
