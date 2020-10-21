package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Lsb;
import com.dao.ls.LsbDao;
import com.service.LsbService;

@Service
public class LsbServiceImpl implements LsbService {
	@Autowired
	private LsbDao lsbDao;


	@Override
	public int addLs(Lsb lsb) {
		return lsbDao.addLs(lsb);
	}


	@Override
	public List<Map<String, Object>> getList() {
		return lsbDao.getList();
	}


	@Override
	public List<Map<String, Object>> getListByName(Lsb lsb) {
		// TODO Auto-generated method stub
		return lsbDao.getListByName(lsb);
	}


	@Override
	public int updateLs(Lsb lsb) {
		// TODO Auto-generated method stub
		return lsbDao.updateLs(lsb);
	}


	@Override
	public int deleteLs(int lsid) {
		// TODO Auto-generated method stub
		return lsbDao.deleteLs(lsid);
	}


	@Override
	public List<Map<String, Object>> getList2() {
		// TODO Auto-generated method stub
		return lsbDao.getList2();
	}

}
