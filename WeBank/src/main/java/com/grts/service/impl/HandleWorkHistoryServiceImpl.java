package com.grts.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.grts.dao.HandleWorkHistoryBeanMapper;
import com.grts.pojo.HandleWorkHistoryBean;
import com.grts.pojo.WorkOrderBean;
import com.grts.service.IHandleWorkHistoryService;
@Service
public class HandleWorkHistoryServiceImpl implements IHandleWorkHistoryService {

	@Resource
	private HandleWorkHistoryBeanMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(HandleWorkHistoryBean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(HandleWorkHistoryBean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public HandleWorkHistoryBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(HandleWorkHistoryBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(HandleWorkHistoryBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<HandleWorkHistoryBean> queryBackHandleHistory(HandleWorkHistoryBean history) {
		// TODO Auto-generated method stub
		return dao.queryBackHandleHistory(history);
	}

	@Override
	public List<HandleWorkHistoryBean> query(HandleWorkHistoryBean history) {
		// TODO Auto-generated method stub
		return dao.query(history);
	}

}
