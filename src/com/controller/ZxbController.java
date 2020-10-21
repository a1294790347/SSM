package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Zxb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ZxbService;
import com.util.FileUp;

@RestController
@RequestMapping("/zxb")
public class ZxbController {
	@Autowired
	private ZxbService zxbService;
	@Autowired
	private FileUp fileUp;
	
	@PostMapping("/addZx")
	
	public int addZx(Zxb zxb,
			@RequestParam(value = "zxtp1", required = false) MultipartFile file,
			HttpSession session, HttpServletRequest request){
		String path = request.getContextPath();//项目名
		
		String url = fileUp.upload(session, file);//返回文件路径
		if(! "".equals(url)){
			zxb.setZxtp(path + url);
		}
		return zxbService.addZx(zxb);
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
		List<Map<String, Object>> list = zxbService.getList();
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
		
		
		return map;
	}
	@RequestMapping("/getListByName")
	public Map<String, Object> getListByName(Zxb zxb,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = zxbService.getListByName(zxb);
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
			
		return map;
	}
	@RequestMapping("/updateZx")
	public int updateZx(Zxb zxb,
			@RequestParam(value = "zxtp1", required = false) MultipartFile file,
			HttpSession session, HttpServletRequest request){
		String path = request.getContextPath();//项目名
		
		String url = fileUp.upload(session, file);//返回文件路径
		if(! "".equals(url)){
			zxb.setZxtp(path + url);
		}
		return zxbService.updateZx(zxb);
	}
	@PostMapping("/deleteZx")
	public int deleteZx(int zxid){
		
		return zxbService.deleteZx(zxid);
	}
	@RequestMapping("/getList2")
	public List<Map<String, Object>> getList2(){
		return zxbService.getList2();
	}
}
