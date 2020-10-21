package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Xqb;
import com.dao.xq.XqbDao;
import com.service.XqbService;

@Service
public class XqbServiceImpl implements XqbService {
	@Autowired
	private XqbDao xqbDao;


	@Override
	public int addXq(Xqb xqb) {
		return xqbDao.addXq(xqb);
	}


	@Override
	public List<Map<String, Object>> getList() {
		return xqbDao.getList();
	}


	@Override
	public List<Map<String, Object>> getListByName(Xqb xqb) {
		// TODO Auto-generated method stub
		return xqbDao.getListByName(xqb);
	}


	@Override
	public int updateXq(Xqb xqb) {
		// TODO Auto-generated method stub
		return xqbDao.updateXq(xqb);
	}


	@Override
	public int deleteXq(int xqid) {
		// TODO Auto-generated method stub
		return xqbDao.deleteXq(xqid);
	}


	@Override
	public List<Map<String, Object>> getList2() {
		// TODO Auto-generated method stub
		return xqbDao.getList2();
	}

}
