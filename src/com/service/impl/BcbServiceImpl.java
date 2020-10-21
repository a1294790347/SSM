package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Bcb;
import com.dao.bc.BcbDao;
import com.service.BcbService;

@Service
public class BcbServiceImpl implements BcbService {
	@Autowired
	private BcbDao bcbDao;


	@Override
	public int addBc(Bcb bcb) {
		return bcbDao.addBc(bcb);
	}


	@Override
	public List<Map<String, Object>> getList() {
		return bcbDao.getList();
	}


	@Override
	public List<Map<String, Object>> getListByName(Bcb bcb) {
		// TODO Auto-generated method stub
		return bcbDao.getListByName(bcb);
	}


	@Override
	public int updateBc(Bcb bcb) {
		// TODO Auto-generated method stub
		return bcbDao.updateBc(bcb);
	}


	@Override
	public int deleteBc(int bcid) {
		// TODO Auto-generated method stub
		return bcbDao.deleteBc(bcid);
	}


	@Override
	public List<Map<String, Object>> getList2() {
		// TODO Auto-generated method stub
		return bcbDao.getList2();
	}


	@Override
	public List<Map<String, Object>> jpxb() {
		// TODO Auto-generated method stub
		return bcbDao.jpxb();
	}


	@Override
	public int xgrs(int bcid) {
		// TODO Auto-generated method stub
		return bcbDao.xgrs(bcid);
	}

}
