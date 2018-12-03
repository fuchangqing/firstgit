package com.grts.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.grts.dto.UserDto;
import com.grts.pojo.DeptBean;
import com.grts.pojo.RoleBean;
import com.grts.pojo.UserBean;
import com.grts.service.IDeptService;
import com.grts.service.IRoleService;
import com.grts.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	@Resource
	private IUserService userService;
	@Resource
	private IDeptService deptService;
	@Resource
	private IRoleService roleService;
	@RequestMapping("/query")
	@RequiresPermissions("USER_QUERY")
	public String query(Model model, UserDto dto) {
		PageInfo<UserBean> page = userService.query(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		return "/WEB-INF/user/userlist.jsp";
	}

	@RequestMapping("/init")
	@RequiresPermissions("USER_CREATE")
	public String init(Model model) {
		List<DeptBean> deptList = deptService.query(null);
		List<RoleBean> roleList = roleService.query(null);
		model.addAttribute("deptList", deptList);
		model.addAttribute("roleList", roleList);
		return "/WEB-INF/user/userAddOrUpdate.jsp";
	}
	
	@RequestMapping("/add")
	@RequiresPermissions("USER_CREATE")
	public String add(UserBean user) {
		if(user.getUserid()==null){
			userService.insertSelective(user);	
		}else{
			userService.updateByPrimaryKeySelective(user);
		}
			
		return "redirect:/user/query";
	}
	
	@RequestMapping("/queryUpdateById")
	@RequiresPermissions("USER_UPDATE")
	public String queryUpdateById(Integer userid,Model model){
		UserBean user = userService.selectByPrimaryKey(userid);
		List<Integer> roleidList=userService.queryRoleidByUserid(userid);
		user.setRids(roleidList);
		List<DeptBean> deptList = deptService.query(null);
		List<RoleBean> roleList = roleService.query(null);
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		model.addAttribute("roleList", roleList);
		return "/WEB-INF/user/userAddOrUpdate.jsp";
	}
	
	@RequestMapping("/delete")
	@RequiresPermissions("USER_DELETE")
	public String delete(Integer userid){
		userService.deleteByPrimaryKey(userid);
		return "redirect:query";
	}
	
	@RequestMapping("/validateUsername")
	@ResponseBody
	public String validateUsername(String username){
		UserBean user= userService.selectByUsername(username);
		if(user!=null){
			return "no";
		}else{
			return "ok";
		}		
	}
}
