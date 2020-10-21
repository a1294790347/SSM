package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.bean.Yhb;

public interface YhbService {
	List<Map<String, Object>> getList();
	int addYh(Yhb yhb);
	List<Map<String, Object>> getListByName(Yhb yhb);
	int updateYh(Yhb yhb);
	int deleteYh(int yhid);
	List<Map<String, Object>> getList2();
	Map<String, Object> isExsit(String yhnc);
	Map<String, Object> newYh(Yhb yhb);
	Map<String, Object> loginYh(Yhb yhb, HttpSession session);
}
