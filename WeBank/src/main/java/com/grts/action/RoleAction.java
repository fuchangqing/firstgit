package com.grts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.grts.dto.UserDto;
import com.grts.pojo.MenuBean;
import com.grts.pojo.RoleBean;
import com.grts.service.IMenuService;
import com.grts.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleAction {

	@Resource
	private IRoleService roleService;
	@Resource
	private IMenuService menuService;

	@RequestMapping("/query")
	public String query(Model model, UserDto dto) {
		PageInfo<RoleBean> page = roleService.queryPage(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		return "/WEB-INF/role/rolelist.jsp";
	}

	@RequestMapping("/init")
	public String init(Model model) {
		List<MenuBean> menuList = menuService.query(null);
		model.addAttribute("menuList", menuList);
		return "/WEB-INF/role/roleAddOrUpdate.jsp";
	}

	@RequestMapping("/add")
	public String add(RoleBean role) {
		if (role.getRid() == null) {
			roleService.insertSelective(role);
		} else {
			roleService.updateByPrimaryKeySelective(role);
		}
		return "redirect:query";
	}

	@RequestMapping("/validateRolename")
	@ResponseBody
	public String validateRolename(String rolename, HttpServletRequest request) throws UnsupportedEncodingException {
		rolename = URLDecoder.decode(request.getParameter("rolename"), "UTF-8");
		RoleBean role = roleService.selectByRolename(rolename);
		if (role != null) {
			return "no";
		} else {
			return "ok";
		}
	}

	@RequestMapping("/delete")
	public void delete(Integer rid,HttpServletRequest request,HttpServletResponse response) throws IOException {		
		int num = roleService.deleteByPrimaryKey(rid);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<script type='text/javascript'>");
		if(num==1){
			out.append("alert('该角色正在被用户使用，不能删除');");
		}else{
			out.append("alert('删除成功');");
		}
		out.append("window.location.href='"+request.getContextPath()+"/role/query'");
		out.append("</script>");
	}

	@RequestMapping("/queryUpdateById")
	public String queryUpdateById(Integer rid, Model model) {
		RoleBean role = roleService.selectByPrimaryKey(rid);
		List<Integer> midList = roleService.queryMidByRoleid(rid);
		role.setMids(midList);
		List<MenuBean> menuList = menuService.query(null);
		model.addAttribute("menuList", menuList);
		model.addAttribute("role", role);
		return "/WEB-INF/role/roleAddOrUpdate.jsp";
	}

	@RequestMapping("update")
	public String update(RoleBean role) {
		roleService.updateByPrimaryKeySelective(role);
		return "redirect:query";
	}

}
