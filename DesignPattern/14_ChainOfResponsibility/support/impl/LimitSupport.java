package support.impl;

import support.abst.Support;
import trouble.Trouble;

/**
 * 指定した番号未満のトラブルを解決
 * @author merut
 *
 */
public class LimitSupport extends Support{

		//この番号未満なら解決できる
	private int limit;

	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}

	/**
	 * limit未満の番号を解決
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
		return (limit > trouble.getNumber())? true : false;
	}
}
