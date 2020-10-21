package com.dao.gmzx;

import java.util.List;
import java.util.Map;

import com.bean.Gmzx;

public interface GmzxDao {
	List<Map<String, Object>> getList();
	int addGm(Gmzx gmzx);
	List<Map<String, Object>> getListByName(Gmzx gmzx);
	int updateGm(Gmzx gmzx);
	int deleteGm(int gmid);
	List<Map<String, Object>> gmjl();
}
