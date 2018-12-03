package com.grts.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grts.dao.MenuBeanMapper;
import com.grts.dto.UserDto;
import com.grts.pojo.MenuBean;
import com.grts.service.IMenuService;
@Controller
public class MenuServiceImpl implements IMenuService {

	@Resource
	private MenuBeanMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer mid) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(mid);
	}

	@Override
	public int insert(MenuBean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(MenuBean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public MenuBean selectByPrimaryKey(Integer mid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(mid);
	}

	@Override
	public int updateByPrimaryKeySelective(MenuBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MenuBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<MenuBean> query(UserDto dto) {
		// TODO Auto-generated method stub
		return dao.query(dto);
	}

	public PageInfo<MenuBean> queryPage(UserDto dto){
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<MenuBean> mlist = dao.query(dto);
		PageInfo<MenuBean> page=new PageInfo<>(mlist);
		return page;
		
	}
}
