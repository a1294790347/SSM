package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Xwb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.XwbService;
import com.util.FileUp;

@RestController
@RequestMapping("/xwb")
public class XwbController {
	@Autowired
	private XwbService xwbService;
	@Autowired
	private FileUp fileUp;
	
	@PostMapping("/addXw")
	public int addXw(Xwb xwb){
		return xwbService.addXw(xwb);
	}
	@RequestMapping("/getList")
	public Map<String, Object> getList(
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = xwbService.getList();
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
		
		
		return map;
	}
	@RequestMapping("/getListByName")
	public Map<String, Object> getListByName(Xwb xwb,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = xwbService.getListByName(xwb);
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
			
		return map;
	}
	@RequestMapping("/updateXw")
	public int updateXw(Xwb xwb){	
		return xwbService.updateXw(xwb);
	}
	@PostMapping("/deleteXw")
	public int deleteXw(int xwid){
		return xwbService.deleteXw(xwid);
	}
}
