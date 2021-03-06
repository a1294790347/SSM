package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Bjb;

public interface BjbService {
	List<Map<String, Object>> getList();
	int addBj(Bjb bjb);
	List<Map<String, Object>> getListByName(Bjb bjb);
	int updateBj(Bjb bjb);
	int deleteBj(int bjid);
	List<Map<String, Object>> getList2();
}
