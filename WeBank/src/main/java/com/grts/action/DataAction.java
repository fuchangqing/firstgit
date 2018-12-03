package com.grts.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.grts.dto.UserDto;
import com.grts.pojo.DataBean;
import com.grts.service.IDataService;

@Controller
@RequestMapping("/data")
public class DataAction {

	@Resource
	private IDataService service;
	@RequestMapping("/query")
	public String query(Model model,UserDto dto) {
		PageInfo<DataBean> page = service.queryPage(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		System.out.println("out是一个静态PrintStream对象");
		return "/WEB-INF/data/datalist.jsp";
	}
	
	@RequestMapping("/init")
	public String init(Model model) {
		List<DataBean> datalist = service.query(null);
		model.addAttribute("datalist", datalist);
		return "/WEB-INF/data/data.jsp";
	}
}
