package com.my.order.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.my.order.entity.My_order;
import com.my.order.service.My_order_Service;
import com.my.order.utils.SearchInfo;
import com.my.order.utils.Tools;


@Controller
@RequestMapping("My_order")
public class My_order_Controller {      //test bhhfhihohgiofufuiiuuhgpohgphegoiehggggggg
	@Autowiredru
	My_order_Service service;
	123123
	@RequestMapping("index")
	public String index(SearchInfo info,Model m) {
		if(info.getWhere()!=null) {
			m.addAttribute("val",info.getWhere());
			info.setWhere(" where My_order.goods like '%" + info.getWhere() + "%'");
		}
		m.addAttribute("list", service.select(info));
		System.out.println(info.toString());
		m.addAttribute("result", info);
		return "My_order/index";
	}
	
	@RequestMapping("add")
	public String add(Model m) {
		return "My_order/edit";
	}
	@RequestMapping("insert")
	public String insert(My_order order,Model m,HttpServletRequest req) {
		order.setCreate_time(new Date());
		service.insert(order);
		return index(new SearchInfo(),m);
	}
	
	@RequestMapping("edit")
	public String edit(int id,Model m) {
		m.addAttribute("info", service.getByid(id));
		return add(m);
	}
	
	@RequestMapping("update")
	public String update(My_order p,Model m,HttpServletRequest req) {
		service.update(p);
		return index(new SearchInfo(),m);
	}
	
	@RequestMapping("delete")
	public String delete(int id,Model m) {
		service.delete(id);
		return index(new SearchInfo(),m);
	}

}
