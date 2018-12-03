package com.grts.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grts.dto.UserDto;
import com.grts.pojo.RoleBean;

public interface RoleBeanMapper {
    
    int deleteByPrimaryKey(Integer rid);

    int insert(RoleBean record);

    int insertSelective(RoleBean record);

    RoleBean selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(RoleBean record);

    int updateByPrimaryKey(RoleBean record);
    
    List<RoleBean> query(UserDto dto);

	void saveRoleAndMenuById(@Param("rid")Integer rid, @Param("mid")Integer mid);


	void deleteRoleAndUserById(Integer rid);

	void deleteRoleAndMenuById(Integer rid);

	List<Integer> queryMidByRoleid(Integer rid);

	RoleBean selectByRolename(String rolename);

	int selectCountById(Integer rid);

	
}