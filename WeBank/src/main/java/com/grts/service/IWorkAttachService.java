package com.grts.service;

import com.grts.pojo.WorkAttachBean;

public interface IWorkAttachService {
	int deleteByPrimaryKey(Integer id);
	
	int insert(WorkAttachBean record);
	
	int insertSelective(WorkAttachBean record);
	
	WorkAttachBean selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(WorkAttachBean record);
	
	int updateByPrimaryKey(WorkAttachBean record);
}
