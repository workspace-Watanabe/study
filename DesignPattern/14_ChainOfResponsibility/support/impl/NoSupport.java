package support.impl;

import support.abst.Support;
import trouble.Trouble;

/**
 * トラブルは解決しないクラス
 *
 * @author merut
 *
 */
public class NoSupport extends Support{

	public NoSupport(String name) {
		super(name);
	}

	/**
	 * トラブルを解決しない
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
			//何も解決しない
		return false;
	}

}
