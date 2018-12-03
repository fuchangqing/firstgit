package com.grts.dao;

import java.util.List;

import com.grts.dto.WorkOrderDto;
import com.grts.pojo.WorkOrderBean;

public interface WorkOrderBeanMapper {

	int deleteByPrimaryKey(String workorderid);

	int insert(WorkOrderBean record);

	int insertSelective(WorkOrderBean record);

	WorkOrderBean selectByPrimaryKey(String workorderid);

	int updateByPrimaryKeySelective(WorkOrderBean record);

	int updateByPrimaryKey(WorkOrderBean record);
	
	List<WorkOrderDto> query(WorkOrderDto dto);
}