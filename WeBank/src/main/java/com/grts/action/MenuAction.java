package com.grts.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.grts.dto.UserDto;
import com.grts.pojo.MenuBean;
import com.grts.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuAction {

	@Resource
	private IMenuService menuService;
	@RequestMapping("/query")
	public String query(Model model, UserDto dto) {
		PageInfo<MenuBean> page = menuService.queryPage(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		return "/WEB-INF/menu/menulist.jsp";
	}
	
	@RequestMapping("/init")
	public String init(Model model, UserDto dto) {
		
		return "/WEB-INF/menu/menuAddOrUpdate.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer mid) {
		menuService.deleteByPrimaryKey(mid);
		return "/WEB-INF/menu/menuAddOrUpdate.jsp";
	}
	
	@RequestMapping("/queryUpdateById")
	public String queryUpdateById(Integer mid,Model model) {
		MenuBean menu = menuService.selectByPrimaryKey(mid);
		model.addAttribute("menu", menu);
		return "/WEB-INF/menu/menuAddOrUpdate.jsp";
	}
}
