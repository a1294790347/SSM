package com.dao.bb;

import java.util.List;
import java.util.Map;

import com.bean.Bbb;

public interface BbbDao {
	int addBb(Bbb bbb);

	List<Map<String, Object>> getList();

	List<Map<String, Object>> getListByName(Bbb bbb);

	int updateBb(Bbb bbb);

	int deleteBb(int bbid);

	List<Map<String, Object>> jpxb();;
}
