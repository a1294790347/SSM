package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Bjb;
import com.dao.bj.BjbDao;
import com.service.BjbService;

@Service
public class BjbServiceImpl implements BjbService {
	@Autowired
	private BjbDao bjbDao;


	@Override
	public int addBj(Bjb bjb) {
		return bjbDao.addBj(bjb);
	}


	@Override
	public List<Map<String, Object>> getList() {
		return bjbDao.getList();
	}


	@Override
	public List<Map<String, Object>> getListByName(Bjb bjb) {
		// TODO Auto-generated method stub
		return bjbDao.getListByName(bjb);
	}


	@Override
	public int updateBj(Bjb bjib) {
		// TODO Auto-generated method stub
		return bjbDao.updateBj(bjib);
	}


	@Override
	public int deleteBj(int bjid) {
		// TODO Auto-generated method stub
		return bjbDao.deleteBj(bjid);
	}


	@Override
	public List<Map<String, Object>> getList2() {
		// TODO Auto-generated method stub
		return bjbDao.getList2();
	}

}
