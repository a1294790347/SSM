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

import com.bean.Yhb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.YhbService;
import com.util.FileUp;

@Controller
@RequestMapping("/yhb")
public class YhbController {
	@Autowired
	private YhbService yhbService;
	@Autowired
	private FileUp fileUp;
	
	@PostMapping("/addYh")
	@ResponseBody
	public int addYh(Yhb yhb){
		return yhbService.addYh(yhb);
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
		List<Map<String, Object>> list = yhbService.getList();
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
	public Map<String, Object> getListByName(Yhb Yhb,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows){
		//声明分页对象
		PageHelper pg = new PageHelper();
		//设置当前页码
		pg.startPage(page, rows);
		//获取所有数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = yhbService.getListByName(Yhb);
		//创建页面记录对象
		PageInfo pageInfo = new PageInfo(list);
		//将所有记录放入map中
		map.put("rows", list);
		//通过pageInfo.getTotal反复可以把计算好的总页数放入map
		map.put("total", pageInfo.getTotal());
			
		return map;
	}
	@RequestMapping("/updateYh")
	@ResponseBody
	public int updateYh(Yhb yhb){	
		return yhbService.updateYh(yhb);
	}
	@PostMapping("/deleteYh")
	@ResponseBody
	public int deleteYh(int yhid){
		return yhbService.deleteYh(yhid);
	}
	@RequestMapping("/getList2")
	@ResponseBody
	public List<Map<String, Object>> getList2(){
		return yhbService.getList2();
	}
	@RequestMapping("/isExsit")
	@ResponseBody
	public Map<String, Object> isExsit(String yhnc){
		return yhbService.isExsit(yhnc);
	}
	@PostMapping("/newYh")
	@ResponseBody
	public Map<String, Object> newYh(Yhb yhb){
		return yhbService.newYh(yhb);
	}
	@RequestMapping("/loginYh")
	@ResponseBody
	public Map<String, Object> loginYh(Yhb yhb, HttpSession session){
		return yhbService.loginYh(yhb,session);
	}
	@RequestMapping("/exit")
	public String exit(HttpSession session){
		session.removeAttribute("flag");
		session.removeAttribute("yh");
		return "forward:/qian/index.jsp";
	}
}
