package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Bbb;

public interface BbbService {

	int addBb(Bbb bbb);

	List<Map<String, Object>> getList();

	List<Map<String, Object>> getListByName(Bbb bbb);

	int updateBb(Bbb bbb);

	int deleteBb(int bbid);

	int bm(Bbb bbb);

	List<Map<String, Object>> jpxb();

}
