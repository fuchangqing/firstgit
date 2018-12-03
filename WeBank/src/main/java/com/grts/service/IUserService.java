package com.grts.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.grts.dto.UserDto;
import com.grts.pojo.UserBean;

public interface IUserService {
	int deleteByPrimaryKey(Integer userid);

	int insert(UserBean record);

	int insertSelective(UserBean record);

	UserBean selectByPrimaryKey(Integer userid);

	int updateByPrimaryKeySelective(UserBean record);

	int updateByPrimaryKey(UserBean record);

	PageInfo<UserBean> query(UserDto dto);

	List<Integer> queryRoleidByUserid(Integer userid);

	UserBean selectByUsername(String username);
	
	List<UserBean> selectGroupUser(Integer did);

	UserBean login(String username, String password) ;
}
