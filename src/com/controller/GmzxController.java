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

import com.bean.Gmzx;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.GmzxService;
import com.util.FileUp;

@Controller
@RequestMapping("/gmzx")
public class GmzxController {
	@Autowired
	private GmzxService gmzxService;
	@Autowired
	private FileUp fileUp;
	
	@PostMapping("/addGm")
	@ResponseBody
	public int addGm(Gmzx gmzx){
		
		return gmzxService.addGm(gmzx);
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
		List<Map<String, Object>> list = gmzxService.getList();
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
	public Map<String, Object> getListByName(Gmzx Gmzx,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = gmzxService.getListByName(Gmzx);
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
			
		return map;
	}
	@RequestMapping("/updateGm")
	@ResponseBody
	public int updateGm(Gmzx gmzx){
		return gmzxService.updateGm(gmzx);
	}
	@PostMapping("/deleteGm")
	@ResponseBody
	public int deleteGm(int gmid){
		
		return gmzxService.deleteGm(gmid);
	}
	@RequestMapping("/gmjl")
	public String gmjl(HttpSession session){
		List<Map<String, Object>> gmjls = gmzxService.gmjl();
		session.setAttribute("gmjls", gmjls);
		
		return "forward:/qian/yhgoumai.jsp";
	}

	
}
