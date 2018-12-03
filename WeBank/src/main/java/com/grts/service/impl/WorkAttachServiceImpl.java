package com.grts.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.grts.dao.WorkAttachBeanMapper;
import com.grts.pojo.WorkAttachBean;
import com.grts.service.IWorkAttachService;
@Service
public class WorkAttachServiceImpl implements IWorkAttachService {

	@Resource
	private WorkAttachBeanMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(WorkAttachBean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(WorkAttachBean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public WorkAttachBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WorkAttachBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(WorkAttachBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

}
