package com.grts.dao;

import java.util.List;

import com.grts.dto.UserDto;
import com.grts.pojo.DeptBean;

public interface DeptBeanMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(DeptBean record);

	int insertSelective(DeptBean record);

	DeptBean selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DeptBean record);

	int updateByPrimaryKey(DeptBean record);

	List<DeptBean> query(UserDto dto);

	DeptBean selectDeptByName(String name);

}