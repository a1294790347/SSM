package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Lsb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.LsbService;
import com.util.FileUp;

@Controller
@RequestMapping("/lsb")
public class LsbController {
	@Autowired
	private LsbService lsbService;
	@Autowired
	private FileUp fileUp;
	
	@PostMapping("/addLs")
	@ResponseBody
	public int addLs(Lsb lsb,
			@RequestParam(value = "lstp1", required = false) MultipartFile file,
			HttpSession session, HttpServletRequest request){
		String path = request.getContextPath();//项目名
		
		String url = fileUp.upload(session, file);//返回文件路径
		if(! "".equals(url)){
			lsb.setLstp(path + url);
		}
		return lsbService.addLs(lsb);
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
		List<Map<String, Object>> list = lsbService.getList();
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
	public Map<String, Object> getListByName(Lsb lsb,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = lsbService.getListByName(lsb);
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
			
		return map;
	}
	@RequestMapping("/updateLs")
	@ResponseBody
	public int updateLs(Lsb lsb,
			@RequestParam(value = "lstp1", required = false) MultipartFile file,
			HttpSession session, HttpServletRequest request){
		String path = request.getContextPath();//项目名
		
		String url = fileUp.upload(session, file);//返回文件路径
		if(! "".equals(url)){
			lsb.setLstp(path + url);
		}
		return lsbService.updateLs(lsb);
	}
	@PostMapping("/deleteLs")
	@ResponseBody
	public int deleteLs(int lsid){
		
		return lsbService.deleteLs(lsid);
	}
	@RequestMapping("/getList2")
	@ResponseBody
	public List<Map<String, Object>> getList2(){
		return lsbService.getList2();
	}
	@RequestMapping("/yxjs")
	public String yxjs(HttpSession session){
		List<Map<String, Object>> yxjs = lsbService.getList();
		session.setAttribute("yxjs", yxjs);
		return "forward:/qian/youxiujiangshi.jsp";
	}
}
