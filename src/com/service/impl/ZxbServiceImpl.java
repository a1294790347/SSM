package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Zxb;
import com.dao.zx.ZxbDao;
import com.service.ZxbService;

@Service
public class ZxbServiceImpl implements ZxbService {
	@Autowired
	private ZxbDao zxbDao;
	
	@Override
	public List<Map<String, Object>> getList() {
		// TODO Auto-generated method stub
		return zxbDao.getList();
	}

	@Override
	public int addZx(Zxb zxb) {
		// TODO Auto-generated method stub
		return zxbDao.addZx(zxb);
	}

	@Override
	public List<Map<String, Object>> getListByName(Zxb zxb) {
		// TODO Auto-generated method stub
		return zxbDao.getListByName(zxb);
	}

	@Override
	public int updateZx(Zxb zxb) {
		// TODO Auto-generated method stub
		return zxbDao.updateZx(zxb);
	}

	@Override
	public int deleteZx(int zxid) {
		// TODO Auto-generated method stub
		return zxbDao.deleteZx(zxid);
	}

	@Override
	public List<Map<String, Object>> getList2() {
		// TODO Auto-generated method stub
		return zxbDao.getList2();
	}

}
