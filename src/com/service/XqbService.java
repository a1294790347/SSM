package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Xqb;

public interface XqbService {
	List<Map<String, Object>> getList();
	int addXq(Xqb xqb);
	List<Map<String, Object>> getListByName(Xqb xqb);
	int updateXq(Xqb xqb);
	int deleteXq(int xqid);
	List<Map<String, Object>> getList2();
}
