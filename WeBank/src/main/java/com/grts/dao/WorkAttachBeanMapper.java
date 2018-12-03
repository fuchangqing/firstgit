package com.grts.dao;

import com.grts.pojo.WorkAttachBean;

public interface WorkAttachBeanMapper {

int deleteByPrimaryKey(Integer id);
	
	int insert(WorkAttachBean record);
	
	int insertSelective(WorkAttachBean record);
	
	WorkAttachBean selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(WorkAttachBean record);
	
	int updateByPrimaryKey(WorkAttachBean record);
}