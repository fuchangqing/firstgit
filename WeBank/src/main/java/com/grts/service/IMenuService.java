package com.grts.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.grts.dto.UserDto;
import com.grts.pojo.MenuBean;

public interface IMenuService {

	int deleteByPrimaryKey(Integer mid);

	int insert(MenuBean record);

	int insertSelective(MenuBean record);

	MenuBean selectByPrimaryKey(Integer mid);

	int updateByPrimaryKeySelective(MenuBean record);

	int updateByPrimaryKey(MenuBean record);

	List<MenuBean> query(UserDto dto);
	
	PageInfo<MenuBean> queryPage(UserDto dto);
}
