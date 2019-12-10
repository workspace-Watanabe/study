package com.example.demo.reversi.repository;

import java.util.List;
import java.util.Map;

public interface SelectTableInterface {

	/**
	 * てーぶの中身を取得
	 * @return
	 */
	public List<Map<String,Object>> Select();
}
