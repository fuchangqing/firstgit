package com.grts.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.grts.dto.UserDto;
import com.grts.pojo.DataBean;

public interface IDataService {
	int deleteByPrimaryKey(Integer id);

	int insert(DataBean record);

	int insertSelective(DataBean record);

	DataBean selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DataBean record);

	int updateByPrimaryKey(DataBean record);

	List<DataBean> query(UserDto dto);
	
	PageInfo<DataBean> queryPage(UserDto dto);
	
	List<DataBean> queryProblem();
}
