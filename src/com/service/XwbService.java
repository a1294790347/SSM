package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Xwb;

public interface XwbService {
	List<Map<String, Object>> getList();
	int addXw(Xwb xwb);
	List<Map<String, Object>> getListByName(Xwb xwb);
	int updateXw(Xwb xwb);
	int deleteXw(int xwid);
}
