package com.dao.zx;

import java.util.List;
import java.util.Map;

import com.bean.Lsb;
import com.bean.Zxb;

public interface ZxbDao {
	List<Map<String, Object>> getList();
	int addZx(Zxb zxb);
	List<Map<String, Object>> getListByName(Zxb zxb);
	int updateZx(Zxb zxb);
	int deleteZx(int zxid);
	List<Map<String, Object>> getList2();
}
