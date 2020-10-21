package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Zxb;

public interface ZxbService {
	List<Map<String, Object>> getList();
	int addZx(Zxb zxb);
	List<Map<String, Object>> getListByName(Zxb zxb);
	int updateZx(Zxb zxb);
	int deleteZx(int zxid);
	List<Map<String, Object>> getList2();

}
