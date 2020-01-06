package support.impl;

import support.abst.Support;
import trouble.Trouble;

/**
 * 特定の番号のトラブルを解決するクラス
 *
 * @author merut
 *
 */
public class SpecialSupport extends Support{
		//この番号だけ解決できる
	private int number;

	public SpecialSupport(String name, int number) {
		super(name);
		this.number = number;
	}

	/**
	 * 指定した番号だけ解決
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
		return (trouble.getNumber() == number)? true : false;
	}
}
