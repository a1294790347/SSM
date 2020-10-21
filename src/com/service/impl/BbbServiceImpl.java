package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javafx.scene.chart.PieChart.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Bbb;
import com.dao.bb.BbbDao;
import com.service.BbbService;
import com.util.GetNowDate;

@Service
public class BbbServiceImpl implements BbbService {
	@Autowired
	private BbbDao bbbDao;
	@Override
	public int addBb(Bbb bbb) {
		// TODO Auto-generated method stub
		return bbbDao.addBb(bbb);
	}

	@Override
	public List<Map<String, Object>> getList() {
		// TODO Auto-generated method stub
		return bbbDao.getList();
	}

	@Override
	public List<Map<String, Object>> getListByName(Bbb bbb) {
		// TODO Auto-generated method stub
		return bbbDao.getListByName(bbb);
	}

	@Override
	public int updateBb(Bbb bbb) {
		// TODO Auto-generated method stub
		return bbbDao.updateBb(bbb);
	}

	@Override
	public int deleteBb(int bbid) {
		// TODO Auto-generated method stub
		return bbbDao.deleteBb(bbid);
	}

	@Override
	public int bm(Bbb bbb) {
		String nowDate = GetNowDate.getDate();
		
		bbb.setBbsj(nowDate);
		return bbbDao.addBb(bbb);
	}

	@Override
	public List<Map<String, Object>> jpxb() {
		// TODO Auto-generated method stub
		return bbbDao.jpxb();
	}
}
