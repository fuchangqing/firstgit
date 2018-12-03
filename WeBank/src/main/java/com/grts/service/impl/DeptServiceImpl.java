package com.grts.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grts.dao.DeptBeanMapper;
import com.grts.dto.UserDto;
import com.grts.pojo.DeptBean;
import com.grts.service.IDeptService;
@Service
public class DeptServiceImpl implements IDeptService {

	@Resource
	private DeptBeanMapper dao;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		dao.deleteByPrimaryKey(id);
		return 0;
	}

	@Override
	public int insert(DeptBean record) {
		dao.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(DeptBean record) {
		dao.insertSelective(record);
		return 0;
	}

	@Override
	public DeptBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DeptBean record) {
		dao.updateByPrimaryKeySelective(record);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(DeptBean record) {
		dao.updateByPrimaryKey(record);
		return 0;
	}

	@Override
	public PageInfo<DeptBean> queryPage(UserDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<DeptBean> list = dao.query(dto);
		PageInfo<DeptBean> page=new PageInfo<>(list);
		return page;
	}

	public List<DeptBean> query(UserDto dto){
		
		return dao.query(dto);
	}

	@Override
	public DeptBean selectDeptByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectDeptByName(name);
	}
}
