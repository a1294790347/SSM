package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Bcb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BcbService;

@Controller
@RequestMapping("/bcb")
public class BcbController {
	@Autowired
	private BcbService bcbService;
	
	@PostMapping("/addBc")
	@ResponseBody
	public int addBc(Bcb bcb){
		return bcbService.addBc(bcb);
	}

	@RequestMapping("/getList")
	@ResponseBody
	public Map<String, Object> getList(
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = bcbService.getList();
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
	
		return map;
	}
	@RequestMapping("/getListByName")
	@ResponseBody
	public Map<String, Object> getListByName(Bcb bcb,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = bcbService.getListByName(bcb);
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
			
		return map;
	}
	@RequestMapping("/updateBc")
	@ResponseBody
	public int updateBc(Bcb bcb){	
		return bcbService.updateBc(bcb);
	}
	@PostMapping("/deleteBc")
	@ResponseBody
	public int deleteBc(int bcid){
		return bcbService.deleteBc(bcid);
	}
	@RequestMapping("/getList2")
	@ResponseBody
	public List<Map<String, Object>> getList2(){
		return bcbService.getList2();
	}
	@RequestMapping("/jpxb")
	public String jpxb(HttpSession session){
		List<Map<String, Object>> jpsbs = bcbService.jpxb();
		session.setAttribute("jpsbs", jpsbs);
		return "forward:/qian/jingpinxiaoban.jsp";
	}
	@PostMapping("/xgrs")
	@ResponseBody
	public int xgrs(int bcid){	
		return bcbService.xgrs(bcid);
	}
}
