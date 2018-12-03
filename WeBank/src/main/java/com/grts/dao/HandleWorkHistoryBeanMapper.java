package com.grts.dao;

import java.util.List;

import com.grts.pojo.HandleWorkHistoryBean;

public interface HandleWorkHistoryBeanMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(HandleWorkHistoryBean record);

	int insertSelective(HandleWorkHistoryBean record);

	HandleWorkHistoryBean selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(HandleWorkHistoryBean record);

	int updateByPrimaryKey(HandleWorkHistoryBean record);
	
	List<HandleWorkHistoryBean> queryBackHandleHistory(HandleWorkHistoryBean history);
	
	List<HandleWorkHistoryBean> query(HandleWorkHistoryBean history);
}