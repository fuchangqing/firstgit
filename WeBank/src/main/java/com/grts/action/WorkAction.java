package com.grts.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.grts.dto.WorkOrderDto;
import com.grts.pojo.CustomerBean;
import com.grts.pojo.DataBean;
import com.grts.pojo.DeptBean;
import com.grts.pojo.HandleWorkHistoryBean;
import com.grts.pojo.UserBean;
import com.grts.pojo.WorkAttachBean;
import com.grts.pojo.WorkOrderBean;
import com.grts.service.ICustomerService;
import com.grts.service.IDataService;
import com.grts.service.IDeptService;
import com.grts.service.IHandleWorkHistoryService;
import com.grts.service.IUserService;
import com.grts.service.IWorkOrderService;
import com.grts.utils.WebUtils;

@Controller
@RequestMapping("/work")
public class WorkAction {

	@Resource
	private IWorkOrderService woService;
	@Resource
	private IDataService dataService;
	@Resource
	private IDeptService deptService;
	@Resource
	private IUserService userService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private IHandleWorkHistoryService historyService;
	private List<WorkAttachBean> list;

	@RequestMapping("/init")
	public String init(Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		UserBean user = getUser();
		List<DataBean> datalist = dataService.query(null);
		List<DeptBean> deptlist = deptService.query(null);
		model.addAttribute("datalist", datalist);
		model.addAttribute("deptlist", deptlist);
		return "/WEB-INF/work/createWorkOrder.jsp";
	}

	@RequestMapping("/save")
	public String save(CustomerBean customer, WorkOrderBean wo, MultipartFile[] upload, HttpSession session) {
		list = new ArrayList<WorkAttachBean>();
		if (upload != null) {
			for (MultipartFile file : upload) {
				if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
					WorkAttachBean wa = new WorkAttachBean();
					String oldFileName = file.getOriginalFilename();
					String newFileName = WebUtils.createFileName() + "."
							+ oldFileName.substring(oldFileName.lastIndexOf(".") + 1);
					File newFile = new File("E:\\ceshi\\upload\\" + newFileName);
					try {
						file.transferTo(newFile);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					wa.setOldfilename(oldFileName);
					wa.setNewfilename(newFileName);
					list.add(wa);
				}
			}
		}
		UserBean user = getUser();
		woService.save(wo, customer, list, user);
		return "/WEB-INF/work/createWorkOrder.jsp";
	}

	@RequestMapping("/handlerWork")
	public String handlerWork(WorkOrderBean wo, String descs, HttpSession session) {
		UserBean user = getUser();
		woService.handlework(wo, user, descs);
		return "/WEB-INF/work/handlerWorkOrder.jsp";
	}

	@RequestMapping("/handlerInfo")
	public String handlerInfo(String id, Model model, HttpSession session) {
		WorkOrderBean wo = woService.selectByPrimaryKey(id);
		model.addAttribute("wo", wo);
		UserBean handleperson = userService.selectByPrimaryKey(wo.getHandleperson());
		String personname = handleperson.getUsername();
		DeptBean handlegroup = deptService.selectByPrimaryKey(wo.getHandlegroup());
		String groupname = handlegroup.getName();
		model.addAttribute("personname", personname);
		model.addAttribute("groupname", groupname);
		CustomerBean cus = customerService.selectByPrimaryKey(wo.getCustomerid());
		model.addAttribute("cus", cus);
		List<DeptBean> deptlist = deptService.query(null);
		model.addAttribute("deptlist", deptlist);
		List<DataBean> datalist = dataService.query(null);
		model.addAttribute("datalist", datalist);
		UserBean user = getUser();
		session.setAttribute("LOGIN_USER", user);
		HandleWorkHistoryBean history = new HandleWorkHistoryBean();
		history.setWorkorderid(id);
		history.setHandleperson(user.getUserid());
		List<HandleWorkHistoryBean> historylist = historyService.queryBackHandleHistory(history);
		model.addAttribute("historylist", historylist);
		List<HandleWorkHistoryBean> historys = historyService.query(history);
		model.addAttribute("historys", historys);
		return "/WEB-INF/work/handlerWorkOrder.jsp";
	}

	@RequestMapping("/getHandlePerson")
	@ResponseBody
	public List<UserBean> getHandlePerson(Integer did) {
		List<UserBean> userlist = userService.selectGroupUser(did);
		return userlist;
	}

	@RequestMapping("/query")
	public String query(WorkOrderDto dto, Model model) {
		PageInfo<WorkOrderDto> page = woService.query(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		model.addAttribute("task", "query");
		List<DeptBean> deptlist = deptService.query(null);
		List<DataBean> datalist = dataService.queryProblem();
		model.addAttribute("deptlist", deptlist);
		model.addAttribute("datalist", datalist);
		return "/WEB-INF/work/worklist.jsp";
	}

	@RequestMapping("/queryNo")
	public String queryNo(WorkOrderDto dto, Model model) {
		dto.getWo().setStatus(0);
		PageInfo<WorkOrderDto> page = woService.query(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		model.addAttribute("task", "queryNo");
		return "/WEB-INF/work/worklist.jsp";
	}

	@RequestMapping("/queryMy")
	public String queryMy(WorkOrderDto dto, Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		UserBean user = getUser();
		WorkOrderBean wo = new WorkOrderBean();
		wo.setHandleperson(user.getUserid());
		dto.setWo(wo);
		PageInfo<WorkOrderDto> page = woService.query(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		model.addAttribute("task", "queryMy");
		return "/WEB-INF/work/worklist.jsp";
	}

	private UserBean getUser() {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipals().getPrimaryPrincipal();
		UserBean user = userService.selectByUsername(username);
		return user;
	}

	@RequestMapping("/queryGroup")
	public String queryGroup(WorkOrderDto dto, Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		UserBean user = getUser();
		WorkOrderBean wo = new WorkOrderBean();
		wo.setHandlegroup(user.getDid());
		dto.setWo(wo);
		PageInfo<WorkOrderDto> page = woService.query(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		model.addAttribute("task", "queryGroup");
		return "/WEB-INF/work/worklist.jsp";
	}

	@RequestMapping("/groupBack")
	public String groupBack(WorkOrderDto dto, Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		UserBean user = getUser();
		WorkOrderBean wo = new WorkOrderBean();
		wo.setHandlegroup(user.getDid());
		dto.setWo(wo);
		dto.getWo().setStatus(3);
		PageInfo<WorkOrderDto> page = woService.query(dto);
		model.addAttribute("pageModel", page);
		model.addAttribute("dto", dto);
		model.addAttribute("task", "groupBack");
		return "/WEB-INF/work/worklist.jsp";
	}

}
