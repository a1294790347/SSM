package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Xwb;
import com.dao.xw.XwbDao;
import com.service.XwbService;

@Service
public class XwbServiceImpl implements XwbService {
	@Autowired
	private XwbDao xwbDao;


	@Override
	public int addXw(Xwb xwb) {
		return xwbDao.addXw(xwb);
	}


	@Override
	public List<Map<String, Object>> getList() {
		return xwbDao.getList();
	}


	@Override
	public List<Map<String, Object>> getListByName(Xwb xwb) {
		return xwbDao.getListByName(xwb);
	}


	@Override
	public int updateXw(Xwb xwb) {
		return xwbDao.updateXw(xwb);
	}


	@Override
	public int deleteXw(int xwid) {
		return xwbDao.deleteXw(xwid);
	}

}
