package com.grts.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.grts.dao.CustomerBeanMapper;
import com.grts.pojo.CustomerBean;
import com.grts.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Resource
	private CustomerBeanMapper dao;

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CustomerBean customer) {
		// TODO Auto-generated method stub
		return dao.insert(customer);
	}

	@Override
	public int insertSelective(CustomerBean customer) {
		// TODO Auto-generated method stub
		return dao.insertSelective(customer);
	}

	@Override
	public CustomerBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CustomerBean customer) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(customer);
	}

	@Override
	public int updateByPrimaryKey(CustomerBean customer) {
		return dao.updateByPrimaryKey(customer);
	}

}
