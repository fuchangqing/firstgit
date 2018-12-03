package com.grts.dao;

import java.util.List;

import com.grts.dto.BaseUserRole;
import com.grts.dto.UserDto;
import com.grts.pojo.UserBean;

public interface UserBeanMapper {

	int deleteByPrimaryKey(Integer userid);

	int insert(UserBean record);

	int insertSelective(UserBean record);

	UserBean selectByPrimaryKey(Integer userid);

	int updateByPrimaryKeySelective(UserBean record);

	int updateByPrimaryKey(UserBean record);

	List<UserBean> query(UserDto dto);

	void saveUseridAndRoleid(BaseUserRole baseUserRole);

	List<Integer> queryRoleidByUserid(Integer userid);

	void deleteUserAndRoleById(Integer userid);

	UserBean selectByUsername(String username);
	
	List<UserBean> selectGroupUser(Integer did);
}