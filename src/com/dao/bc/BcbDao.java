package com.dao.bc;

import java.util.List;
import java.util.Map;

import com.bean.Bcb;
import com.bean.Xwb;

public interface BcbDao {
	int addBc(Bcb bcb);

	List<Map<String, Object>> getList();

	List<Map<String, Object>> getListByName(Bcb bcb);

	int updateBc(Bcb bcb);

	int deleteBc(int bcid);

	List<Map<String, Object>> getList2();

	List<Map<String, Object>> jpxb();

	int xgrs(int bcid);
}
