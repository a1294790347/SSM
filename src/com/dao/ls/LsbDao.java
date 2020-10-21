package com.dao.ls;

import java.util.List;
import java.util.Map;

import com.bean.Lsb;

public interface LsbDao {
	List<Map<String, Object>> getList();
	int addLs(Lsb Lsb);
	List<Map<String, Object>> getListByName(Lsb Lsb);
	int updateLs(Lsb Lsb);
	int deleteLs(int lsid);
	List<Map<String, Object>> getList2();
}
