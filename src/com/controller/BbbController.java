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

import com.bean.Bbb;
import com.bean.Yhb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BbbService;

@Controller
@RequestMapping("/bbb")
public class BbbController {
	@Autowired
	private BbbService bbbService;
	
	@PostMapping("/addBb")
	@ResponseBody
	public int addBb(Bbb bbb){
		return bbbService.addBb(bbb);
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
		List<Map<String, Object>> list = bbbService.getList();
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
	public Map<String, Object> getListByName(Bbb Bbb,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = bbbService.getListByName(Bbb);
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
			
		return map;
	}
	@RequestMapping("/updateBb")
	@ResponseBody
	public int updateBb(Bbb bbb){	
		return bbbService.updateBb(bbb);
	}
	@PostMapping("/deleteBb")
	@ResponseBody
	public int deleteBb(int bbid){
		return bbbService.deleteBb(bbid);
	}
	@RequestMapping("/yhbm")
	public String jpxb(HttpSession session){
		List<Map<String, Object>> yhbm = bbbService.jpxb();
		session.setAttribute("yhbm", yhbm);
		return "forward:/qian/yhbaoming.jsp";
	}
	@RequestMapping("/bm")
	@ResponseBody
	public int bm(Bbb bbb, HttpSession session){
		Yhb yhb = (Yhb) session.getAttribute("yh");
		bbb.setYhid(yhb.getYhid());
		
		return bbbService.bm(bbb);
	}
}
