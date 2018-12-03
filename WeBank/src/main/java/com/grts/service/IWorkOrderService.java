package com.grts.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.grts.dto.WorkOrderDto;
import com.grts.pojo.CustomerBean;
import com.grts.pojo.UserBean;
import com.grts.pojo.WorkAttachBean;
import com.grts.pojo.WorkOrderBean;

public interface IWorkOrderService {


	int deleteByPrimaryKey(String workorderid);

	int insert(WorkOrderBean record);

	int insertSelective(WorkOrderBean record);

	WorkOrderBean selectByPrimaryKey(String workorderid);

	int updateByPrimaryKeySelective(WorkOrderBean record);

	int updateByPrimaryKey(WorkOrderBean record);
	
	PageInfo<WorkOrderDto> query(WorkOrderDto dto);

	void save(WorkOrderBean wo, CustomerBean customer, List<WorkAttachBean> list, UserBean user);

	void handlework(WorkOrderBean wo, UserBean user, String descs);
}
