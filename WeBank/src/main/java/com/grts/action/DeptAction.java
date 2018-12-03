package com.grts.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.grts.dto.UserDto;
import com.grts.pojo.DeptBean;
import com.grts.service.IDeptService;

@Controller
@RequestMapping("/dept")
public class DeptAction {

	@Resource
	private IDeptService deptService;
	
	@RequestMapping("/query")
	public String query(Model model,UserDto dto){
		PageInfo<DeptBean> page = deptService.queryPage(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		return "/WEB-INF/dept/deptlist.jsp";
		
	}
	
	@RequestMapping("/init")
	public String init(){
		
		return "/WEB-INF/dept/deptAddOrUpdate.jsp";
	}
	
	@RequestMapping("/validateDeptname")
	@ResponseBody
	public String validateDeptname(String name,HttpServletRequest request) throws UnsupportedEncodingException{
		name=URLDecoder.decode(request.getParameter("name"), "UTF-8");
		DeptBean dept= deptService.selectDeptByName(name);
		if(dept==null){
			return "ok";
		}else{
			return "no";
		}
	}
	@RequestMapping("/add")
	public String add(DeptBean dept){
		if(dept.getId()==null){
			deptService.insertSelective(dept);
		}else{
			deptService.updateByPrimaryKeySelective(dept);
		}		
		return "redirect:query";
	}
	
	@RequestMapping("delete")
	public String delete(Integer id){
		deptService.deleteByPrimaryKey(id);
		return "redirect:query";
	}
	
	@RequestMapping("queryUpdateById")
	public String queryUpdateById(Integer id,Model model){
		DeptBean dept = deptService.selectByPrimaryKey(id);
		model.addAttribute("dept", dept);
		return "/WEB-INF/dept/deptAddOrUpdate.jsp";
	}
	
}
