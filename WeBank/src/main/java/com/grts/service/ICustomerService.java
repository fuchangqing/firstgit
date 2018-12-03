package com.grts.service;

import com.grts.pojo.CustomerBean;

public interface ICustomerService {
	int deleteByPrimaryKey(Integer id);

	int insert(CustomerBean customer);

	int insertSelective(CustomerBean customer);

	CustomerBean selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CustomerBean customer);

	int updateByPrimaryKey(CustomerBean customer);
}
