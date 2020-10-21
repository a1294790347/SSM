package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Yhb;
import com.dao.yh.YhbDao;
import com.service.YhbService;

@Service
public class YhbServiceImpl implements YhbService {
	@Autowired
	private YhbDao yhbDao;


	@Override
	public int addYh(Yhb yhb) {
		return yhbDao.addYh(yhb);
	}


	@Override
	public List<Map<String, Object>> getList() {
		return yhbDao.getList();
	}

	@Override
	public List<Map<String, Object>> getListByName(Yhb yhb) {
		// TODO Auto-generated method stub
		return yhbDao.getListByName(yhb);
	}


	@Override
	public int updateYh(Yhb yhb) {
		// TODO Auto-generated method stub
		return yhbDao.updateYh(yhb);
	}

	@Override
	public int deleteYh(int yhid) {
		// TODO Auto-generated method stub
		return yhbDao.deleteYh(yhid);
	}


	@Override
	public List<Map<String, Object>> getList2() {
		// TODO Auto-generated method stub
		return yhbDao.getList2();
	}
	@Override
	public Map<String, Object> isExsit(String yhnc) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = yhbDao.isExsit(yhnc);
		if(result == 1) map.put("exsit", true);
		if(result != 1) map.put("exsit", false);
		return map;
	}
	@Override
	public Map<String, Object> newYh(Yhb yhb) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = yhbDao.addYh(yhb);
		if(result == 1){
			map.put("newYh", false);
		}else{
			map.put("newYh", true);
		}
		return map;
	}
	@Override
	public Map<String, Object> loginYh(Yhb yhb, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Yhb yh = yhbDao.loginYh(yhb);
		if(yh != null && !"".equals(yh)){
			map.put("login", true);
			session.setAttribute("yh", yh);
			session.setAttribute("flag", true);
		}else{
			map.put("login", false);
			session.setAttribute("flag", false);
		}
		return map;
	}


}
