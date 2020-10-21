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

import com.bean.Xqb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.XqbService;
import com.util.FileUp;

@RestController
@RequestMapping("/xqb")
public class XqbController {
	@Autowired
	private XqbService xqbService;
	@Autowired
	private FileUp fileUp;
	
	@PostMapping("/addXq")
	public int addXq(Xqb xqb,
			@RequestParam(value = "xqtp1", required = false) MultipartFile file,
			HttpSession session, HttpServletRequest request){
		String path = request.getContextPath();//项目名
		
		String url = fileUp.upload(session, file);//返回文件路径
		if(! "".equals(url)){
			xqb.setXqtp(path + url);
		}
		return xqbService.addXq(xqb);
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
		List<Map<String, Object>> list = xqbService.getList();
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
		
		
		return map;
	}
	@RequestMapping("/getListByName")
	public Map<String, Object> getListByName(Xqb xqb,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = xqbService.getListByName(xqb);
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
			
		return map;
	}
	@RequestMapping("/updateXq")
	public int updateXq(Xqb xqb,
			@RequestParam(value = "xqtp1", required = false) MultipartFile file,
			HttpSession session, HttpServletRequest request){
		String path = request.getContextPath();//项目名
		
		String url = fileUp.upload(session, file);//返回文件路径
		if(! "".equals(url)){
			xqb.setXqtp(path + url);
		}
		return xqbService.updateXq(xqb);
	}
	@PostMapping("/deleteXq")
	public int deleteXq(int xqid){
		
		return xqbService.deleteXq(xqid);
	}
	@RequestMapping("/getList2")
	public List<Map<String, Object>> getList2(){
		return xqbService.getList2();
	}
}
