package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Bjb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BjbService;
import com.util.FileUp;

@RestController
@RequestMapping("/bjb")
public class BjbController {
	@Autowired
	private BjbService bjbService;
	@Autowired
	private FileUp fileUp;
	
	@PostMapping("/addBj")
	
	public int addBj(Bjb bjb,
			@RequestParam(value = "bjtp1", required = false) MultipartFile file,
			HttpSession session, HttpServletRequest request){
		String path = request.getContextPath();//项目名
		
		String url = fileUp.upload(session, file);//返回文件路径
		if(! "".equals(url)){
			bjb.setBjtp(path + url);
		}
		return bjbService.addBj(bjb);
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
		List<Map<String, Object>> list = bjbService.getList();
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
		
		
		return map;
	}
	@RequestMapping("/getListByName")
	public Map<String, Object> getListByName(Bjb bjb,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = bjbService.getListByName(bjb);
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
			
		return map;
	}
	@RequestMapping("/updateBj")
	public int updateBj(Bjb bjb,
			@RequestParam(value = "bjtp1", required = false) MultipartFile file,
			HttpSession session, HttpServletRequest request){
		String path = request.getContextPath();//项目名
		
		String url = fileUp.upload(session, file);//返回文件路径
		if(! "".equals(url)){
			bjb.setBjtp(path + url);
		}
		return bjbService.updateBj(bjb);
	}
	@PostMapping("/deleteBj")
	public int deleteBj(int bjid){
		
		return bjbService.deleteBj(bjid);
	}
	@RequestMapping("/getList2")
	public List<Map<String, Object>> getList2(){
		return bjbService.getList2();
	}
}
