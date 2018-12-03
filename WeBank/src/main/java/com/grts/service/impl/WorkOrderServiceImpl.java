package com.grts.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grts.dao.CustomerBeanMapper;
import com.grts.dao.DeptBeanMapper;
import com.grts.dao.HandleWorkHistoryBeanMapper;
import com.grts.dao.UserBeanMapper;
import com.grts.dao.WorkAttachBeanMapper;
import com.grts.dao.WorkOrderBeanMapper;
import com.grts.dto.WorkOrderDto;
import com.grts.pojo.CustomerBean;
import com.grts.pojo.DeptBean;
import com.grts.pojo.HandleWorkHistoryBean;
import com.grts.pojo.UserBean;
import com.grts.pojo.WorkAttachBean;
import com.grts.pojo.WorkOrderBean;
import com.grts.service.IWorkOrderService;
import com.grts.utils.WebUtils;

@Service
public class WorkOrderServiceImpl implements IWorkOrderService {

	@Resource
	private WorkOrderBeanMapper dao;
	@Resource
	private CustomerBeanMapper cusDao;
	@Resource
	private WorkAttachBeanMapper waDao;
	@Resource
	private DeptBeanMapper deptDao;
	@Resource
	private HandleWorkHistoryBeanMapper hisDao;
	@Resource
	private UserBeanMapper userDao;

	@Override
	public int deleteByPrimaryKey(String workorderid) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(workorderid);
	}

	@Override
	public int insert(WorkOrderBean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(WorkOrderBean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public WorkOrderBean selectByPrimaryKey(String workorderid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(workorderid);
	}

	@Override
	public int updateByPrimaryKeySelective(WorkOrderBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(WorkOrderBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public PageInfo<WorkOrderDto> query(WorkOrderDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<WorkOrderDto> list = dao.query(dto);
		PageInfo<WorkOrderDto> page = new PageInfo<WorkOrderDto>(list);
		return page;
	}

	@Override
	public void save(WorkOrderBean wo, CustomerBean customer, List<WorkAttachBean> list,UserBean user) {
		cusDao.insertSelective(customer);
		wo.setCustomerid(customer.getId());
		String workorderid = WebUtils.createWorkOrderId();
		wo.setWorkorderid(workorderid);
		dao.insertSelective(wo);
		for (WorkAttachBean wa : list) {
			wa.setWorkid(wo.getWorkorderid());
			waDao.insertSelective(wa);
		}
		HandleWorkHistoryBean history = new HandleWorkHistoryBean();
		history.setWorkorderid(workorderid);
		history.setHandleperson(user.getUserid());
		history.setHandlepersonname(user.getUsername());
		history.setHandlegroup(user.getDid());
		DeptBean dept = deptDao.selectByPrimaryKey(user.getDid());
		history.setHandlegroupname(dept.getName());
		history.setDescs("创建工单");
		history.setActionstr("新建");
		hisDao.insertSelective(history);
	}

	@Override
	public void handlework(WorkOrderBean wo, UserBean user, String descs) {
		HandleWorkHistoryBean history = new HandleWorkHistoryBean();
		history.setWorkorderid(wo.getWorkorderid());
		history.setHandleperson(user.getUserid());
		history.setHandlepersonname(user.getUsername());
		history.setHandlegroup(user.getDid());
		DeptBean dept = deptDao.selectByPrimaryKey(user.getDid());
		history.setHandlegroupname(dept.getName());
		history.setDescs(descs);
		Integer status = wo.getStatus();		
		switch (status) {
		case 1:
			dao.updateByPrimaryKeySelective(wo);
			history.setActionstr("转办");
			break;

		case 2:
			history.setActionstr("归档");
			dao.updateByPrimaryKeySelective(wo);
			break;
		case 3:
			history.setActionstr("退单");
			wo.setHandleperson(wo.getHandleperson1());
			UserBean user1=userDao.selectByPrimaryKey(wo.getHandleperson());
			Integer deptid = user1.getDid();
			wo.setHandlegroup(deptid);
			dao.updateByPrimaryKeySelective(wo);
			break;
		case 4:
			history.setActionstr("挂起");
			dao.updateByPrimaryKeySelective(wo);
			break;
		default:
			break;
		}
		hisDao.insertSelective(history);
	}
}
