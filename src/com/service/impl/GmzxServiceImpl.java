package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Gmzx;
import com.dao.gmzx.GmzxDao;
import com.service.GmzxService;

@Service
public class GmzxServiceImpl implements GmzxService {
	@Autowired
	private GmzxDao gmzxDao;
	
	@Override
	public List<Map<String, Object>> getList() {
		// TODO Auto-generated method stub
		return gmzxDao.getList();
	}

	@Override
	public int addGm(Gmzx gmzx) {
		// TODO Auto-generated method stub
		return gmzxDao.addGm(gmzx);
	}

	@Override
	public List<Map<String, Object>> getListByName(Gmzx gmzx) {
		// TODO Auto-generated method stub
		return gmzxDao.getListByName(gmzx);
	}

	@Override
	public int updateGm(Gmzx gmzx) {
		// TODO Auto-generated method stub
		return gmzxDao.updateGm(gmzx);
	}

	@Override
	public int deleteGm(int gmid) {
		// TODO Auto-generated method stub
		return gmzxDao.deleteGm(gmid);
	}

	@Override
	public List<Map<String, Object>> gmjl() {
		// TODO Auto-generated method stub
		return gmzxDao.gmjl();
	}

}
