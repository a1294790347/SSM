package com.dao.yh;

import java.util.List;
import java.util.Map;

import com.bean.Yhb;

public interface YhbDao {
	List<Map<String, Object>> getList();
	int addYh(Yhb yhb);
	List<Map<String, Object>> getListByName(Yhb yhb);
	int updateYh(Yhb yhb);
	int deleteYh(int yhid);
	List<Map<String, Object>> getList2();
	int isExsit(String yhnc);
	Yhb loginYh(Yhb yhb);
}
