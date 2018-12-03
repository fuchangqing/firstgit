package com.grts.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.grts.dto.UserDto;
import com.grts.pojo.RoleBean;

public interface IRoleService {

	int deleteByPrimaryKey(Integer rid);

	int insert(RoleBean record);

	int insertSelective(RoleBean record);

	RoleBean selectByPrimaryKey(Integer rid);

	int updateByPrimaryKeySelective(RoleBean record);

	int updateByPrimaryKey(RoleBean record);

	List<RoleBean> query(UserDto dto);

	PageInfo<RoleBean> queryPage(UserDto dto);

	List<Integer> queryMidByRoleid(Integer rid);

	RoleBean selectByRolename(String rolename);

}
