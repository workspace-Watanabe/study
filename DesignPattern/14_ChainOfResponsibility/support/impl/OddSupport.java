package support.impl;

import support.abst.Support;
import trouble.Trouble;

/**
 * 奇数番号のトラブルを解決するクラス
 *
 * @author merut
 *
 */
public class OddSupport extends Support{

	public OddSupport(String name) {
		super(name);
	}

	/**
	 * 奇数番号だけ解決
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
		return (trouble.getNumber() % 2 == 1)? true : false;
	}
}
